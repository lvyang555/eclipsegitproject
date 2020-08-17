package serviceimpl;

import java.util.List;
import java.util.Map;

import dao.RouteStationDao;
import daoimpl.RouteStationDaoimpl;
import entity.RouteStation;
import service.RouteStationService;

public class RouteStationServiceImpl implements RouteStationService{

	
	public RouteStationDao rsd =new RouteStationDaoimpl();
	@Override
	public int insertRouteStation(RouteStation rs) {
		if(rsd.insertOne(rs)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int AddSomeRouteStation(List<RouteStation> rss) {
		if(rsd.insertSome(rss)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<RouteStation> selectAll() {
		
		return rsd.selectAll();
	}

	@Override
	public int deleteRouteStation(int id) {
		if(rsd.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteRoute(int id) {
		if(rsd.deleteRoute(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteStation(int id) {
		if(rsd.selectRouteStation(id)==0) {
			return 1;
		}else if(rsd.deleteStation(id)>=1) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int updateRouteStation(RouteStation rs) {
		if(rsd.updateOne(rs)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int selectRouteStation(int sid) {
		if(rsd.selectRouteStation(sid)==1) {
			return 1;
		}
		return 0;
	}

	@Override
	public Map<String, Integer> selectNumber() {
		
		return rsd.selectNumber();
	}
	
	
	

	

	
	

}
