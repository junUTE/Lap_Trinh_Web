package quoctrung.models;

public class UserModel {
	private static final long serialVersionUID = 1L;

	private int id;
	private String email;
	private String userName;
	private String fullName;
	private String passWord;
	private String phone;

	public UserModel() {
		super();
	}

	public UserModel(int id, String userName, String fullName,String email, String phone, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.passWord = passWord;
	}

	public UserModel(String userName, String fullName,String email, String phone, String passWord) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", passWord=" + passWord + ", phone=" + phone + "]";
	}
}
