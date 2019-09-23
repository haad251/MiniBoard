package my.batis.practice.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.batis.practice.util.PageNavigator;
import my.batis.practice.vo.Board;
import my.batis.practice.vo.FileVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession session;
	

	public int insertBoard(Board board){
		System.out.println(board);
		int result = 0;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.insertBoard(board);
			}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	
	
	public ArrayList<Board> selectAllBoard(PageNavigator navi){
		ArrayList<Board> result = new ArrayList<Board>();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try{
			RowBounds rb = new RowBounds(navi.getStartRecord(),navi.getCountPerPage());
			
			result = mapper.selectAllBoard(rb);

		}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	

	public Board selectBoard(String board_sql){
		Board result=null;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.selectBoard(board_sql);
			}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	
	public int deleteBoard(String board_seq){
		int result = 0;
		try{
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		result = mapper.deleteBoard(board_seq);
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		return result;
	}
	

	public int updateBoard(Board board){
		int result = 0;
		try{
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		result = mapper.updateBoard(board);
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public int selectCount(String keyword){
		int result = 0;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.selectCount(keyword);					
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public ArrayList<Board> searchBoard(String keyword,PageNavigator navi){
		ArrayList<Board> result = new ArrayList<Board>();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try{
			RowBounds rb = new RowBounds(navi.getStartRecord(),navi.getCountPerPage());
			result = mapper.searchBoard(rb, keyword);
		}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	

	public int insertFile(FileVO fvo){
		System.out.println("파일인서트dao");
		int result = 0;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.insertFile(fvo);
			System.out.println(result);
			}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	
	public FileVO selectFile(String board_seq){
		FileVO result=null;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.selectFile(board_seq);
			}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	

	public FileVO selectFileBySeq(String file_seq){
		FileVO result=null;
		try{
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			result = mapper.selectFileBySeq(file_seq);
			}catch(Exception e ){
			e.printStackTrace();
			return result;
		}		
		return result;
	}
	
//	public int selectSearchCount(String keyword){
//		int result = 0;
//		try{
//			BoardMapper mapper = session.getMapper(BoardMapper.class);
//			result = mapper.selectSearchCount(keyword);					
//		}catch(Exception e){
//			e.printStackTrace();
//			return result;
//		}
//		return result;
//	}
	
	
	
}
