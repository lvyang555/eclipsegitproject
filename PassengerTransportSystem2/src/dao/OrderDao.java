package dao;

import java.util.List;

import entity.Order;


public interface OrderDao {
	
	    int insertOne(Order order);
		List<Order> selectAll();
		int deleteOne(int id);
		int updateOne(Order order);
		int UpdateOrder(int id);
		List<Order> selectUserAll(int id);

}
