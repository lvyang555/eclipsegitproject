package entity;

public class Show {
	 private int tid;
	 private String tripsName;
	 private String routeName;
	 private String carName;
	 private int votes;
	 private int votes_saled;
	 private String startTime;
	 private String endTime;
	 private int statues;
	 
	public Show() {
		super();
	}

	public Show(int tid, String tripsName, String routeName, String carName, int votes, int votes_saled,
			String startTime, String endTime, int statues) {
		super();
		this.tid = tid;
		this.tripsName = tripsName;
		this.routeName = routeName;
		this.carName = carName;
		this.votes = votes;
		this.votes_saled = votes_saled;
		this.startTime = startTime;
		this.endTime = endTime;
		this.statues = statues;
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

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getVotes_saled() {
		return votes_saled;
	}

	public void setVotes_saled(int votes_saled) {
		this.votes_saled = votes_saled;
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

	public int getStatues() {
		return statues;
	}

	public void setStatues(int statues) {
		this.statues = statues;
	}

	
	
	 
	 
	 

}
