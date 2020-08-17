package serviceimpl;

import java.util.List;

import dao.RouteDao;
import daoimpl.RouteDaoimpl;
import entity.Route;
import service.RouteService;

public class RouteServiceImpl implements RouteService{

	RouteDao rd =new RouteDaoimpl();
	@Override
	public int insertRoute(Route route) {
		if(rd.insertOne(route)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Route> selectAll() {
		
		return rd.selectAll();
	}

	@Override
	public int deleteRoute(int id) {
		if(rd.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateRoute(Route route) {
		if(rd.updateOne(route)>=1) {
			return 1;
		}
		return 0;
	}
	public Route selectone(Route r) {
		
		
		return rd.selectone(r);
	}

	@Override
	public Route selectRoute(int id) {
		
		return rd.selectRoute(id);
	}

}
