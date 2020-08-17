package entity;

public class Order {
	
	private int oid;
	private int uid;
	private int tid;
	private int statues;
	private String time;
	
	
	public Order() {
		super();
	}
	
	public Order(int uid, int tid, int statues, String time) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.statues = statues;
		this.time = time;
	}

	public Order(int oid, int uid, int tid, int statues, String time) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.tid = tid;
		this.statues = statues;
		this.time = time;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getStatues() {
		return statues;
	}
	public void setStatues(int statues) {
		this.statues = statues;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
