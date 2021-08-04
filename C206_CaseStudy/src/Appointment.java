

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20013345, 1 Aug 2021 7:04:21 pm
 */

public class Appointment {
	private String date;
	private String time;
	private String name;
	private String custName;
	private String address;
	
	public Appointment(String date, String time, String name, String custName, String address) {
	
		this.date = date;
		this.time = time;
		this.name = name;
		this.custName = custName;
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	


}
