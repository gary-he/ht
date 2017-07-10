package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<Role> findAll();
	/**
	 * 增加角色
	 * @param role
	 */
	public void saveRole(Role role);
	/**
	 * 查询对应的角色
	 * @param roleId
	 * @return
	 */
	public Role findRole(String roleId);
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
	 * 查询对应用户的全部角色id
	 * @param userId
	 * @return
	 */
	public List<String> findUserRoleId(String userId);

}
