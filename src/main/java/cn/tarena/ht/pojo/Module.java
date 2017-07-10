package cn.tarena.ht.pojo;

public class Module extends BaseEntity {

	private String moduleId;
	private Module parentModule;
	private String name;
	private Integer ctype;
	private Integer state;
	private Integer orderNo;
	private String remark;
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", parentModule=" + parentModule + ", name=" + name + ", ctype=" + ctype
				+ ", state=" + state + ", orderNo=" + orderNo + ", remark=" + remark + "]";
	}
	
	
}
