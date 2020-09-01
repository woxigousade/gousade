package com.gousade.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gousade.annotation.OperationRecord;
import com.gousade.controller.common.BaseController;
import com.gousade.pojo.User;
import com.gousade.pojo.util.AttachmentGeneral;
import com.gousade.service.AttachmentGeneralService;
import com.gousade.service.UserService;
import com.gousade.utils.AttachmentUtil;
import com.gousade.utils.DataTablesPageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags="用户管理")
@Slf4j
@CacheConfig(cacheNames="redis@Cacheable")
@RestController//添加restcontroller注解之后，return"main"不能再返回main.jsp，需要改写成ModelAndView mv = new ModelAndView("main"); return mv;
@RequestMapping(value = "/admin/sysUser")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AttachmentGeneralService attachmentGeneralService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/loginShiroUser",method = RequestMethod.POST)
	public Object loginShiroUser(@RequestParam(value="userId") String userId,
			@RequestParam(value="password") String password,@RequestParam(value = "rememberMe", defaultValue = "0") String rememberMe,
			Model model,HttpServletRequest request) {
    	UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userId,password);
    	Subject subject = SecurityUtils.getSubject();
    	ModelAndView loginmv = new ModelAndView("login");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
    		subject.login(usernamePasswordToken);   //完成shiro登录验证
    		User user=(User) subject.getPrincipal();
			result.put("status", true);
			String url =request.getContextPath() + "/admin/index";
			log.info(url);
			result.put("msg", "/admin/index");//{}特殊符号要转义
//    		ModelAndView mv = new ModelAndView("redirect:/admin/index");
//    		return mv;
        }catch(UnknownAccountException uae){
            log.info("对用户[" + userId + "]进行登录验证..验证未通过,未知账户");
			result.put("status", false);
			result.put("msg", "账号不存在");
        }catch(IncorrectCredentialsException ice){
            log.info("对用户[" + userId + "]进行登录验证..验证未通过,错误的凭证");
			result.put("status", false);
			result.put("msg", "密码不正确");
            /*request.setAttribute("msg", "密码不正确");
			return renderError("密码不正确");*/
        }catch(LockedAccountException lae){
            log.info("对用户[" + userId + "]进行登录验证..验证未通过,账户已锁定");
			result.put("status", false);
			result.put("msg", "账号被锁定");
        }catch(ExcessiveAttemptsException eae){
            log.info("对用户[" + userId + "]进行登录验证..验证未通过,错误次数过多");
			result.put("status", false);
			result.put("msg", "密码错误错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            log.info("对用户[" + userId + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
			result.put("status", false);
			result.put("msg", "用户名或密码不正确");
        }
		return result;
	}
	
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public Object logout(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            res.put("status", true);
            res.put("msg", "退出成功");
        } catch (Exception e) {
            res.put("status", false);
        }
		return res;
	}
	
	/**
	 * 注册用户
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/ShiroRegist",method=RequestMethod.POST)
	public Map<String,Object> ShiroRegist(@RequestBody Map<String,Object> map){				
		return userService.ShiroRegist(map);
		}
	
	/**
	 * 注册用户
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public Map<String,Object> regist(@RequestBody Map<String,Object> map){				
		return userService.regist(map);
		}
	
	@ApiOperation(value = "获取用户列表", notes = "查询用户列表")
	@RequestMapping(value="/selectUserList",method=RequestMethod.POST)
	public DataTablesPageUtil<User> selectUserList(HttpServletRequest request){
		DataTablesPageUtil<User> dataTables = new DataTablesPageUtil<User>(request);
		dataTables = userService.selectUserList(dataTables);
		return dataTables;
	}
	
	@ApiOperation("用户详情")
	@RequestMapping(value="/selectByPrimaryKey",method=RequestMethod.POST)
	@Cacheable/*(value="redis@Cacheable")*/
	public User selectByPrimaryKey(String id){
		User user = userService.selectByPrimaryKey(id);
		return user;
	}

	@ApiOperation(value = "创建或编辑用户", notes = "根据User对象创建或编辑用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "phoneNumber", value = "手机号", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "roleIds", value = "角色", required = false, dataTypeClass = String.class, paramType = "query")
    })
	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public Object userEdit(@ApiIgnore User user){
		boolean b=false;
		if(user.getId()==null||"".equals(user.getId())){
			b = userService.insert(user);
		}else {
			b = userService.updateUserById(user);
		}
		return renderBoolean(b);
	}
	
	@CacheEvict(allEntries=true,beforeInvocation=true)
	@RequestMapping(value="/deleteUserByid",method=RequestMethod.POST)
	public Object deleteUserByid(@ApiParam(name="map",value="map中包含要删除的用户id") @RequestParam Map<String,Object> map){
		boolean b = userService.deleteUserByid(map);
		return renderBoolean(b);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@OperationRecord(operationNum=1,operationDescription="上传头像")
	@RequestMapping(value = "/userAvatorUpload", method = RequestMethod.POST)
	public Object userAvatorUpload(@RequestParam(value = "attachments") MultipartFile attachments) throws IOException {
		String filType = attachments.getOriginalFilename().substring(attachments.getOriginalFilename().lastIndexOf('.') + 1).toLowerCase();
		String[] imageTypes={"jpg","png","bmp","gif","jpeg"};
		List<String> imageTyepLists=Arrays.asList(imageTypes);
		if(!imageTyepLists.contains(filType)) {
			return renderError("上传的文件格式不符，请重新上传。");
		}
		if(attachments.getOriginalFilename() != "") {
			AttachmentGeneral attachmentGeneral = AttachmentUtil.AttachmentUpload(attachments);
			User user = getShiroSessionUser();
			attachmentGeneral.setAttachId(user.getId());
			attachmentGeneralService.save(attachmentGeneral);
			attachmentGeneral.setId(user.getId());
			userService.uploadUserAvatar(attachmentGeneral);
		}
		return renderSuccess("上传头像成功");
	}
	
	@OperationRecord(operationNum=2,operationDescription="获取头像")
	@RequestMapping(value="/getUserAvatar",method=RequestMethod.GET)
	public void getUserAvatar(HttpServletResponse response,HttpServletRequest request){
		User user = getShiroSessionUser();
		userService.getUserAvatar(response, request, user);
	}
	
	@RequiresRoles({"超级管理员"})
	@RequiresPermissions({"/admin/user/userManage","/admin/user/tabs"})
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public Object fileUpload(@RequestParam(value = "attachments") MultipartFile[] attachments) throws IOException {
		if (attachments.length > 0 && attachments[0].getOriginalFilename() != "") {
			for (int i = 0; i < attachments.length; i++) {
				AttachmentGeneral attachmentGeneral = AttachmentUtil.AttachmentUpload(attachments[i]);
				attachmentGeneralService.save(attachmentGeneral);
			}
		}
		return renderSuccess("操作成功");
	}
	
	/**
	 * @param response
	 * @throws IOException
	 * 两种方法都可下载 但是上面的方法似乎不能识别中文和空格文件名？ 之后再测试 注意前端form的提交方式 不能用ajax
	 */
	@RequestMapping(value = "/fileDownload", method = RequestMethod.POST)
	public void fileDownload(HttpServletResponse response) throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateDtr = df.format(new Date());
		String filename = "食驚第一暗帝 永恒之海(灵宝：时间真理).png";
		String path = "D:"+File.separator+"gousadeFiles"+File.separator+"generalfile" + File.separator+dateDtr+File.separator+filename;
		File file = new File(path);
//		response.reset();
//        response.setContentType("application/force-download");
//        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
//        byte[] buffer = new byte[1024];
//        try (FileInputStream fis = new FileInputStream(file);
//        BufferedInputStream bis = new BufferedInputStream(fis)) {
//        	OutputStream os = response.getOutputStream();
//            int i = bis.read(buffer);
//            while (i != -1) {
//                os.write(buffer, 0, i);
//                i = bis.read(buffer);
//            }
//        }
		InputStream fis = new BufferedInputStream(new FileInputStream(path));
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		// 清空response
		response.reset();
		// 设置response的Header
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + new String(filename.getBytes("gb2312"), "ISO8859-1"));
		response.addHeader("Content-Length", "" + file.length());

		OutputStream toClient = new BufferedOutputStream(response.getOutputStream());

		toClient.write(buffer);
		toClient.flush();
		toClient.close();
	}
	
}
