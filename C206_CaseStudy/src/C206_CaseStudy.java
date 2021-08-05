
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Packages> packageList = new ArrayList<Packages>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Request> requestList = new ArrayList<Request>();
		
		packageList.add(new Packages(1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000"));
		userList.add(new User("JunYi", "Master", "20017391@rp.edu.sg", "Password!", "Old"));
		appointmentList.add(new Appointment("01/08/2021", "14:00", "JEN", "Lixuan", "RP"));

		int option = 0;
		
		while (option != 6) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// JunHao
				C206_CaseStudy.setHeader("");
				C206_CaseStudy.setHeader("Options: ");
				System.out.println("1. ADD");
				System.out.println("2. VIEW");
				System.out.println("3. DELETE");

				int number = Helper.readInt("Enter option for a function: ");

				if (number == 1) {
					User us = inputUser();
					C206_CaseStudy.addusers(userList, us);
				} else if (number == 2) {
					C206_CaseStudy.ViewUser(userList);
				} else if (number == 3) {
					C206_CaseStudy.deleteUser(userList);
				} else {
					System.out.println("Invaild option");
				}

			} else if (option == 2) {
				// JunYi
				C206_CaseStudy.setHeader("PACKAGES");
				C206_CaseStudy.setHeader("OPTIONS :");
				System.out.println("1. ADD");
				System.out.println("2. VIEW");
				System.out.println("3. DELETE");

				int itemType = Helper.readInt("Enter option for a function > ");

				if (itemType == 1) {
					// Add Packages
					Packages pl = inputPackages();
					C206_CaseStudy.addPackages(packageList, pl);

				} else if (itemType == 2) {
					// View all Packages
					C206_CaseStudy.viewAllPackages(packageList);

				} else if (itemType == 3) {
					// Delete a Package
					C206_CaseStudy.deletePackages(packageList);
				}

				else {
					System.out.println("Invalid option");
				}

			} else if (option == 3) {
				// Azri
				C206_CaseStudy.setHeader("MANAGE REQUEST FOR QUOTE");
				C206_CaseStudy.setHeader("OPTIONS :");
				System.out.println("1. ADD A REQUEST FOR QUOTE");
				System.out.println("2. VIEW ALL REQUEST FOR QUOTE");
				System.out.println("3. DELETE A REQUEST FOR QUOTE BY REQUEST NAME");

				int appOption = Helper.readInt("Enter option: ");

				if (appOption == 1) {
					Request op = inputRequest();
					C206_CaseStudy.addRequest(requestList, op);

				} else if (appOption == 2) {
					C206_CaseStudy.viewAllRequest(requestList);

				} else if (appOption == 3) {
					C206_CaseStudy.deleteRequest(requestList);
				} else {
					System.out.println("Invaild option");
				}

			} else if (option == 4) {
				// SuetTeng
				C206_CaseStudy.setHeader("ADD QUOTATION");
				C206_CaseStudy.setHeader("Options: ");
				System.out.println("1. VIEW QUOTATIONS");
				System.out.println("2. ADD A QUOTATION");
				System.out.println("3. DELETE A QUOTATION");

			} else if (option == 5) {
				// Lixuan
				C206_CaseStudy.setHeader("MANAGE APPOINTMENT");
				C206_CaseStudy.setHeader("OPTIONS :");
				System.out.println("1. ADD an APPOINTMENT");
				System.out.println("2. View all APPOINTMENT");
				System.out.println("3. Delete an APPOINTMENT");

				int appOption = Helper.readInt("Enter option for a function > ");

				if (appOption == 1) {
					Appointment app = inputAppointment();
					C206_CaseStudy.addAppointment(appointmentList, app);

				} else if (appOption == 2) {
					C206_CaseStudy.viewAllAppointment(appointmentList);

				} else if (appOption == 3) {

					C206_CaseStudy.deleteAppointment(appointmentList);
				} else {
					System.out.println("Invaild option");
				}

			} else if (option == 6) {
				System.out.println("Thanks for your using our application. Bye!");
				break;
			} else {
				System.out.println("Invalid Option");
			}

		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Braiseduck & Co RENNOVATION APPLICATION");
		System.out.println("1. USER ACCOUNT");
		System.out.println("2. PACKAGES");
		System.out.println("3. REQ QUOTATIONS");
		System.out.println("4. ADD QUOTATIONS");
		System.out.println("5. APPOINTMENT");
		System.out.println("6. QUIT");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option1(User)=================================
	public static User inputUser() {
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role: ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter Password: ");
		String status = "new";

		User us = new User(name, role, email, password, status);

		return us;

	}

	public static void addusers(ArrayList<User> userList, User us) {

		userList.add(us);
		System.out.println("User added");
	}

	public static String ViewUser(ArrayList<User> userList) {
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "NAME", "EMAIL", "PASSWORD", "ROLE", "STATUS");

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-20s %-20s %-20s %-20s %-20s\n", userList.get(i).getName(),
					userList.get(i).getEmail(), userList.get(i).getPassword(), userList.get(i).getRole(),
					userList.get(i).getStatus());
		}
		System.out.println(output);
		return output;
	}

	public static Boolean docheckUser(ArrayList<User> userList, String name) {

		boolean deleted = false;
		for (int i = 0; i < userList.size(); i++) {

			name = userList.get(i).getName();

			if (name.equals(userList.get(i).getName())) {
				deleted = true;
			}
		}
		return deleted;
	}

	public static void deleteUser(ArrayList<User> userList) {
		C206_CaseStudy.ViewUser(userList);
		String name = Helper.readString("Enter name: ");
		char confirm = Helper.readChar("Are you sure? (Y/N) > ");
		boolean ischecked = docheckUser(userList, name);
		if (ischecked == false) {
			System.out.println("user not deleted");
		} else {
			if (confirm == 'Y' || confirm == 'y') {
				for (int i = 0; i < userList.size(); i++) {
					if (name.equalsIgnoreCase(userList.get(i).getName())) {
						userList.remove(i);
						System.out.println("User deleted");
					}
				}
			} else if (confirm == 'N' || confirm == 'n') {
				System.out.println("User not deleted!");
			} else {
				System.out.println("Invaild Input");
			}
		}
	}

	// ================================= Option2(PACKAGE)=================================
	// Add package
	public static Packages inputPackages() {
		int code = Helper.readInt("Enter code > ");
		String description = Helper.readString("Enter description > ");
		String start = Helper.readString("Enter Start Date > ");
		String end = Helper.readString("Enter End Date > ");
		String amount = Helper.readString("Enter amount (include $)> ");

		Packages pl = new Packages(code, description, start, end, amount);
		return pl;

	}

	public static void addPackages(ArrayList<Packages> packageList, Packages pl) {

		packageList.add(pl);
		System.out.println("Package added");
	}

	// View all packages
	public static String viewAllPackages1(ArrayList<Packages> packageList) {
		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-20d %-20s %-20s %-20s %-20s\n", packageList.get(i).getCode(),
					packageList.get(i).getDesc(), packageList.get(i).getStart(), packageList.get(i).getEnd(),
					packageList.get(i).getAmount());
		}
		return output;
	}

	public static void viewAllPackages(ArrayList<Packages> packageList) {
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "PACKAGE CODE", "DESCRIPTION", "START DATE",
				"END DATE", "PACKAGE AMOUNT");
		output += viewAllPackages1(packageList);
		System.out.println(output);
	}

	// Delete a package
	public static void deletePackages(ArrayList<Packages> packageList) {
		int code = Helper.readInt("Enter code to delete > ");
		boolean isRemove = false;
		char confirm = Helper.readChar("Are you sure? (Y/N) > ");
		if (confirm == 'Y' || confirm == 'y') {
			for (int i = 0; i < packageList.size(); i++) {
				if (code == packageList.get(i).getCode()) {
					packageList.remove(i);
					isRemove = true;
				} else {
					isRemove = false;
				}
			}
			if (isRemove == true) {
				System.out.println("Package deleted");
			} else {
				System.out.println("Package unfound");
			}
		} else if (confirm == 'N' || confirm == 'n') {

			System.out.println("Package not deleted");
		} else {
			System.out.println("Invalid input");
		}
	}
	
	// ================================= Option 3 (REQUEST FOR QUOTE)==================================
		// Add request for quote
		public static Request inputRequest() {
			String property = Helper.readString("Enter Property Type (HDB,Private,Landed): ");
			float area = Helper.readFloat("Enter Area Size: ");
			String name = Helper.readString("Enter Request Name: ");
			int number = Helper.readInt("Enter Number: ");
			String email = Helper.readString("Enter Email: ");
			float budget = Helper.readFloat("Enter budget: ");
			String date = Helper.readString("Enter Target Completion Date: ");
			String renovation = Helper.readString("Enter Renovation Type (whole house,room,kitchen,toilet): ");
			int room = Helper.readInt("Enter number of rooms to renovate: ");
			int toilet = Helper.readInt("Enter number of toilets to renovate: ");
			String style = Helper.readString("Enter Renovation style (optional): ");
			boolean urgent = Helper.readBoolean("Is the request urgent?: ");


			Request quote = new Request(property, area, name, number, email, budget, date, renovation, room, toilet, style, urgent);
			return quote;
		}
		public static void addRequest(ArrayList<Request> requestList, Request ql) {

			requestList.add(ql);
			System.out.println("Request for Quote added");
		}

		// View all request for quote
		public static String viewAllRequest(ArrayList<Request> requestList) {
			String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Property Type", "Area Size", "Request Name", "Contact number", "Email", "Budget", "Target Completion Date", "Renovation type", "No. of rooms", "No. of toilets", "Renovation style", "Urgent request"); 

			for (int i = 0; i < requestList.size(); i++) {

			}
			System.out.println(output);
			return output;
		}

		// Delete a request for quote by request name
		public static void deleteRequest(ArrayList<Request> requestList) {
			String name = Helper.readString("Enter request name > ");

			boolean isRemove = false;
			char confirm = Helper.readChar("Are you sure? (Y/N) > ");
			if (confirm == 'Y' || confirm == 'y') {
				for (int i = 0; i < requestList.size(); i++) {
					if (name == requestList.get(i).getName()) {
						requestList.remove(i);
						isRemove = true;
					} else {
						isRemove = false;
					}
				}
				if (isRemove == true) {
					System.out.println("Request for quote deleted");
				} else {
					System.out.println("Invalid request name");
				}
			}
		}



	// ================================= Option 5 (MANAGEAPPOINTMENT)==================================
	// Add appointment
	public static Appointment inputAppointment() {

		String date = Helper.readString("Enter date of appointment (DD-MM-YYYY) > ");
		String time = Helper.readString("Enter time of appointment (HH:MM) > ");
		String name = Helper.readString("Enter designer name > ");
		String custName = Helper.readString("Enter customer name > ");
		String premise = Helper.readString("Enter address of the premise > ");

		Appointment app = new Appointment(date, time, name, custName, premise);
		return app;

	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment app) {

		appointmentList.add(app);
		System.out.println("Appointment added");

	}

	// View all appointment
	public static String viewAllAppointment(ArrayList<Appointment> appointmentList) {
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Date-Of-Appointment", "Time-of-Appointment",
				"Designer Name", "Customer Name", "Address of the premise");

		for (int i = 0; i < appointmentList.size(); i++) {

			output += String.format("%-20s %-20s %-20s %-20s %-20s\n", appointmentList.get(i).getDate(),
					appointmentList.get(i).getTime(), appointmentList.get(i).getName(),
					appointmentList.get(i).getCustName(), appointmentList.get(i).getAddress());
		}
		System.out.println(output);
		return output;
	}

	// Delete a appointment
	public static void deleteAppointment(ArrayList<Appointment> appointmentList) {
		String name = Helper.readString("Enter customer name > ");

		boolean isRemove = false;
		char confirm = Helper.readChar("Are you sure? (Y/N) > ");
		if (confirm == 'Y' || confirm == 'y') {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (name.equalsIgnoreCase(appointmentList.get(i).getCustName())) {
					appointmentList.remove(i);
					isRemove = true;
				} else {
					isRemove = false;
				}
			}
			if (isRemove == true) {
				System.out.println("Appointment deleted");
			} else {
				System.out.println("Appointment unfound");
			}
		} else if (confirm == 'N' || confirm == 'n') {

			System.out.println("Appointment not deleted");
		} else {
			System.out.println("Invalid input");
		}
	}
}
