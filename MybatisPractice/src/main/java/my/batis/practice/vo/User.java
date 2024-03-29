package my.batis.practice.vo;

public class User {

	private String id,pw,name,phone,email,birthdate,indate;

	public User(String id, String pw, String name, String phone, String email, String birthdate, String indate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.indate = indate;
	}

	
	public User() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", birthdate=" + birthdate + ", indate=" + indate + "]";
	}
	
	
}
