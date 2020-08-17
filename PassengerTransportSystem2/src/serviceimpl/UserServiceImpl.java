package serviceimpl;

import dao.UserDao;
import daoimpl.UserDaoimpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	public UserDao ud =new UserDaoimpl();
	@Override
	public int register(User user) {
		if(ud.findOne(user.getUsername())) {
			return 0;
		}
		else {
			if(ud.insertOne(user)>=1) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public User login(String name, String pwd) {
		if(ud.findOne(name, pwd)!=null) {
			return ud.findOne(name, pwd);
		}
		return null;
	}

	@Override
	public User selectUser(int id) {
		
		return ud.selectUser(id);
	}

}
