package quoctrung.jun.services;

import quoctrung.jun.moleds.UserModel;

public interface UserService {
	UserModel login(String username, String password);
	UserModel findByUserName(String username);
}
