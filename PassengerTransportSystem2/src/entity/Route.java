package entity;

public class Route {
	
	private int rid;
	private String routeName;
	private int price;
	
	
	public Route() {
		super();
	}
	
	public Route(String routeName, int price) {
		super();
		this.routeName = routeName;
		this.price = price;
	}

	public Route(int rid, String routeName, int price) {
		super();
		this.rid = rid;
		this.routeName = routeName;
		this.price = price;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
