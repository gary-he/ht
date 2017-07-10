package cn.tarena.ht.pojo;

public class Role extends BaseEntity {
	private String roleId;
	private String name;
	private String remarks;
	private Integer orderNo;
	//实现ztree被选中功能
	private boolean checked;
	
	/**
	 * ztree树根据get方法获取属性，需要提供getId方法
	 */
	public String getId(){
		return roleId;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", remarks=" + remarks + ", orderNo=" + orderNo + "]";
	}
	
	
}
