package jun.dao;

import jun.entities.User;


public interface UserDao {
	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	User login(String username, String password);
	
	boolean updatePasswordByEmail(String email, String newPassword);
	
	boolean update(User user);

	void insert(User user);

	User findByEmail(String email);

	User findById(int id);
}