package my.batis.practice.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import my.batis.practice.vo.Board;
import my.batis.practice.vo.FileVO;

public interface BoardMapper {

	public int insertBoard(Board board);
	public ArrayList<Board> selectAllBoard(RowBounds rb);
	public Board selectBoard(String board_seq);
	public int deleteBoard(String board_seq);
	public int updateBoard(Board board);
	public int selectCount(String keyword);
	public ArrayList<Board> searchBoard(RowBounds rb , String keyword);
	public int insertFile(FileVO fvo);
	public FileVO selectFile(String board_seq);
	public FileVO selectFileBySeq(String file_seq);

}
