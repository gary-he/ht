package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Dept> findAll();
	/**
	 * 修改部门状态
	 * @param deptIds
	 * @param state
	 */
	public void updateState(String[] deptIds, int state);
	/**
	 * 删除部门
	 * @param deptIds
	 */
	public void deleteDepts(String[] deptIds);
	/**
	 * 查询对应id的部门
	 * @param deptId
	 * @return
	 */
	public Dept findOne(String deptId);
	/**
	 * 查询除当前部门外组成的所有上级部门集合
	 * @return
	 */
	public List<Dept> findParents();
	/**
	 * 修改部门信息
	 * @param dept
	 */
	public void updateDept(Dept dept);
	/**
	 * 增加部门
	 * @param dept
	 */
	public void saveDept(Dept dept);
}
