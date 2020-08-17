package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TripsDao;
import entity.Show;
import entity.Station;
import entity.Trips;
import util.DBUtil;

public class TripsDaoimpl implements TripsDao{

	@Override
	public int insertOne(Trips trips) {
		String sql ="insert into trips_list(trips_name,rid,mid,votes,votes_saled,did,start_time,end_time,status) values(?,?,?,?,?,?,?,?,?)";
		Object[] objs= {
				trips.getTripsName(),trips.getRid(),trips.getMid(),trips.getVotes(),trips.getVotesSaled(),trips.getDid(),trips.getStartTime(),trips.getEndTime(),trips.getStatus()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public List<Trips> selectAll() {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from trips_list ";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Trips> list =new ArrayList<Trips>();
		try {
			rs=ps.executeQuery();
			while(rs.next()) {
				Trips trips =new Trips(rs.getInt("tid"), rs.getString("trips_name"), rs.getInt("rid"), rs.getInt("mid"), rs.getInt("votes"), rs.getInt("votes_saled"), rs.getInt("did"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("status"));
				list.add(trips);	
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
		String sql = "delete from trips_list where tid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}

	@Override
	public int updateOne(Trips trips) {
		String sql = "update route_list set status = 0 where tid=?";
		Object[] objs= {
				trips.getTid()
				};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	
	public int updateTrips(Trips trips) {
		String sql ="update trips_list set trips_name=?,rid=?,mid=?,votes=?,votes_saled=?,did=?,start_time=?,end_time=?,status=? where tid=?";
		Object[] objs= {
				trips.getTripsName(),trips.getRid(),trips.getMid(),trips.getVotes(),trips.getVotesSaled(),trips.getDid(),trips.getStartTime(),trips.getEndTime(),trips.getStatus(),trips.getTid()
		};
		int n=DBUtil.excuteDML(sql, objs);
		return n;
	}
	@Override
	public int deleteSome(int id) {
		String sql = "delete from trips_list where mid=?";
		Object[] objs = {id};
		int n = DBUtil.excuteDML(sql, objs);
		return n;
	}
	
	public boolean selectSome(int start,int end,int routeType){
		Connection conn =DBUtil.getConnection();
		String sql ="select id from route_station where sid=? and rid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		
		ResultSet rs =null;
		int new_start=999,new_end=-1;
		try {
			ps.setInt(1, start);
			ps.setInt(2, routeType);
			rs=ps.executeQuery();
			if(rs.next()) {
				new_start=rs.getInt("id");
			}
			ps.setInt(1, end);
			ps.setInt(2, routeType);
			rs=ps.executeQuery();
			if(rs.next()) {
				new_end=rs.getInt("id");
			}

			if(new_start>new_end) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return true;
	}
	
	public List<Trips> querySomeTrips(int carType,int routeType){
		Connection conn =DBUtil.getConnection();
		String sql ="select * from trips_list where mid=? and rid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		List<Trips> list =new ArrayList<Trips>();
		try {
			ps.setInt(1, carType);
			ps.setInt(2, routeType);
			rs=ps.executeQuery();
			while(rs.next()) {
				Trips trips =new Trips(rs.getInt("tid"), rs.getString("trips_name"), rs.getInt("rid"), rs.getInt("mid"), rs.getInt("votes"), rs.getInt("votes_saled"), rs.getInt("did"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("status"));
				list.add(trips);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
		
		
		
	}
	
	public int selectOne(int id) {
		
		Connection conn =DBUtil.getConnection();
		String sql ="select count(*) from trips_list where mid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		
		ResultSet rs =null;
		int result =0;
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>=1)
					result=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return result;
	}
	
	public Show selectTrips(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from shows where tid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		
		ResultSet rs =null;
		Show show =null;
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				show =new Show(rs.getInt("tid"), rs.getString("trips_name"),rs.getString("route_name"), rs.getString("model_name"), rs.getInt("votes"), rs.getInt("votes_saled"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("status"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return show;
		
	}
	
	public Trips selectOneTrips(int id) {
		Connection conn =DBUtil.getConnection();
		String sql ="select * from trips_list where tid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		
		ResultSet rs =null;
		Trips trips =null;
		try {
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				trips =new Trips(rs.getInt("tid"), rs.getString("trips_name"), rs.getInt("rid"), rs.getInt("mid"), rs.getInt("votes"), rs.getInt("votes_saled"), rs.getInt("did"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return trips;
		
	}
	
	
	public Show tripChangeShow(Trips trips){
		Connection conn =DBUtil.getConnection();
		String sql ="select * from shows where tid=?";
		PreparedStatement ps=DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		Show show=null;
		try {
			ps.setInt(1, trips.getTid());
			rs=ps.executeQuery();
			while(rs.next()) {
				show=new Show(rs.getInt("tid"), rs.getString("trips_name"),rs.getString("route_name"), rs.getString("model_name"), rs.getInt("votes"), rs.getInt("votes_saled"), rs.getString("start_time"), rs.getString("end_time"), rs.getInt("status"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return show;

	}

}
