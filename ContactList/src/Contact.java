
public class Contact {
	private String fName;
	private String lName;
	private String phone;
	private String key;
	
	
	public Contact() {
		super();
	}
	
	public Contact(String fName, String lName, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		updateKey();
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
		updateKey();
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
		updateKey();
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		updateKey();
	}

	public String getKey(){
		return key;
		
	}
	
	public void updateKey(){
		key = fName + lName + phone;
	}

	public String toString() {
		return fName + lName + phone; 
	}
	
}
