package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAll();
	/**
	 * 修改用户状态
	 * @param userIds
	 * @param state
	 */
	public void updateState(String[] userIds, int state);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<UserInfo> findAllUserInfo();
	/**
	 * 增加用户
	 * @param user
	 */
	public void insertUser(User user);
	/**
	 * 查询除当前用户外组成的上级领导集合
	 * @param userId
	 * @return
	 */
	public List<UserInfo> findManagers(String userId);
	/**
	 * 查询对应id的用户
	 * @param userId
	 * @return
	 */
	public User findUser(String userId);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 删除指定用户
	 * @param userId
	 */
	public void deleteUser(String[] userIds);
	/**
	 * 保存用户角色
	 * @param userId
	 * @param roleIds
	 */
	public void saveUserRole(String userId, String[] roleIds);
	
	public User findUserByUserName(String userName);

}
