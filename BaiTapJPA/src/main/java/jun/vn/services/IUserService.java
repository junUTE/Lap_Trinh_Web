package jun.vn.services;

import java.util.List;

import jun.vn.entity.User;

public interface IUserService {
	User findByUserName(String userName);

	List<User> findAll();

	User findById(int id);

	void delete(int id);

	void update(User user);

	User login(String username, String password);

	boolean register(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String userName);
}
