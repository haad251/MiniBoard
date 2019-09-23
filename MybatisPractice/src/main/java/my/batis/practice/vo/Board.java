package my.batis.practice.vo;

public class Board {
	String board_seq, id, title, content, indate;

	public Board() {
		super();
	}

	public Board(String board_seq, String id, String title, String content, String indate) {
		super();
		this.board_seq = board_seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.indate = indate;
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Board [board_seq=" + board_seq + ", id=" + id + ", title=" + title + ", content=" + content + ", indate="
				+ indate + "]";
	}
	
	
	
}
