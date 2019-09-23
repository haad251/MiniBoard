package my.batis.practice.dao;

import java.util.ArrayList;
import java.util.HashMap;

import my.batis.practice.vo.Reply;

public interface ReplyMapper {
	public int insertReply(Reply reply);
	public ArrayList<HashMap<String,String>> selectReply(String board_seq);
	public int deleteReply(Reply reply);
	public int deleteAllReplyById(String id);
	public int deleteAllReplyByBoard(String board_seq);
}
