package my.batis.practice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import my.batis.practice.service.BoardService;
import my.batis.practice.service.ReplyService;
import my.batis.practice.util.PageNavigator;
import my.batis.practice.vo.Board;
import my.batis.practice.vo.FileVO;

@Controller
public class BoardController {
	
	
	
	@Autowired
	BoardService bService;
	@Autowired
	ReplyService rService;
	
	final static int COUNTPERPAGE = 5;
	final static int PAGEPERGROUP = 3;
	final static String UPLOADPATH = "D:/File/";
	
	
	@RequestMapping(value="/goBoardform", method=RequestMethod.GET)
	public String goBoardform(){
		return "redirect:/getBoard";
	}
	
	@RequestMapping(value = "/getBoard", method = RequestMethod.GET)
	public String getBoard(String board_seq, Model model,
			@RequestParam(value="page",defaultValue="1") int page) {
		
		PageNavigator navi = new PageNavigator
				(COUNTPERPAGE,PAGEPERGROUP,page,bService.selectCount(null));
	
		ArrayList<Board> bList = bService.selectAllBoard(navi);
		Board board = bService.selectBoard(board_seq);
		FileVO file = bService.selectFile(board_seq);
		
		model.addAttribute("board",board);
		model.addAttribute("bList",bList);
		model.addAttribute("navi",navi);
		model.addAttribute("file",file);
		ArrayList<HashMap<String,String>> rList = rService.selectReply(board_seq);
		model.addAttribute("rList",rList);

		return "board";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(Board board, Model model, HttpSession session, MultipartFile uploadFile) {
		board.setId(session.getAttribute("loginId").toString());
		int result = bService.insertBoard(board);

		if (!(uploadFile.isEmpty() || uploadFile == null || uploadFile.getSize() == 0)) {
			String org_name = uploadFile.getOriginalFilename();
			Date date = new Date();
			String sav_name = date.getTime() + org_name;

			try {
				uploadFile.transferTo(new File(UPLOADPATH + sav_name));
			
				FileVO fvo = new FileVO();
				fvo.setOrg_name(org_name);
				fvo.setSav_name(sav_name);
				bService.insertFile(fvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/getBoard";
	}
	
	@RequestMapping(value="/goWrite", method=RequestMethod.GET)
	public String goWrite(Model model,Board board){
		model.addAttribute("board",board);
		return "boardWrite";
	}

	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(String board_seq,Model model){
		int resultreply = rService.deleteAllReplyByBoard(board_seq);
		int result = bService.deleteBoard(board_seq);
		return "redirect:/getBoard";
	}
	

	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(Model model,Board board){
		int result = bService.updateBoard(board);
		return "redirect:/getBoard";
	}
	
	@RequestMapping(value="/searchBoard", method=RequestMethod.GET)
	public String searchBoard(String board_seq, String keyword, Model model,@RequestParam(value="page",defaultValue="1") int page){
		PageNavigator navi = new PageNavigator(COUNTPERPAGE, PAGEPERGROUP, page, bService.selectCount(keyword));
		ArrayList<Board> bList = bService.searchBoard(keyword,navi);
		Board board = bService.selectBoard(board_seq);
		model.addAttribute("board",board);
		model.addAttribute("bList", bList);
		model.addAttribute("navi", navi);
		model.addAttribute("keyword",keyword);
		
		return "board";
	}
	
	@RequestMapping(value="/fileDownload", method=RequestMethod.GET)
	public String fileDownload(String file_seq, HttpServletResponse response){

		FileVO fvo = bService.selectFileBySeq(file_seq);
	
		
		response.setHeader("Content-Disposition", "attachment;filename="+fvo.getOrg_name());
		
		File file = new File(UPLOADPATH + fvo.getSav_name());
		try{
			
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream sos = response.getOutputStream();
			FileCopyUtils.copy(fis,sos); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/getBoard";
	}
}
