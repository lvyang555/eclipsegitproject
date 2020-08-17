 package dao;

import java.util.List;
import java.util.Map;

import entity.RouteStation;



public interface RouteStationDao {
	
    int insertOne(RouteStation rs);
    int insertSome(List<RouteStation> rss);
	
	List<RouteStation> selectAll();
	//List<RouteStation> selectone(int id);

	int deleteOne(int id);
	int deleteRoute(int id);
	int deleteStation(int id);
	Map<String, Integer> selectNumber();
	int updateOne(RouteStation rs);
	int selectRouteStation(int sid);
}
