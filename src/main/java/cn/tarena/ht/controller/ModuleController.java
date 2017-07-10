package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Module> moduleList=moduleService.findAll();
		model.addAttribute("moduleList", moduleList);
		return "/sysadmin/module/jModuleList";
	}
	
}
