package service;

import java.util.List;

import entity.Driver;



public interface DriverService {
	    int addDriver(Driver driver);
		
		List<Driver> selectAllDriver();
		
		Driver selectDriver(int id);
		int deleteDriver(int id);

		int updateDriver(Driver driver);
}
