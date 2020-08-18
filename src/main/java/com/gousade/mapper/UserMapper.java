package com.gousade.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.gousade.pojo.Menu;
import com.gousade.pojo.User;
import com.gousade.pojo.util.AttachmentGeneral;

public interface UserMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(User record);


    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
	
	public User SelectUserByLoginName(String userId);

	public int regist(Map<String, Object> map);

	public List<Map<String, Object>> queryuserlist(Map<String, Object> paraMap);
	
	@Cacheable(value="redis@Cacheable")
	public List<User> selectUserList(Map<String, Object> searchMap);
	
	public long queryuserlistcnt(Map<String, Object> map);
	
	/**
	 * 根据角色ID获取菜单
	 */
	public List<Menu> listMenuByRoleId(Map<String, Object> map);
	
	public Map<String, Object> getroleidByuid(Map<String, Object> map);
	
	/**
	 * 更新登录时间	 
	 */
	public int updateLoginTime(String id);

	public int updateUserById(User entity);

	int deleteUserByid(Map<String, Object> map);

	int uploadUserAvatar(AttachmentGeneral attachmentGeneral);

	int updateOwnPasswordById(User user);

}
