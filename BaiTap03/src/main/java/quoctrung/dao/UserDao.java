package quoctrung.dao;

import quoctrung.models.UserModel;

public interface UserDao {
	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	UserModel login(String username, String password);
	
	boolean updatePasswordByEmail(String email, String newPassword);
}