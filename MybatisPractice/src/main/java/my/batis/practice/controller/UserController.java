package my.batis.practice.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.batis.practice.service.UserService;
import my.batis.practice.vo.User;

@Controller
public class UserController {

	@Autowired
	UserService uService;
	
	
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginform(){
		return "login";
	}
	
	
	@RequestMapping(value = "/insertUser", method=RequestMethod.POST)
	public String insertUser(User user,Model model){
		int result = uService.insertUser(user);
		if(result!=1){
			model.addAttribute("message","duplicated");
			model.addAttribute("User",user);
			return "home";
		}
		return "login";
	}
	
	@RequestMapping(value="/selectUser", method=RequestMethod.POST)
	public String selectUser(User user, Model model, HttpSession session){
		User result = uService.selectUser(user);	
		if(result!=null){
			model.addAttribute(result);
			session.setAttribute("loginId",result.getId());
		}else {
			model.addAttribute("message","retry");
			return "login";
		}
		return "menu";
	}
	

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(User user, Model model, HttpSession session){
		session.setAttribute("loginId", null);
		return "login";
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	public String deleteUser(Model model,String id){
		System.out.println(id);
		int result = uService.deleteUser(id);
		if(result!=1){
			return "menu";
		}else {
			return "home";
		}
	}
	
	@RequestMapping(value="/goUpdateUserform", method=RequestMethod.GET)
	public String goUpdateUserform(){
		return "updateUser";
	}
		
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(User user, Model model,String id){
		int result = uService.updateUser(user);
		return "menu";
	}
}
