package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;

public interface UserMapper {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> findAll();
	/**
	 * 修改用户状态
	 * @param state 
	 * @param userIds 
	 */
	public void updateState(@Param("userIds")String[] userIds, @Param("state")int state);
	/**
	 * 增加用户
	 * @param user
	 */
	public void insertUser(User user);
	/**
	 * 查询对应id的用户
	 * @param userId
	 * @return
	 */
	public User findOne(String userId);
	/**
	 * 修改用户
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 删除指定用户
	 * @param userId
	 */
	public void deleteUser(String[] userIds);
	/**
	 * 删除对应用户的所有角色信息
	 * @param userId
	 */
	public void deleteUserRoleByUserId(String userId);
	/**
	 * 插入对应用户的角色信息
	 * @param userId
	 * @param roleId
	 */
	public void saveUserRole(@Param("userId")String userId, @Param("roleId")String roleId);
	
	public User findUserByUserName(String userName);
	
}
