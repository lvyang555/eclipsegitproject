package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.RouteStationDao;
import entity.Route;
import entity.RouteStation;
import util.DBUtil;

public class RouteStationDaoimpl implements RouteStationDao{

	@Override
	public int insertOne(RouteStation rs) {
		String sql ="insert into route_station(rid,sid) values(?,?)";
		Object[] objs= {
				rs.getRid(),rs.getSid()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int insertSome(List<RouteStation> rss) {
		for(int i=0;i<rss.size();i++) {
			if(insertOne(rss.get(i))==0) {
				return 0;
			}
		}
		return 1;
	}

	@Override
	public List<RouteStation> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from route_station ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<RouteStation> list =new ArrayList<RouteStation>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				RouteStation routeStation =new RouteStation(rs.getInt("id"),rs.getInt("rid"),rs.getInt("sid"));
				list.add(routeStation);	
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
		String sql = "delete from route_station where id=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int deleteRoute(int id) {
		String sql = "delete from route_station where rid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(RouteStation rs) {
		String sql = "update route_list set route_name=?,price=?where rid=?";
		Object[] objs = {rs.getId(),rs.getRid(),rs.getSid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int deleteStation(int id) {
		String sql = "delete from route_station where sid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	
	public int selectRouteStation(int sid) {
		
		Connection conn =DBUtil.getConnection();
		String sql ="select * from route_station where sid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		int flag=0;
		try {
			ps.setInt(1, sid);
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
	
	public Map<String, Integer> selectNumber() {
		
		Connection conn =DBUtil.getConnection();
		String sql ="select * from statistics ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		Map<String, Integer> map =new HashMap<String, Integer>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("route_name")+"#"+rs.getString("model_name"),rs.getInt("car_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return map;
	}

	

	

}
