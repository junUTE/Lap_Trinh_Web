package jun.vn.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRoles_23110353 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable = false, length = 100)
    private String roleName;

    // Một role có thể gán cho nhiều user
    @OneToMany(mappedBy = "role")
    private List<User_23110353> users;

	public UserRoles_23110353(Integer roleId, String roleName, List<User_23110353> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
	}

	public UserRoles_23110353() {
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User_23110353> getUsers() {
		return users;
	}

	public void setUsers(List<User_23110353> users) {
		this.users = users;
	}
}