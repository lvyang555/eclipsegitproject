package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CarDao;
import entity.Car;
import util.DBUtil;

public class CarDaoimpl implements CarDao{

	@Override
	public int insertOne(Car car) {
		String sql ="insert into car_type(model_name,seat_num,car_num) values(?,?,?)";
		Object[] objs= {
				car.getModelName(),car.getSeatNum(),car.getCarNum()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Car> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from car_type ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Car> list =new ArrayList<Car>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Car car =new Car(rs.getInt("mid"), rs.getString("model_name"), rs.getInt("seat_num"), rs.getInt("car_num"));
				list.add(car);	
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
		
		String sql = "delete from car_type where mid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;

	}

	@Override
	public int updateOne(Car car) {
		String sql = "update car_type set model_name=?,seat_num=?,car_num=? where mid = ?";
		Object[] objs = { car.getModelName(),car.getSeatNum(),car.getCarNum(),car.getMid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	
	public Car selectOne(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from car_type where mid="+id;
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		Car car=null;
		try {
			rs=ps.executeQuery();
			if(rs.next()) {
				car =new Car(rs.getInt("mid"), rs.getString("model_name"), rs.getInt("seat_num"), rs.getInt("car_num"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return car;
	}
	public int selectCar(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from car_type where mid="+id;
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		int flag=0;
		try {
			rs=ps.executeQuery();
			if(rs.next()) {
				flag=1;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return flag;
	}

}
