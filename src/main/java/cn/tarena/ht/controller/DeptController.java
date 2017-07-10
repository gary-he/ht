package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Dept> deptList=deptService.findAll();
		model.addAttribute("deptList", deptList);
		return "sysadmin/dept/jDeptList";
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="deptId",required=true) String[] deptIds){
		//状态修改 0表示停用，1表示启用
		int state=0;
		deptService.updateState(deptIds,state);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="deptId",required=true)String[] deptIds){
		int state=1;
		deptService.updateState(deptIds, state);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/delete")
	public String toDelete(@RequestParam(value="deptId",required=true)String[] deptIds){
		deptService.deleteDepts(deptIds);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(String deptId,Model model){
		System.out.println(deptId);
		//准备部门信息
		Dept dept=deptService.findOne(deptId);
		//准备上级部门信息
		List<Dept> parentList=deptService.findParents();
		model.addAttribute("dept", dept);
		model.addAttribute("parentList", parentList);
		return "sysadmin/dept/jDeptUpdate";
	}
	
	@RequestMapping("/update")
	public String UpdateDept(Dept dept){
		deptService.updateDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		List<Dept> parentList=deptService.findParents();
		model.addAttribute("parentList", parentList);
		return "sysadmin/dept/jDeptCreate";
	}
	
	@RequestMapping("/save")
	public String saveDept(Dept dept){
		deptService.saveDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/toview")
	public String toView(String deptId,Model model){
		Dept dept=deptService.findOne(deptId);
		model.addAttribute("dept", dept);
		return "sysadmin/dept/jDeptView";
	}
}
