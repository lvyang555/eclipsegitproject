package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DriverDao;
import entity.Car;
import entity.Driver;
import util.DBUtil;

public class DriverDaoimpl implements DriverDao{

	@Override
	public int insertOne(Driver driver) {
		String sql ="insert into driver_list(name,phone,age,driver_code) values(?,?,?,?)";
		Object[] objs= {
				driver.getName(),driver.getPhone(),driver.getAge(),driver.getDirverCode()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Driver> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from driver_list ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Driver> list =new ArrayList<Driver>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Driver driver =new Driver(rs.getInt("did"), rs.getString("name"), rs.getString("phone"), rs.getInt("age"),rs.getString("driver_code"));
				list.add(driver);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
	}

	@Override
	public int deleteOne(int id) {
		String sql = "delete from driver_list where did=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(Driver driver) {
		String sql = "update driver_list set name=?,phone=?,age=?,driver_code=?where did=?";
		Object[] objs = { driver.getName(),driver.getPhone(),driver.getAge(),driver.getDirverCode(),driver.getDid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	
	public Driver selectOne(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from driver_list where did= ? ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		Driver driver=null;
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				driver =new Driver(rs.getInt("did"), rs.getString("name"), rs.getString("phone"), rs.getInt("age"),rs.getString("driver_code"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return driver;
	}
	

}
