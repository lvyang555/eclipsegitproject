package entity;

public class Driver {
	
	private int did;
	private String name;
	private String phone;
	private int age;
	private String dirverCode;
	
	
	
	public Driver() {
		super();
	}
	
	public Driver(String name, String phone, int age, String dirverCode) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.dirverCode = dirverCode;
	}

	public Driver(int did, String name, String phone, int age, String dirverCode) {
		super();
		this.did = did;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.dirverCode = dirverCode;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDirverCode() {
		return dirverCode;
	}
	public void setDirverCode(String dirverCode) {
		this.dirverCode = dirverCode;
	}
	
	
	

}
