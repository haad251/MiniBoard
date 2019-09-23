package my.batis.practice.vo;

public class Reply {
	private String reply_seq, board_seq, id, content, indate;

	public Reply(String reply_seq, String board_seq, String id, String content, String indate) {
		super();
		this.reply_seq = reply_seq;
		this.board_seq = board_seq;
		this.id = id;
		this.content=content;
		this.indate = indate;
	}

	public Reply() {
		super();
	}

	public String getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(String reply_seq) {
		this.reply_seq = reply_seq;
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
		return "Reply [reply_seq=" + reply_seq + ", board_seq=" + board_seq + ", id=" + id + ", content=" + content
				+ ", indate=" + indate + "]";
	}

	
	
	
	
}
