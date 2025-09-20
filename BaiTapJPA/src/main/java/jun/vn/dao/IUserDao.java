package jun.vn.dao;

import java.util.List;

import jun.vn.entity.User;

public interface IUserDao {

	User findByUserName(String userName);

	List<User> findAll();

	User findById(int id);

	void delete(int id);

	void update(User user);

	User login(String username, String password);

	boolean register(User user);

	boolean checkExistUsername(String userName);

	boolean checkExistEmail(String email);

}
