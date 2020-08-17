package service;

import java.util.List;

import entity.Station;



public interface StationService {
    int insertStation(Station sta);
	
	List<Station> selectAll();
	
	List<Station> selectSomeStations(int id);

	int deleteStation(int id);

	int updateStation(Station sta);
}
