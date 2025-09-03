
package trungvu.jun.dao;

import trungvu.jun.models.UserModel;

public interface UserDao {
	void insert(UserModel user);
	
	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
