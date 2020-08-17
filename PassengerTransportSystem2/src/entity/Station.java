package entity;

public class Station {
	private int sid;
	private String stationName;
	private String stationCode;
	
	
	public Station() {
		super();
	}
	
	public Station(String stationName, String stationCode) {
		super();
		this.stationName = stationName;
		this.stationCode = stationCode;
	}

	public Station(int sid, String stationName, String stationCode) {
		super();
		this.sid = sid;
		this.stationName = stationName;
		this.stationCode = stationCode;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	
	

}
