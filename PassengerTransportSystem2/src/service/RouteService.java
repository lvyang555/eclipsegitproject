package service;

import java.util.List;

import entity.Route;

public interface RouteService {
	int insertRoute(Route route);
	
	List<Route> selectAll();

	int deleteRoute(int id);

	int updateRoute(Route route);
	Route selectone(Route r);
	Route selectRoute(int id);

}
