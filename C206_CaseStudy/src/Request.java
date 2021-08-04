
public class Request {
	private String property;
	private float area;
	private String name;
	private int number;
	private String email;
	private float budget;
	private String date;
	private String renovation;
	private int room;
	private int toilet;
	private String style;
	private boolean urgent;
	
	public Request(String property, float area, String name, int number, String email, float budget, String date,
			String renovation, int room, int toilet, String style, boolean urgent) {
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

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
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

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getToilet() {
		return toilet;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	
}