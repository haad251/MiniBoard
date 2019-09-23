package my.batis.practice.service;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.batis.practice.dao.ReplyDAO;
import my.batis.practice.vo.Reply;

@Service
public class ReplyService {

	@Autowired
	ReplyDAO dao;
	
	public int insertReply(Reply reply){
		return dao.insertReply(reply);
	}
	
	public ArrayList<HashMap<String,String>> selectReply(String board_seq){
		return dao.selectReply(board_seq);
	}

	public int deleteReply(Reply reply){
		return dao.deleteReply(reply);
	}
	
	public int deleteAllReplyById(String id){
		return dao.deleteAllReplyById(id);
	}	
	
	public int deleteAllReplyByBoard(String board_seq){
		return dao.deleteAllReplyByBoard(board_seq);
	}	
	
	
}
