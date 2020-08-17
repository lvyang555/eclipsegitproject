package entity;

public class Car {
	
	private int mid;
	private String modelName;
	private int seatNum;
	private int carNum;
	
	
	public Car() {
		super();
	}
	public Car(String modelName, int seatNum, int carNum) {
		super();
		this.modelName = modelName;
		this.seatNum = seatNum;
		this.carNum = carNum;
	}
	public Car(int mid, String modelName, int seatNum, int carNum) {
		super();
		this.mid = mid;
		this.modelName = modelName;
		this.seatNum = seatNum;
		this.carNum = carNum;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	
	
	

}
