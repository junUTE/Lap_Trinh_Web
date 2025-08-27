package quoctrung.jun.dao;

import quoctrung.jun.moleds.UserModel;

public interface UserDao {
	UserModel findByUserName(String username);
}
