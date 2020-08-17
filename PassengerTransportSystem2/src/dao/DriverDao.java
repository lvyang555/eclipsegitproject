package dao;

import java.util.List;

import entity.Driver;


public interface DriverDao {
	
    int insertOne(Driver driver);
	
	List<Driver> selectAll();
	int deleteOne(int id);

	int updateOne(Driver driver);
	public Driver selectOne(int id);
}
