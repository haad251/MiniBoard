package my.batis.practice.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.batis.practice.util.PageNavigator;
import my.batis.practice.vo.Board;
import my.batis.practice.vo.Reply;

@Repository
public class ReplyDAO {

	@Autowired
	SqlSession session;
	
	public int insertReply(Reply reply){
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.insertReply(reply);
		return result;
	}
	
	public ArrayList<HashMap<String,String>> selectReply(String board_seq){
		ArrayList<HashMap<String,String>> result = null;
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		try{
		result = mapper.selectReply(board_seq);
		return result;
		}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
	}	
	

	public int deleteReply(Reply reply){
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.deleteReply(reply);
		return result;
	}
	

	public int deleteAllReplyById(String id){
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.deleteAllReplyById(id);
		return result;
	}
	

	public int deleteAllReplyByBoard(String board_seq){
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		int result = mapper.deleteAllReplyByBoard(board_seq);
		return result;
	}
}
