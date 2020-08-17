package entity;

public class RouteStation {
	private int id;
	private int rid;
	private int sid;
	
	
	public RouteStation() {
		super();
	}
	
	public RouteStation(int rid, int sid) {
		super();
		this.rid = rid;
		this.sid = sid;
	}

	public RouteStation(int id, int rid, int sid) {
		super();
		this.id = id;
		this.rid = rid;
		this.sid = sid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	

}
