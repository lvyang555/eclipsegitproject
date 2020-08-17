package dao;

import java.util.List;

import entity.Show;
import entity.Trips;



public interface TripsDao {
	
		int insertOne(Trips trips);
		List<Trips> selectAll();
		int deleteOne(int id);
		int updateOne(Trips trips);
		int deleteSome(int id);
		int selectOne(int id);
		boolean selectSome(int start,int end,int routeType);
		public List<Trips> querySomeTrips(int carType,int routeType);
		Show tripChangeShow(Trips trips);
		Show selectTrips(int id);
		Trips selectOneTrips(int id);
		int updateTrips(Trips trips);
}
