package service;

import entity.User;

public interface UserService {
	int register(User user);
	
	User login(String name,String pwd);
	User selectUser(int id);

}
