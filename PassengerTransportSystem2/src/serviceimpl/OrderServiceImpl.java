package serviceimpl;

import java.util.List;

import dao.OrderDao;
import daoimpl.OrderDaoimpl;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService{

	public OrderDao od =new OrderDaoimpl();
	@Override
	public int addOrder(Order order) {
		if(od.insertOne(order)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Order> selectAllOrder() {
		return od.selectAll();
	}

	

	@Override
	public int deleteOrder(int id) {
		if(od.deleteOne(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateOrder(Order order) {
		if(od.updateOne(order)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int UpdateOrder(int id) {
		if(od.UpdateOrder(id)>=1) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Order> selectUserAll(int id) {
		
		return od.selectUserAll(id);
	}

}
