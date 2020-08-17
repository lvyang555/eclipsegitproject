package dao;

import entity.User;

public interface UserDao {
	
	int insertOne(User user);

	User findOne(String name, String pwd);
	
	boolean findOne(String name);
	User selectUser(int id);
	

}
