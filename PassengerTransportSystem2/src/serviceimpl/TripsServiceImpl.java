package serviceimpl;

import java.util.List;

import dao.TripsDao;
import daoimpl.TripsDaoimpl;
import entity.Show;
import entity.Trips;
import service.TripsService;

public class TripsServiceImpl implements TripsService{

	public TripsDao td =new TripsDaoimpl();
	@Override
	public int addTrips(Trips trips) {
		if(td.insertOne(trips)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Trips> selectAllTrips() {
		
		return td.selectAll();
	}


	@Override
	public int deleteTrips(int id) {
		if(td.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateTrips(Trips trips) {
		if(td.updateOne(trips)>=1) {
			return 1;
		}
		return 0;
	}
	@Override
	public int deleteSome(int id) {
		if(td.selectOne(id)==1) {
			if(td.deleteSome(id)>=1) {
				return 1;
			}
		}else {
			return 1;
		}
		return 0;
	}

	@Override
	public int selectCar(int id) {
		if(td.selectOne(id)==1) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean selectSome(int start, int end, int routeType) {
		
		return td.selectSome(start, end, routeType);
	}

	@Override
	public List<Trips> querySomeTrips(int carType, int routeType) {
		// TODO Auto-generated method stub
		return td.querySomeTrips(carType, routeType);
	}

	@Override
	public Show tripChangeShow(Trips trips) {

		return td.tripChangeShow(trips);
	}

	@Override
	public Show selectTrips(int id) {
		// TODO Auto-generated method stub
		return td.selectTrips(id);
	}

	@Override
	public Trips selectOneTrips(int id) {
		
		return td.selectOneTrips(id);
	}

	@Override
	public int updateOneTrips(Trips trips) {
		if(td.updateTrips(trips)>=1) {
			return 1;
		}
		return 0;
	}

}
