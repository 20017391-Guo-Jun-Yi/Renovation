
public class Request {
	private String property;
	private String area;
	private String name;
	private String number;
	private String email;
	private String budget;
	private String date;
	private String renovation;
	private String room;
	private String toilet;
	private String style;
	private String urgent;
	
	public Request(String property, String area, String name, String number, String email, String budget, String date,
			String renovation, String room, String toilet, String style, String urgent) {
		super();
		this.property = property;
		this.area = area;
		this.name = name;
		this.number = number;
		this.email = email;
		this.budget = budget;
		this.date = date;
		this.renovation = renovation;
		this.room = room;
		this.toilet = toilet;
		this.style = style;
		this.urgent = urgent;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRenovation() {
		return renovation;
	}

	public void setRenovation(String renovation) {
		this.renovation = renovation;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getToilet() {
		return toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getUrgent() {
		return urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	
	}