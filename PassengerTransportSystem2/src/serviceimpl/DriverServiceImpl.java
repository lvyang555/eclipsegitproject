package serviceimpl;

import java.util.List;

import dao.DriverDao;
import daoimpl.DriverDaoimpl;
import entity.Driver;
import service.DriverService;

public class DriverServiceImpl implements DriverService{

	public DriverDao dd =new DriverDaoimpl();
	@Override
	public int addDriver(Driver driver) {
		if(dd.insertOne(driver)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Driver> selectAllDriver() {
		
		return dd.selectAll();
	}

	@Override
	public Driver selectDriver(int id) {
		
		return dd.selectOne(id);
	}

	@Override
	public int deleteDriver(int id) {
		
		return dd.deleteOne(id);
	}

	@Override
	public int updateDriver(Driver driver) {
		if(dd.updateOne(driver)>=1) {
			return 1;
		}
		return 0;
	}

}
