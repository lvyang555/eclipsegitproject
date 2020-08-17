package service;

import java.util.List;

import entity.Car;

public interface CarService {
	
    int addCar(Car car);
	
	List<Car> selectAllCar();
	
	Car selectCat(int id);
	int deleteCar(int id);

	int updateCar(Car car);

}
