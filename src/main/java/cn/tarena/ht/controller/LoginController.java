package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session){
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			model.addAttribute("erroInfo", "用户名或密码不能为空");
			return "/sysadmin/login/login";
		}
		
		Subject subject=SecurityUtils.getSubject();
		
		UsernamePasswordToken token= new UsernamePasswordToken(userName,password);
		
		try {
			subject.login(token);
			User user=(User) subject.getPrincipal();
			session.setAttribute("sessionUser", user);
			return "redirect:/home.action";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			model.addAttribute("erroInfo", "用户名或密码错误");
			return "/sysadmin/login/login";
		}
	}
	
}
