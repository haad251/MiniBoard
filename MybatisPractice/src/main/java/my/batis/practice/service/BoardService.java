package my.batis.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.batis.practice.dao.BoardDAO;
import my.batis.practice.util.PageNavigator;
import my.batis.practice.vo.Board;
import my.batis.practice.vo.FileVO;

@Service
public class BoardService {
	@Autowired
	BoardDAO dao;
	
	public int insertBoard(Board board){
		return dao.insertBoard(board);
	}
	
	public ArrayList<Board> selectAllBoard(PageNavigator navi){
		return dao.selectAllBoard(navi);
	}
	
	public Board selectBoard(String board_sql){
		return dao.selectBoard(board_sql);
	}
	
	public int deleteBoard(String board_seq){
		return dao.deleteBoard(board_seq);
	}
	
	public int updateBoard(Board board){
		return dao.updateBoard(board);
	}
	
	public int selectCount(String keyword){
		return dao.selectCount(keyword);
	}
	
	public ArrayList<Board> searchBoard(String keyword,PageNavigator navi){
		return dao.searchBoard(keyword, navi);		
	}
	
	
	public int insertFile(FileVO fvo){
		return dao.insertFile(fvo);
	}
	
	public FileVO selectFile(String board_seq){
		return dao.selectFile(board_seq);
	}
	
	public FileVO selectFileBySeq(String file_seq) {
		return dao.selectFileBySeq(file_seq);

	}
	
}
