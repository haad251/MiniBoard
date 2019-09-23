package my.batis.practice.vo;

public class FileVO {
	private String file_seq, board_seq, org_name, sav_name;

	public FileVO() {
		super();
	}

	public FileVO(String file_seq, String board_seq, String org_name, String sav_name) {
		super();
		this.file_seq = file_seq;
		this.board_seq = board_seq;
		this.org_name = org_name;
		this.sav_name = sav_name;
	}

	public String getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getSav_name() {
		return sav_name;
	}

	public void setSav_name(String sav_name) {
		this.sav_name = sav_name;
	}

	@Override
	public String toString() {
		return "FileVO [file_seq=" + file_seq + ", board_seq=" + board_seq + ", org_name=" + org_name + ", sav_name="
				+ sav_name + "]";
	}
	
	
	
	

	
}
