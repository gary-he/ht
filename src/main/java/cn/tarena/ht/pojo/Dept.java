package cn.tarena.ht.pojo;

public class Dept extends BaseEntity {
	private Dept parentDept;//一对一关联封装
	private String deptId;
	private String deptName;
	private Integer state;//0表示停用，1表示启用
	
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Dept [parentDept=" + parentDept + ", deptId=" + deptId + ", deptName=" + deptName + ", state=" + state
				+ "]";
	}
	
	
}
