package dao;

import java.util.List;

import entity.Car;


public interface CarDao {
	int insertOne(Car car);
	
	List<Car> selectAll();

	int deleteOne(int id);

	int updateOne(Car car);
	
	public Car selectOne(int id);
 
	public int selectCar(int id);
}
