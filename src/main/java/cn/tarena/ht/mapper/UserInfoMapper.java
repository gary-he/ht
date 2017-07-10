package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<UserInfo> findAll();
	/**
	 * 增加用户信息
	 * @param info
	 */
	public void insertUserInfo(UserInfo info);
	/**
	 * 查询除当前用户外组成的上级领导集合
	 * @param userId
	 * @return
	 */
	public List<UserInfo> findManagers(String userId);
	/**
	 * 修改用户信息
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	/**
	 * 删除指定用户信息
	 * @param userId
	 */
	public void deleteUserInfo(String[] userIds);
	
}
