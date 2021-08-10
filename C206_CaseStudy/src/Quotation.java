/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 * 
 * 20023627, 4 Aug 2021 2:50:07 pm
 */

public class Quotation {
	private String name; //Customer's name
	private String property;
	private String area;
	private String renType; //Renovation type
	private String renRmNum; //Total number of rooms to renovate
	private String renToiNum; //Total number of toilets to renovate
	private String budget;
	private String compDate; //Date that the renovation will be completed on
	private String contactNum;
	private String contactEmail;
	private String quotationID;
	
	public Quotation (String name, String property, String area, String renType, String renRmNum,
			String renToiNum, String budget, String compDate, String contactNum, String contactEmail,
			String quotationID) {
		this.name = name;
		this.property = property;
		this.area = area;
		this.renType = renType;
		this.renRmNum = renRmNum;
		this.renToiNum = renToiNum;
		this.budget = budget;
		this.compDate = compDate;
		this.contactNum = contactNum;
		this.contactEmail = contactEmail;
		this.quotationID = quotationID;
	}

	public String getName() { //
		return name;
	}

	public String getProperty() {
		return property;
	}

	public String getArea() {
		return area;
	}

	public String getRenType() {
		return renType;
	}

	public String getRenRmNum() {
		return renRmNum;
	}

	public String getRenToiNum() {
		return renToiNum;
	}

	public String getBudget() {
		return budget;
	}

	public String getCompDate() {
		return compDate;
	}

	public String getContactNum() {
		return contactNum;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}
	
	

}




