package jun.services;

import jun.entities.User;

public interface UserService {

	void insert(User user);

	boolean register(String userName, String fullName, String email, String phone, String password);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	User login(String username, String password);

	boolean updatePasswordByEmail(String email, String newPassword);

}
