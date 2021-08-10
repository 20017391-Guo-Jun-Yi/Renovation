import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Appointment app1;
	private Appointment app2;
	private Packages p1;
	private Packages p2;
	private User u;
	private User u2;
	private Request q1;
	private Request q2;
	private Quotation qu1;
	private Quotation qu2;

	private ArrayList<User> userList;
	private ArrayList<Packages> pList;
	private ArrayList<Request> requestList;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Quotation> qList;




	@Before
	public void setUp() throws Exception {

		//prep test data

		p1 = new Packages(1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000");
		p2 = new Packages(2, "SamplePackage2", "31-07-2021", "06-08-2021", "$6000");
		app1 = new Appointment("01/08/2021", "14:00", "JEN", "Lixuan", "RP");
		app2 = new Appointment("02/09/2021", "16:00", "MARY", "JOHN", "SP");
		u = new User("JunYi", "Master", "20017391@rp.com", "Old");
		u2 = new User("Chicken", "Developer", "Chicken@chicken.com", "New");
		q1 = new Request("HDB", "96.4", "Azri", "81234567", "azri@gmail.com", "12345.50", "12-10-2021","whole house", "4", "1", "vintage", "yes");
		q2 = new Request("Private", "123.4", "John", "82345678", "john@gmail.com", "23456.50", "20-09-2021","whole house", "6", "2", "scandinavian", "yes");
		qu1 = new Quotation("Suet Teng", "Landed", "1560 sq ft", "Rooms and Toilets",
				"4", "2", "1500", "12-09-21", "12345876", "20023627@myrp.edu.sg",
				"3");
		qu2 = new Quotation("Suet Teng", "Landed", "1000 sq ft", "Rooms and Toilets",
				"2", "1", "900", "18-10-21", "12345876", "20023627@myrp.edu.sg",
				"6");

		appointmentList= new ArrayList<Appointment>();
		pList = new ArrayList<Packages>();
		userList = new ArrayList<User>();
		requestList = new ArrayList<>();
		qList = new ArrayList<Quotation>();

	}
	@Test
	public void addPackTest() {
		assertNotNull("Check if there is valid Packages arraylist to add to", pList);

		C206_CaseStudy.addPackages(pList, p1);
		assertEquals("Check that Packages arraylist size is 1", 1, pList.size());
		assertSame("Check that Packages is added", p1, pList.get(0));

		C206_CaseStudy.addPackages(pList, p2);
		assertEquals("Check that Packages arraylist size is 2", 2, pList.size());
		assertSame("Check that Packages is added", p2, pList.get(1));
	}
	@Test
	public void viewAllPackagesTest() {
		assertNotNull("Test if there is a valid Package arraylist to retrieve item", pList);

		String allPackages= C206_CaseStudy.viewAllPackages1(pList);
		String testOutput = "";
		assertEquals("Check that ViewAllPackageslist", testOutput, allPackages);

		C206_CaseStudy.addPackages(pList, p1);
		C206_CaseStudy.addPackages(pList, p2);
		assertEquals("Test that Packages arraylist size is 2", 2, pList.size());

		allPackages= C206_CaseStudy.viewAllPackages1(pList);
		testOutput = String.format("%-20d %-20s %-20s %-20s %-20s\n",1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000");
		testOutput += String.format("%-20d %-20s %-20s %-20s %-20s\n",2, "SamplePackage2", "31-07-2021", "06-08-2021", "$6000");
		assertEquals("Test that ViewAllPackageslist", testOutput, allPackages);
	}
	@Test
	public void deletePackageTest() {
		assertNotNull("Check if there is valid Packages arraylist to delete from", pList);

		C206_CaseStudy.addPackages(pList, p1);
		C206_CaseStudy.deletePkg(pList, 0);
		assertEquals("Test if that Package arraylist size is 0?", 0, appointmentList.size());
	}

	@Test
	public void testAddAppointment() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid appointment arraylist to add to", appointmentList);

		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addAppointment(appointmentList, app1);		
		assertEquals("Test if that appointment arraylist size is 1?", 1, appointmentList.size());

		//The item just added is as same as the first item of the list
		assertSame("Test that appointment added is same as 1st item of the list?", app1, appointmentList.get(0));

		//Given an empty list, after adding 2 item, the size of the list is 2
		C206_CaseStudy.addAppointment(appointmentList, app2);		
		assertEquals("Test if that appointment arraylist size is 2?", 2, appointmentList.size());

		//The item just added is as same as the second item of the list
		assertSame("Test that appointment added is same as 2nd item of the list?", app2, appointmentList.get(1));


	}

	@Test
	public void testDeleteAppointment() {

		//Item list is not null, so that can delete a new item..
		assertNotNull("Test if there is valid appointment arraylist to delete from", appointmentList);

		// Add appointment, so arrayList not null
		C206_CaseStudy.addAppointment(appointmentList, app1);
		assertEquals("Test if that appointment arraylist size is 1?", 1, appointmentList.size());


		//After deleting all item, the size of the list is 0
		C206_CaseStudy.deleteAppointment(appointmentList, 0);		
		assertEquals("Test if that appointment arraylist size is 0?", 0, appointmentList.size());

	}
	@Test
	public void testviewAllAppointment() {

		// write your code here
		assertNotNull("Test if there is valid appointment arraylist to retrieve item", appointmentList);

		// test if the list of appointment retrieved is empty
		String allAppointment = C206_CaseStudy.viewAllAppointment(appointmentList);
		String testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n","Date-Of-Appointment", "Time-of-Appointment", "Designer Name", "Customer Name", "Address of the premise");
		assertEquals("Test that the viewAllAppointment list is empty?", testOutput, allAppointment);

		// given an empty list, after adding 2 items, test if the size of the list is 2 - normal

		C206_CaseStudy.addAppointment(appointmentList, app1);
		C206_CaseStudy.addAppointment(appointmentList, app2);

		assertEquals("Test that appointmentList size is 2", 2, appointmentList.size());
		// test if the expected output string is the same as the list of appointed retrieved from C206_CaseStudy

		allAppointment= C206_CaseStudy.viewAllAppointment(appointmentList);
		testOutput = String.format("%-20s %-20s %-20s %-20s %-20s\n","Date-Of-Appointment", "Time-of-Appointment", "Designer Name", "Customer Name", "Address of the premise");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","01/08/2021", "14:00", "JEN", "Lixuan", "RP");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s\n","02/09/2021", "16:00", "MARY", "JOHN", "SP");


		assertEquals("Check that ViewAllAppointment list is same as the list", testOutput, allAppointment);
	}

	@Test
	public void addusertest()
	{
		// Check the list if its not empty - Boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);

		// Check if the userList is able to add a data - Normal
		C206_CaseStudy.addusers(userList, u);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u, userList.get(0));

		// Check if the userlist has a data and is able to add in another data - Normal
		C206_CaseStudy.addusers(userList, u2);
		assertEquals("Check that user arraylist size is 2", 2, userList.size());
		assertSame("Check that user is added", u2, userList.get(1));
	}
	@Test
	public void viewalltest()
	{
		// Check the list if its not empty - Boundary	
		assertNotNull("Test if there is valid user arraylist to retrieve item", userList);

		// Check the userList is able to add multiple data into the list - Normal
		C206_CaseStudy.addusers(userList, u);
		C206_CaseStudy.addusers(userList, u2);
		assertEquals("Test that user arraylist size is 2", 2, userList.size());

		// Check if the userList is able to display the correct output - Normal
		String Alluser = C206_CaseStudy.ViewUser(userList);
		String testOutput = String.format("%-20s %-20s %-20s %-20s\n", "NAME", "EMAIL", "ROLE", "STATUS");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","JunYi", "20017391@rp.com", "Master", "Old");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","Chicken", "Chicken@chicken.com", "Developer","New" );
		assertEquals("Test that ViewAllUserlist", testOutput, Alluser);

	}
	@Test
	public void deletest()
	{
		// Check the list if its not empty - Boundary
		assertNotNull("Test if there is valid user arraylist to add to", userList);

		// Check the data if able to delete - Normal
		C206_CaseStudy.deleteUser(userList, u2);
		assertEquals("Test that user arraylist size is 0", 0, userList.size());

		// Check the data if able add and delete again - Normal
		C206_CaseStudy.addusers(userList, u);
		C206_CaseStudy.deleteUser(userList, u2);
		assertEquals("Test that user arraylist size is 1", 1, userList.size());

		// Check the data to delete again - Boundary
		C206_CaseStudy.deleteUser(userList, u);
		assertEquals("Test that user arraylist size is 0", 0, userList.size());
	}
	@Test
	public void addRequestTest() {

		assertNotNull("Check if there is valid Request arraylist to add to", requestList);
		C206_CaseStudy.addRequest(requestList, q1);
		assertEquals("Check that Request arraylist size is 1", 1, requestList.size());
		assertSame("Check that Request is added", q1, requestList.get(0));

		C206_CaseStudy.addRequest(requestList, q2);
		assertEquals("Check that Request arraylist size is 2", 2, requestList.size());
		assertSame("Check that Request is added", q2, requestList.get(1));
	}



	@Test
	public void viewAllRequestTest() {	
		assertNotNull("Test if there is valid request arraylist to retrieve item", requestList);

		C206_CaseStudy.addRequest(requestList, q1);
		C206_CaseStudy.addRequest(requestList, q2);
		assertEquals("Test that user arraylist size is 2", 2, requestList.size());

		String Allrequest = C206_CaseStudy.viewAllRequest(requestList);
		String testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Property Type", "Area Size", "Request Name", "Contact number", "Email", "Budget", "Target Completion Date", "Renovation type", "No. of rooms", "No. of toilets", "Renovation style", "Urgent request");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "HDB", "96.4", "Azri", "81234567", "azri@gmail.com", "12345.50", "12-10-2021", "whole house", "4", "1", "vintage", "yes");
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Private", "123.4", "John", "82345678", "john@gmail.com", "23456.50", "20-09-2021","whole house", "6", "2", "scandinavian", "yes");
		assertEquals("Test that ViewAllRequest", testOutput, Allrequest);
	}

	@Test
	public void deleteRequestTest()
	{
		assertNotNull("Test if there is valid appointment arraylist to delete from", requestList);

		C206_CaseStudy.addRequest(requestList, q1);
		assertEquals("Test if that request arraylist size is 1?", 1, requestList.size());

		C206_CaseStudy.deleteRequest(requestList, 0);		
		assertEquals("Test if that request arraylist size is 0?", 0, requestList.size());


	}
	
	@Test
	public void deleteQuotation() {
		//Test that item list is not null so that items can be deleted from it - Boundary
			assertNotNull("Test that item list is not null for deletion", qList);
		
		//Test that an item that is deleted, the list is now empty - Boundary
			C206_CaseStudy.deleteQuotation(qList, 0);
			assertTrue("Test that the list is now empty", qList.isEmpty());
	}
	
	@Test
	public void addQuotation() {
		//Test that item list is not null so that items can be added to it - Boundary
		assertNotNull("Test that item list is not null for addition", qList);
			
		//Test that the item just added is the same as the first item in the list - Normal
		C206_CaseStudy.addQuotations(qList, qu1);
		assertSame("Test that the first item added is in index 0 of the arraylist", qu1, qList.get(0));
			
		//Test that the item just added is the same as the second item in the list - Normal
		C206_CaseStudy.addQuotations(qList, qu2);
		assertSame("Test that the second item added is in index 1 of the arraylist", qu2, qList.get(1));

		//Test that when 1 item is added to the array list, the list's size becomes 2 - Normal
		assertEquals("Test that the array list size is 2 when an item is added", 2, qList.size());

	}
	
	
	@Test
	/*public void viewQuotation() {
		//Test that the output can be correctly displayed - Normal
		String viewAllQuo = C206_CaseStudy.viewAllQuotations(qList);
		String viewAllQuoTest = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s"
				+ "%-15s %-15s %-15s", "NAME", "PROPERTY", "AREA (SQ FT)", "TYPE",
				"NO. OF ROOMS", "NO. OF TOILETS", "BUDGET", "COMPLETION DATE", "MOBILE NO.", "EMAIL",
				"QUOTATION ID", "STYLE", "URGENCY STATUS");
		viewAllQuoTest += String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s"
				+ "%-15s %-15s %-15s", "Suet Teng", "Landed", "1560", "Rooms and Toilets",
				"4", "2", "1500", "12-09-21", "12345876", "20023627@myrp.edu.sg",
				"3", "Modern", "Y");
		viewAllQuoTest += String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s"
				+ "%-15s %-15s", "Suet Teng", "Landed", "1000", "Rooms and Toilets",
				"2", "1", "900", "18-10-21", "12345876", "20023627@myrp.edu.sg",
				"6", "Modern", "N");
		assertEquals("Test that the output can be correctly displayed", viewAllQuo, viewAllQuoTest);
			
		//Test that item list is not null so that items can be viewed - Boundary
		assertNotNull("Test that item list is not null for viewing", qList);
			
		//Test that after deleting 1 item, it will not be displayed
		//C206_CaseStudy.deleteQuotation(qList, qu2);
		//assertEquals("Test that there is only one item displayed after another was deleted", 1, qList.size());
		 
}*/
	



	@After
	public void tearDown() throws Exception {
		app1 = null;
		app2 = null;
		userList=null;
		appointmentList = null;
		u = null;
		u2 = null;
		q1 = null;
		q2 = null;
		requestList = null;
		p1 = null;
		p2 = null;
		pList = null;
		qu1 = null;
		qu2 = null;
		qList = null;
	}
}