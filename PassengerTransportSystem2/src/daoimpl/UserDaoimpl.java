package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import util.DBUtil;


public class UserDaoimpl implements UserDao{

	@Override
	public int insertOne(User user) {
		String sql ="insert into user_list(username,password)values(?,?)";
		Object[] objs= { user.getUsername(),user.getPassword()};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public User findOne(String name, String pwd) {
		
		Connection connection =DBUtil.getConnection();
		String sql ="select * from user_list where username=?and password=?";
		PreparedStatement pstmt =DBUtil.getPreparedStatement(connection, sql);
		ResultSet rs=null;
		User user=null;
		
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("uid"),rs.getString("username"),rs.getString("password"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, connection);
		}
		
		return user;
		
	
	}

	@Override
	public boolean findOne(String name) {
		Connection connection =DBUtil.getConnection();
		String sql ="select * from user_list where username=?";
		PreparedStatement pstmt =DBUtil.getPreparedStatement(connection, sql);
		ResultSet rs=null;
		
		try {
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, connection);
		}
		
		return false;
	}

	@Override
	public User selectUser(int id) {
		Connection connection =DBUtil.getConnection();
		String sql ="select * from user_list where uid=?";
		PreparedStatement pstmt =DBUtil.getPreparedStatement(connection, sql);
		ResultSet rs=null;
		User user=null;
		try {
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("uid"),rs.getString("username"),rs.getString("password"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, connection);
		}
		
		return user;
	}

}
