package serviceimpl;

import java.util.List;

import dao.StationDao;
import daoimpl.StationDaoimpl;
import entity.Station;
import service.StationService;

public class StationServiceImpl implements StationService{

	public StationDao sd =new StationDaoimpl();
	@Override
	public int insertStation(Station sta) {
		if(sd.insertOne(sta)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Station> selectAll() {
		
		return sd.selectAll();
	}

	@Override
	public List<Station> selectSomeStations(int id) {
		// TODO Auto-generated method stub
		return sd.selectSomeStations(id);
	}

	@Override
	public int deleteStation(int id) {
		if(sd.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateStation(Station sta) {
		if(sd.updateOne(sta)>=1) {
			return 1;
		}
		return 0;
	}


}
