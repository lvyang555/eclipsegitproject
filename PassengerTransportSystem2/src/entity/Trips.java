package entity;

public class Trips {
	
	private int tid;
	private String tripsName;
	private int rid;
	private int mid;
	private int votes;
	private int votesSaled;
	private int did;
	private String startTime;
	private String endTime;
	private int status;
	
	
	public Trips() {
		super();
	}


	public Trips(String tripsName, int rid, int mid, int votes, int votesSaled, int did, String startTime,
			String endTime, int status) {
		super();
		this.tripsName = tripsName;
		this.rid = rid;
		this.mid = mid;
		this.votes = votes;
		this.votesSaled = votesSaled;
		this.did = did;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}


	public Trips(int tid, String tripsName, int rid, int mid, int votes, int votesSaled, int did, String startTime,
			String endTime, int status) {
		super();
		this.tid = tid;
		this.tripsName = tripsName;
		this.rid = rid;
		this.mid = mid;
		this.votes = votes;
		this.votesSaled = votesSaled;
		this.did = did;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTripsName() {
		return tripsName;
	}


	public void setTripsName(String tripsName) {
		this.tripsName = tripsName;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	public int getVotesSaled() {
		return votesSaled;
	}


	public void setVotesSaled(int votesSaled) {
		this.votesSaled = votesSaled;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
