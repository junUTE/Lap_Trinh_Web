package jun.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Không được bỏ trống")
	@Column(name = "userName")
	private String userName;

	@Column(name = "hoTen")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "passWord")
	private String passWord;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "role", columnDefinition = "INT")
	private int role;

	public User() {
	}

	public User(int id, String userName, String fullName, String email, String sdt, String passWord, String avatar) {
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.sdt = sdt;
		this.passWord = passWord;
		this.avatar = avatar;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setImages(String string) {

	}

}
