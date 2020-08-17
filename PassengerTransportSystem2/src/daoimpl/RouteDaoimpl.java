package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RouteDao;
import entity.Order;
import entity.Route;
import util.DBUtil;

public class RouteDaoimpl implements RouteDao{

	@Override
	public int insertOne(Route route) {
		String sql ="insert into route_list(route_name,price) values(?,?)";
		Object[] objs= {
				route.getRouteName(),route.getPrice()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Route> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from route_list ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Route> list =new ArrayList<Route>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Route route =new Route(rs.getInt("rid"),rs.getString("route_name"),rs.getInt("price"));
				list.add(route);	
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
		String sql = "delete from route_list where rid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(Route route) {
		String sql = "update route_list set route_name=?,price=? where rid=?";
		Object[] objs = {route.getRouteName(),route.getPrice(),route.getRid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public Route selectone(Route r) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from route_list where route_name=? and price=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		
		
		ResultSet rs =null;
		Route route =null;
		try {
			ps.setString(1, r.getRouteName());
			ps.setInt(2, r.getPrice());
			rs=ps.executeQuery();
			if(rs.next()) {
				route =new Route(rs.getInt("rid"),rs.getString("route_name"),rs.getInt("price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return route;
	}
	
	
	public Route selectRoute(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from route_list where rid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		Route route =null;
		try {
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()) {
				route =new Route(rs.getInt("rid"),rs.getString("route_name"),rs.getInt("price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return route;
	}

}
