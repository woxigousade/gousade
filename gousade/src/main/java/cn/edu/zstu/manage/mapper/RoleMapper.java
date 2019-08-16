package cn.edu.zstu.manage.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.zstu.manage.pojo.Menu;
import cn.edu.zstu.manage.pojo.User;


public interface RoleMapper {

	/**
	 * 查询用户列表
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryrolelist(Map<String, Object> map);
	/**
	 * 新增角色
	 * @param map
	 * @return
	 */
	public int insertrole(Map<String, Object> map);
	
	/**
	 * 根据ID修改角色信息
	 * @param map
	 * @return
	 */
	public int updaterole(Map<String, Object> map);
	
	/**
	 * 根据ID删除角色信息
	 * @param map
	 * @return
	 */
	public int delroles(Map<String, Object> map);
	
	/**
	 * 查询菜单列表
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> querymenulist(Map<String, Object> map);
	
	
	/**
	 * 根据ID修改菜单信息
	 * @param map
	 * @return
	 */
	public int updatemenu(Map<String, Object> map);

	/**
	 * 根据ID删除菜单信息
	 * @param map
	 * @return
	 */
	public int delmenus(Map<String, Object> map);
	
}
