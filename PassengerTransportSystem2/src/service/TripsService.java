package service;

import java.util.List;

import entity.Driver;
import entity.Show;
import entity.Trips;

public interface TripsService {
	
	  		int addTrips(Trips trips);		
			List<Trips> selectAllTrips();			
			int deleteTrips(int id);
			int updateTrips(Trips trips);
			int deleteSome(int id);
			int selectCar(int id);
			boolean selectSome(int start,int end,int routeType);
			public List<Trips> querySomeTrips(int carType,int routeType);
			public Show tripChangeShow(Trips trips);
			public Show selectTrips(int id);
			public Trips selectOneTrips(int id);
			public int updateOneTrips(Trips trips);
}
