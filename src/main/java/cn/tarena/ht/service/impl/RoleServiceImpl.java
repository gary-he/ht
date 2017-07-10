package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public void saveRole(Role role) {
		String roleId=UUID.randomUUID().toString();
		role.setRoleId(roleId);
		role.setCreateTime(new Date());
		System.out.println(role);
		roleMapper.insertRole(role);
	}

	@Override
	public Role findRole(String roleId) {
		return roleMapper.findOne(roleId);
	}

	@Override
	public void updateRole(Role role) {
		role.setUpdateTime(new Date());
		roleMapper.updateRole(role);
	}

	@Override
	public void deleteRole(String[] roleIds) {
		roleMapper.deleteRole(roleIds);
	}

	@Override
	public List<String> findUserRoleId(String userId) {
		return roleMapper.findUserRoleId(userId);
	}

}
