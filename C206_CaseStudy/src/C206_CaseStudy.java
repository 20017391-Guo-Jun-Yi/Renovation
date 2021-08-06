
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Packages> packageList = new ArrayList<Packages>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Request> requestList = new ArrayList<Request>();
		//ArrayList<Quotation> quotationList = new ArrayList<Quotation>();

		packageList.add(new Packages(1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000"));
		userList.add(new User("JunYi", "Master", "20017391@rp.edu.sg", "Password!", "Old"));
		appointmentList.add(new Appointment("01/08/2021", "14:00", "JEN", "Lixuan", "RP"));
		requestList.add(new Request("HDB", "96.4", "Azri", "81234567", "azri@gmail.com", "12345.50", "12-10-2021", "whole house", "4", "1", "vintage", "yes"));
		/*quotationList.add(new Quotation("Kee Suet Teng", "Landed", "700 sq ft",
		"All Rooms and All Toilets", "4", "2", "$7,100", "12-09-21", "12345678",
		"20023627@myrp.edu.sg"));*/


		int option = 0;

		while (option != 6) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				int number = 5;

				while (number != 4) {
					// JunHao
					C206_CaseStudy.setHeader("");
					C206_CaseStudy.setHeader("Options: ");
					System.out.println("1. ADD");
					System.out.println("2. VIEW");
					System.out.println("3. DELETE");
					System.out.println("4. Exit");

					number = Helper.readInt("Enter option for a function: ");

					if (number == 1) {
						User us = inputUser();
						C206_CaseStudy.addusers(userList, us);
					} else if (number == 2) {
						C206_CaseStudy.ViewUser(userList);
					} else if (number == 3) {
						User dus = C206_CaseStudy.DeleteUserinput(userList);
						C206_CaseStudy.deleteUser(userList, dus);
					} else if (number == 4) {
						System.out.println("Leave user account");
					} else {
						System.out.println("Invaild option");
					}
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

				int optionType = Helper.readInt("Enter an option type for more > ");

				if (optionType == 1) {
					// View quotation (Customers)
					//C206_CaseStudy.viewAllQuotations(quotationList);
				}
				else if (optionType == 2) {
					// Add quotation (Designers)
					//Quotation quote = inputQuotation();
					//C206_CaseStudy.addQuotations(quotationList, quote);

				}
				else if (optionType == 3) {
					// Delete quotation (Designers)
					//C206_CaseStudy.deleteQuotation(quotationList);
				}
				else {
					System.out.println("Invalid option");
				}

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

		String pattern = "((\\w+|\\d)@\\w+(.com))";
		if (us.getEmail().matches(pattern)) {
			userList.add(us);
			System.out.println("User added");
		} else {
			System.out.println("Invaild email");
			System.out.println("User not added");
		}

	}

	public static String ViewUser(ArrayList<User> userList) {
		String output = String.format("%-20s %-20s %-20s %-20s\n", "NAME", "EMAIL", "ROLE", "STATUS");

		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-20s %-20s %-20s %-20s\n", userList.get(i).getName(), userList.get(i).getEmail(),
					userList.get(i).getRole(), userList.get(i).getStatus());
		}
		System.out.println(output);
		return output;
	}

	public static User DeleteUserinput(ArrayList<User> userList) {

		User us2 = null;
		if (userList.size() != 0) {
			String name = Helper.readString("Enter name: ");
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getName().equals(name)) {
					us2 = userList.get(i);
				} else {
					System.out.println("User not found");
				}
			}
		} else {
			System.out.println("No users");
		}

		return us2;
	}

	public static void deleteUser(ArrayList<User> userList, User us2) {
		C206_CaseStudy.ViewUser(userList);

		userList.remove(us2);
	}

	// =================================Option2(PACKAGE)=================================
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
		String area = Helper.readString("Enter Area Size: ");
		String name = Helper.readString("Enter Request Name: ");
		String number = Helper.readString("Enter Number: ");
		String email = Helper.readString("Enter Email: ");
		String budget = Helper.readString("Enter budget: ");
		String date = Helper.readString("Enter Target Completion Date: ");
		String renovation = Helper.readString("Enter Renovation Type (whole house,room,kitchen,toilet): ");
		String room = Helper.readString("Enter number of rooms to renovate: ");
		String toilet = Helper.readString("Enter number of toilets to renovate: ");
		String style = Helper.readString("Enter Renovation style (optional): ");
		String urgent = Helper.readString("Is the request urgent?: ");


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
			output += String.format("%-20s %-20 %-20s %-20s %-20s %-20 %-20s %-20s %-20s %-20s %-20s %-20s\n", requestList.get(i).getProperty(), requestList.get(i).getArea(), requestList.get(i).getName(), requestList.get(i).getNumber(), requestList.get(i).getEmail(), requestList.get(i).getBudget(), requestList.get(i).getDate(), requestList.get(i).getRenovation(), requestList.get(i).getRoom(), requestList.get(i).getToilet(), requestList.get(i).getStyle(), requestList.get(i).getBudget());
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


	// ================================= Option 4 (QUOTATION) =========================================

	/*// Add quotation
		public static Quotation newQuotation() {
			String name = Helper.readString("Enter name > ");
			String property = Helper.readString("Enter property type > ");
			String area = Helper.readString("Enter total area for renovation > ");
			String renType = Helper.readString("Enter renovation type > ");
			String renRmNum = Helper.readString("Enter no. of rooms to renovate > ");
			String renToiNum = Helper.readString("Enter no. of toilets to renovate > ");
			String budget = Helper.readString("Enter total budget > ");
			String compDate = Helper.readString("Enter target completion date > ");
			String contactNum = Helper.readString("Enter contact number > ");
			String contactEmail = Helper.readString("Enter contact email > ");
			String renStyle = Helper.readString("Enter renovation style (optional) > ");
			String reqUrgent = Helper.readString("Enter request urgency (optional) > ");

			Quotation quo = new Quote(name, property, area, renType, renRmNum, renToiNum, budget, compDate,
					contactNum, contactEmail, renStyle, reqUrgent);
			return quo;
         }

        public static void addQuotations(ArrayList<Quotation> quotationList, Request qu) {
        	quotationList.add(qu);
        	System.out.println("Quotation added successfully!");
         }

		// View quotations
		public static String viewAllQuotations0(ArrayList<Quotation> quotationList) {
			C206_CaseStudy.setHeader("You have these quotations: ");

			String output = "";

			for (int a = 0; a < quotationList.size(); a++) {
				output += String.format("", quotationList.get(a).getName(),
						quotationList.get(a).getProperty(), quotationList.get(a).getArea(),
						quotationList.get(a).getRenType(), quotationList.get(a).getRenRmNum(),
						quotationList.get(a).getRenToiNum(), quotationList.get(a).getBudget(),
						quotationList.get(a).getCompDate(), quotationList.get(a).getContactNum(),
						quotationList.get(a).getContactEmail());
			}
			return output;

		}

		public static void viewAllQuotations(ArrayList<Quotation> quotationList) {
			C206_CaseStudy.setHeader("You have these quotations: ");

			String output = String.format("", "REQUEST NAME", "PROPERTY TYPE", "AREA SIZE",
					"RENOVATION TYPE", "NO. OF ROOMS TO RENOVATE", "NO. OF TOILETS TO RENOVATE",
					"BUDGET", "TARGET COMPLETION DATE", "CONTACT NUMBER", "CONTACT EMAIL");
			output += viewAllQuotations0(quotationList);
			System.out.println(output);
		}

		// Delete quotation
		public static void deleteQuotation(ArrayList<Quotation> quotationList) {
			int quotationID = Helper.readInt("Enter a quotation ID to delete > ");
			char confirmDelete = Helper.readChar("Confirm that this quotation ID is to be deleted? (Y/N) > ");

			boolean deletedID = false;
			if (confirmDelete == 'Y' || confirmDelete == 'y') {
				for (int a = 0; a < quotationList.size(); a++) {
					if (quotationID == quotationList.get(a).getQuotation_ID()) {
						quotationList.remove(a);
						deletedID = true;
					}
					else {
						deletedID = false;
					}
				}
				if (deletedID == true) {
					System.out.println("Quotation deleted successfully!");
				}
				else {
					System.out.println("Quotation was not deleted due to an invalid quotation ID. Please try again!");
				}

			} else if (confirmDelete == 'N' || confirmDelete == 'n') {
					System.out.println("No quotation was deleted.");
					}
			else {
				System.out.println("Invalid confirmation input. Please try again!");
			}

		}*/

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
