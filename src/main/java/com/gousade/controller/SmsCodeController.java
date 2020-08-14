package com.gousade.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.exceptions.ClientException;
import com.gousade.config.ShiroRealm;
import com.gousade.controller.common.BaseController;
import com.gousade.pojo.User;
import com.gousade.redis.RedisUtil;
import com.gousade.service.UserService;
import com.gousade.utils.SaltUtil;
import com.gousade.utils.SmsCodeUtil;

/**
* @author woxigsd@gmail.com
* @date 2020-8-14 11:05:31
* Description:
*/
@RestController
@RequestMapping(value = "/admin/smsCode")
public class SmsCodeController extends BaseController{
	
	@Autowired
	private SmsCodeUtil smsCodeUtil;
	
	@Resource
    private RedisUtil redisUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShiroRealm shiroRealm;
	
	@RequestMapping(value="/sendSmsCode",method=RequestMethod.POST)
	public Object sendSmsCode(String phoneNumber) throws ClientException{
		return smsCodeUtil.sendSmsCode(phoneNumber);
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public Object validate(String checkCode,User user) {
		Object redisGetSentCode =redisUtil.get(user.getPhoneNumber());
		if(redisGetSentCode == null) {
			return renderError("验证码已失效，请重新获取。");
		}else {
			if(redisGetSentCode.toString().equals(checkCode)) {
				user.setId(getShiroSessionUser() != null?getShiroSessionUser().getId():user.getId());
				user.setSalt(SaltUtil.getUUId());
				user.setPassword(SaltUtil.toHex(user.getPassword(), user.getSalt()));
				/*Cache<Object,AuthenticationInfo> authentication=shiroRealm.getAuthenticationCache();
				if (authentication!=null){
					authentication.remove(user.getId());
				}*/
				return userService.updateOwnPasswordById(user)?renderSuccess("重置密码成功。"):renderError("重置密码失败。");
			}else {
				return renderError("验证码错误，请重新输入。");
			}
		}
	}
	
}
