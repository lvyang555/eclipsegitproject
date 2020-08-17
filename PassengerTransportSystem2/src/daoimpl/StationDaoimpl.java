package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StationDao;
import entity.RouteStation;
import entity.Station;
import util.DBUtil;

public class StationDaoimpl implements StationDao {

	@Override
	public int insertOne(Station sta) {
		String sql ="insert into station_list(station_name,station_code) values(?,?)";
		Object[] objs= {
				sta.getStationName(),sta.getStationCode()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Station> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from station_list ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Station> list =new ArrayList<Station>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Station sta =new Station(rs.getInt("sid"),rs.getString("station_name"),rs.getString("station_code"));
				list.add(sta);	
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
		String sql = "delete from station_list where sid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(Station sta) {
		String sql = "update station_list set station_name=?,station_code=?where sid=?";
		Object[] objs = {sta.getStationName(),sta.getStationCode(),sta.getSid()};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Station> selectSomeStations(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select station_list.sid,station_name,station_code from route_station,station_list where route_station.sid=station_list.sid and rid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		
		List<Station> list =new ArrayList<Station>();
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Station sta =new Station(rs.getInt("station_list.sid"),rs.getString("station_name"),rs.getString("station_code"));
				list.add(sta);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
	}
	

}
