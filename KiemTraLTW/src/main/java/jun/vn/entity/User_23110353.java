package jun.vn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User_23110353 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // int tự tăng
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username", length = 50, columnDefinition = "nvarchar(50)")
    private String username;

    @Column(name = "email", length = 100, columnDefinition = "nvarchar(100)")
    private String email;

    @Column(name = "fullname", length = 50, columnDefinition = "nvarchar(50)")
    private String fullname;

    @Column(name = "password", length = 50, columnDefinition = "nvarchar(50)")
    private String password;

    @Column(name = "images", length = 500, columnDefinition = "nvarchar(500)")
    private String images;

    @Column(name = "phone", length = 20, columnDefinition = "nvarchar(20)")
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "code", length = 50, columnDefinition = "nvarchar(50)")
    private String code;

    @Column(name = "is_seller")
    private Boolean isSeller;
	
	// Nhiều user có thể thuộc 1 role
	@ManyToOne
	@JoinColumn(name = "roleId")
	private UserRoles_23110353 role;

	public User_23110353(Integer userId, String username, String email, String fullname, String password, String images,
			String phone, Integer status, String code, Boolean isSeller, UserRoles_23110353 role) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.images = images;
		this.phone = phone;
		this.status = status;
		this.code = code;
		this.isSeller = isSeller;
		this.role = role;
	}
	
	public User_23110353() {
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(Boolean isSeller) {
		this.isSeller = isSeller;
	}

	public UserRoles_23110353 getRole() {
		return role;
	}

	public void setRole(UserRoles_23110353 role) {
		this.role = role;
	}
}
