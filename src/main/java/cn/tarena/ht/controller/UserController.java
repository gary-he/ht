package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<User> userList=userService.findAll();
		model.addAttribute("userList", userList);
		return "/sysadmin/user/jUserList";
		
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="userId")String[] userIds,Model model){
		int state=0;
		userService.updateState(userIds,state);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="userId")String[] userIds,Model model){
		int state=1;
		userService.updateState(userIds,state);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		//信息回显
		//准备上级部门信息
		List<Dept> deptList=deptService.findParents();
		//准备上级领导信息
		List<UserInfo> userInfoList=userService.findAllUserInfo();
		//添加日期插件
		model.addAttribute("deptList", deptList);
		model.addAttribute("userInfoList", userInfoList);
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("/save")
	public String saveUser(User user,Model model){
		userService.insertUser(user);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(String userId,Model model){
		//准备部门信息
		List<Dept> deptList=deptService.findParents();
		//上级领导（通过sql去除自己）
		List<UserInfo> managerList=userService.findManagers(userId);
		//根据uderId准备用户信息
		User user=userService.findUser(userId);
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		model.addAttribute("user", user);
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("/update")
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam(value="userId",required=true)String[] userIds){
		userService.deleteUser(userIds);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/toview")
	public String toView(String userId,Model model){
		User user=userService.findUser(userId);
		model.addAttribute("user", user);
		return "/sysadmin/user/jUserView";
	}
	
	@RequestMapping("/role")
	public String userRole(String userId,Model model) throws JsonProcessingException{
		List<Role> roleList=roleService.findAll();
		//用户角色数据回显
		List<String> userRoleIdList=roleService.findUserRoleId(userId);
		for(Role role:roleList){
			if(userRoleIdList.contains(role.getRoleId())){
				//用户拥有当前角色，根据zTree需求设置checked属性为true
				role.setChecked(true);
			}
		}
		//将roleList转化为json字符串
		ObjectMapper om=new ObjectMapper();
		String zTreeJson=om.writeValueAsString(roleList);
		model.addAttribute("userId", userId);
		model.addAttribute("zTreeJson", zTreeJson);
		return "/sysadmin/user/jUserRole";
	}
	
	@RequestMapping("/saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		userService.saveUserRole(userId,roleIds);
		return "redirect:/sysadmin/user/list";
	}
	
}
