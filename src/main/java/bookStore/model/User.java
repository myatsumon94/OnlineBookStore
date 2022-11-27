package bookStore.model;

public class User {

	private int id;
	private String name;
	private String email;
	private String address;
	private String phoneNo;
	private String password;

	
	public User(String name, String email, String address, String phoneNo, String password) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.password = password;

	}

	public User(int id, String name, String email, String address, String phoneNo, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.password = password;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phoneNo="
				+ phoneNo + ", password=" + password + "]";
	}

	
	
	
}
