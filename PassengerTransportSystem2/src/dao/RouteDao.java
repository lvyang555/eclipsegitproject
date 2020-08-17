package dao;

import java.util.List;


import entity.Route;

public interface RouteDao {
	

    int insertOne(Route route);
	
	List<Route> selectAll();

	int deleteOne(int id);

	int updateOne(Route route);
    Route selectone(Route r);
    Route selectRoute(int id);
}
