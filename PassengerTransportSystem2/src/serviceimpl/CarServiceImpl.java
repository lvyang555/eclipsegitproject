package serviceimpl;

import java.util.List;

import dao.CarDao;
import daoimpl.CarDaoimpl;
import entity.Car;
import service.CarService;

public class CarServiceImpl implements CarService{

	public CarDao cd =new CarDaoimpl();
	@Override
	public int addCar(Car car) {
		if(cd.insertOne(car)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Car> selectAllCar() {
		
		return cd.selectAll();
	}

	@Override
	public int deleteCar(int id) {
		if(cd.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateCar(Car car) {
		if(cd.updateOne(car)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public Car selectCat(int id) {
		return cd.selectOne(id);
	}
	
	

}
