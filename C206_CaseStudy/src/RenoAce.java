/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20017391, 30 Jul 2021 10:04:25 pm
 */
import java.util.ArrayList;



public class RenoAce {

	public static void main(String[] args) {

		ArrayList<Packages> packageList = new ArrayList<Packages>();
		ArrayList<User> userList = new ArrayList<User>();
		

		packageList.add(new Packages(0001, "SamplePackage1", "30-07-2021", "08-08-2021", "$5000"));
		userList.add(new User("JunYi", "Master", "20017391@rp.edu.sg", "Password!", "Old"));
		
		int option = 0;

		while (option != 5) {

			RenoAce.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// JunHao
				RenoAce.setHeader("");
				RenoAce.setHeader("Options: ");
				System.out.println("1. ADD");
				System.out.println("2. VIEW");
				System.out.println("3. DELETE");
				
				int number = Helper.readInt("Enter option for a function: ");
				
				if (number == 1)
				{
					
				}
				else if (number == 2)
				{
					
				}
				else if (number == 3)
				{
					
				}
				else
				{
					System.out.println("Invaild option");
				}



			} else if (option == 2) {
				// JunYi
				RenoAce.setHeader("PACKAGES");			
				RenoAce.setHeader("OPTIONS :");
				System.out.println("1. ADD");
				System.out.println("2. VIEW");
				System.out.println("3. DELETE");

				int itemType = Helper.readInt("Enter option for a function > ");

				if (itemType == 1) {
					// Add Packages
					Packages pl = inputPackages();

				} else if (itemType == 2) {
					// View all Packages
					RenoAce.viewAllPackages(packageList);

				} else if (itemType == 3) {
					// Delete a Package
					RenoAce.deletePackages(packageList);
				} 

				else {
					System.out.println("Invalid option");
				}

			} else if (option == 3) {
				// Azri

			} else if (option == 4) {
				//Suet Teng

			} else if (option == 5) {
				//Lixuan

			}else {
				System.out.println("Invalid option");
			}

		}
	}
	public static void menu() {
		RenoAce.setHeader("Braiseduck & Co RENNOVATION APPLICATION");
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
	
	//================================= Option 1 (User)=================================
	public static User inputUser()
	{
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role: ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter Password");
		String status = "new";
		
		User us = new User (name, role, email, password, status);
		
		return us;
		
	}
	public static void addPackages(ArrayList<User> userList, User us) {

		userList.add(us);
		System.out.println("User added");
	}
	

	//================================= Option 2 (PACKAGE)=================================
	//Add package
	public static Packages inputPackages() {
		int code = Helper.readInt("Enter code > ");
		String description = Helper.readString("Enter description > ");
		String start = Helper.readString("Enter Start Date > ");
		String end = Helper.readString("Enter End Date > ");
		String amount = Helper.readString("Enter amount (include $)> ");

		Packages pl= new Packages(code, description, start, end, amount);
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
					packageList.get(i).getAmount()); //error
		}
		return output;
	}
	public static void viewAllPackages(ArrayList<Packages> packageList) {
		RenoAce.setHeader("PACKAGE LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "PACKAGE CODE", "DESCRIPTION",
				"START DATE", "END DATE","PACKAGE AMOUNT");
		output += viewAllPackages1(packageList);	
		System.out.println(output);
	}

	//Delete a package		
	public static void deletePackages(ArrayList<Packages> packageList) {
		int code = Helper.readInt("Enter code to delete > ");
		for (int i = 0; i < packageList.size(); i++) {
			if (code == packageList.get(i).getCode()) {
				//					packageList.get(i) = null; //error
			} else {
				System.out.println("Invalid Package code");
			}
		}

	}

}
