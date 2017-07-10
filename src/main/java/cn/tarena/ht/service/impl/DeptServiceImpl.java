package cn.tarena.ht.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;
	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}
	@Override
	public void updateState(String[] deptIds, int state) {
		deptMapper.updateState(deptIds,state);
	}
	@Override
	public void deleteDepts(String[] deptIds) {
		deptMapper.deleteDepts(deptIds);
	}
	@Override
	public Dept findOne(String deptId) {
		return deptMapper.findOne(deptId);
	}
	@Override
	public List<Dept> findParents() {
		return deptMapper.findParents();
	}
	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
	}
	@Override
	public void saveDept(Dept dept) {
		deptMapper.saveDept(dept);
	}

}
