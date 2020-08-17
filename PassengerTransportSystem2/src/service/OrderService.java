package service;

import java.util.List;

import entity.Order;


public interface OrderService {
       
	    int addOrder(Order order);
	
		List<Order> selectAllOrder();
		
		int deleteOrder(int id);

		int updateOrder(Order order);
		
		int UpdateOrder(int id);
		
	    List<Order> selectUserAll(int id);

}
