package jun.vn.model;

import lombok.Data;

@Data
public class Login {
	private String usernameOrEmail;
	private String password;
}
