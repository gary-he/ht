package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	/**
	 * 查询全部部门信息
	 * @return
	 */
	public List<Dept> findAll();
	/**
	 * 修改状态，通过注解将参数封装为map
	 * @param deptIds
	 * @param state
	 */
	public void updateState(@Param("deptIds")String[] deptIds, @Param("state")int state);
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
	 * 查询除了当前部门外组成的所有上级部门集合
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
