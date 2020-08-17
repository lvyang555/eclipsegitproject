package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entity.Driver;
import entity.Order;
import util.DBUtil;

public class OrderDaoimpl implements OrderDao{

	@Override
	public int insertOne(Order order) {
		String sql ="insert into order_list(uid,tid,time) values(?,?,?)";
		Object[] objs= {
				order.getUid(),order.getTid(),order.getTime()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Order> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from order_list ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Order> list =new ArrayList<Order>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Order order =new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("tid"),rs.getInt("status"), rs.getString("time"));
				list.add(order);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
	}
	public List<Order> selectUserAll(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from order_list where uid =?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Order> list =new ArrayList<Order>();
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Order order =new Order(rs.getInt("oid"),rs.getInt("uid"),rs.getInt("tid"),rs.getInt("status"), rs.getString("time"));
				list.add(order);	
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
		String sql = "delete from order_list where oid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(Order order) {
		String sql = "update order_list set uid=?,tid=?,status=?,time=?where oid=?";
		Object[] objs = {order.getUid(),order.getTid(),order.getStatues(),order.getTime(),order.getOid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	public int UpdateOrder(int id) {
		String sql = "update order_list set status = 0 where oid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

}
