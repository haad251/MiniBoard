package my.batis.practice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.batis.practice.service.ReplyService;
import my.batis.practice.vo.Reply;

@Controller
public class ReplyController {

	@Autowired
	ReplyService cService;
	
	
	@RequestMapping(value="/insertReply", method=RequestMethod.POST)
	public String insertReply(Reply reply,Model model,RedirectAttributes rdab,
		@RequestParam(value="page",defaultValue="1") int page,String board_seq,
		@RequestParam(value="dept",defaultValue="1") int dept
			){
		
		int result = cService.insertReply(reply);
		
	    rdab.addAttribute("page",page);
	    rdab.addAttribute("board_seq",board_seq);
	    
		return "redirect:/getBoard";
	}
	
	@RequestMapping(value="/deleteReply", method=RequestMethod.POST)
	public String deleteReply(Reply reply,Model model,RedirectAttributes rdab,
			@RequestParam(value="page",defaultValue="1") int page,String board_seq){
		int result = cService.deleteReply(reply);
	  
		rdab.addAttribute("page",page);
	    rdab.addAttribute("board_seq",board_seq);
	    
		return "redirect:/getBoard";
	}
	
	
}
