package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<Role> findAll();
	/**
	 * 增加角色
	 * @param role
	 */
	public void insertRole(Role role);
	/**
	 * 查询对应角色
	 * @param roleId
	 * @return
	 */
	public Role findOne(String roleId);
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateRole(Role role);
	/**
	 * 删除角色
	 * @param roleIds
	 */
	public void deleteRole(String[] roleIds);
	/**
	 * 查询对应用户全部角色id
	 * @param userId
	 * @return
	 */
	public List<String> findUserRoleId(String userId);

}
