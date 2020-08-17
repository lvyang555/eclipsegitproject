package dao;

import java.util.List;

import entity.Station;



public interface StationDao {
	    int insertOne(Station sta);
		
		List<Station> selectAll();
		
		List<Station> selectSomeStations(int id);

		int deleteOne(int id);

		int updateOne(Station sta);

}
