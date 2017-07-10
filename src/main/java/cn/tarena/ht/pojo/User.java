package cn.tarena.ht.pojo;

public class User extends BaseEntity {
	private String userId;
	private Dept dept;
	private String username;
	private String password;
	private Integer state;
	private UserInfo userInfo;//用户拓展信息一对一
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userneme) {
		this.username = userneme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", dept=" + dept + ", username=" + username + ", password=" + password
				+ ", state=" + state + ", userInfo=" + userInfo + "]";
	}
	
	
	
}
