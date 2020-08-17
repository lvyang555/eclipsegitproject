package service;

import java.util.List;
import java.util.Map;

import entity.RouteStation;


public interface RouteStationService {
	
    int insertRouteStation(RouteStation rs);
    int AddSomeRouteStation(List<RouteStation> rss);
	
	List<RouteStation> selectAll();

	int deleteRouteStation(int id);
	int deleteRoute(int id);
	int deleteStation(int id);

	int updateRouteStation(RouteStation rs);
	int selectRouteStation(int sid);
	Map<String, Integer> selectNumber();

}
