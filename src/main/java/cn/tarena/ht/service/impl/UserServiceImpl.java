package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public void updateState(String[] userIds, int state) {
		userMapper.updateState(userIds,state);
	}

	@Override
	public List<UserInfo> findAllUserInfo() {
		return userInfoMapper.findAll();
	}

	@Override
	public void insertUser(User user) {
		//应将user表和userInfo表同事入库，如果中间有异常，则同时回滚
		//用UUID类生成用户id
		String userId=UUID.randomUUID().toString();
		//生成添加时间
		Date createTime=new Date();
		//获取用户信息
		UserInfo info=user.getUserInfo();
		//设置参数
		user.setUserId(userId);
		user.setCreateTime(createTime);
		info.setUserInfoId(userId);
		info.setCreateTime(createTime);
		
		userMapper.insertUser(user);
		userInfoMapper.insertUserInfo(info);
	}

	@Override
	public List<UserInfo> findManagers(String userId) {
		return userInfoMapper.findManagers(userId);
	}

	@Override
	public User findUser(String userId) {
		return userMapper.findOne(userId);
	}

	@Override
	public void updateUser(User user) {
		//更新user_p和user_info_p表
		UserInfo userInfo=user.getUserInfo();
		user.setUpdateTime(new Date());
		userInfo.setUpdateTime(new Date());
		
		userMapper.updateUser(user);
		userInfoMapper.updateUserInfo(userInfo);
	}

	@Override
	public void deleteUser(String[] userIds) {
		//删除user_p表和user_info_p表对应记录
		userMapper.deleteUser(userIds);
		userInfoMapper.deleteUserInfo(userIds);
	}

	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		//先删除当前用户的所有角色信息，再插入更新后的角色信息
		userMapper.deleteUserRoleByUserId(userId);
		//循环遍历实现批量插入
		for(String roleId:roleIds){
			userMapper.saveUserRole(userId,roleId);
		}
	}

	@Override
	public User findUserByUserName(String userName) {
		return userMapper.findUserByUserName(userName);
	}


}
