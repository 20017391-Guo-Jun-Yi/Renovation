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
	private ArrayList<User> u3;
	private User u2;
	private Request q1;
	private Request q2;

	private ArrayList<User> userList;
	private ArrayList<Packages> pList;
	private ArrayList<Request> requestList;
	private ArrayList<Appointment> appointmentList;




	@Before
	public void setUp() throws Exception {

		//prep test data

		p1 = new Packages(1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000");
		p2 = new Packages(2, "SamplePackage2", "31-07-2021", "06-08-2021", "$6000");
		app1 = new Appointment("01/08/2021", "14:00", "JEN", "Lixuan", "RP");
		app2 = new Appointment("02/09/2021", "16:00", "MARY", "JOHN", "SP");
		u = new User("JunYi", "Master", "20017391@rp.com", "Old");
		u2 = new User("Chicken", "Developer", "Chicken@chicken.com", "New");

		appointmentList= new ArrayList<Appointment>();
		pList = new ArrayList<Packages>();
		userList = new ArrayList<User>();

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
		
	    
	
			// Item list is not null, so that can delete a new item..
		assertNotNull("Test if there is valid appointment arraylist to delete from", appointmentList);
		
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
		// Check Not empty - Boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);

		// Add +1 - Normal
		C206_CaseStudy.addusers(userList, u);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u, userList.get(0));

		// 1 Add +1 - Normal
		C206_CaseStudy.addusers(userList, u2);
		assertEquals("Check that user arraylist size is 2", 2, userList.size());
		assertSame("Check that user is added", u2, userList.get(1));
	}
	@Test
	public void viewalltest()
	{
		// Check Not empty - Boundary	
		assertNotNull("Test if there is valid user arraylist to retrieve item", userList);

		// Empty +2 See inside = 2 - Normal
		C206_CaseStudy.addusers(userList, u);
		C206_CaseStudy.addusers(userList, u2);
		assertEquals("Test that user arraylist size is 2", 2, userList.size());

		// See output 2 = 2 - Normal
		String Alluser = C206_CaseStudy.ViewUser(userList);
		String testOutput = String.format("%-20s %-20s %-20s %-20s\n", "NAME", "EMAIL", "ROLE", "STATUS");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","JunYi", "20017391@rp.com", "Master", "Old");
		testOutput += String.format("%-20s %-20s %-20s %-20s\n","Chicken", "Chicken@chicken.com", "Developer","New" );
		assertEquals("Test that ViewAllUserlist", testOutput, Alluser);

	}
	@Test
	public void deletest()
	{
		// See got stuff or not 1 - Boundary
		assertNotNull("Test if there is valid user arraylist to add to", userList);
		
		// See can delete - Normal
		C206_CaseStudy.deleteUser(userList, u2);
		assertEquals("Test that user arraylist size is 0", 0, userList.size());

		// See can add and delete again - Normal
		C206_CaseStudy.addusers(userList, u);
		C206_CaseStudy.deleteUser(userList, u2);
		assertEquals("Test that user arraylist size is 1", 1, userList.size());
		
		// Boundary
		C206_CaseStudy.deleteUser(userList, u);
		assertEquals("Test that user arraylist size is 0", 0, userList.size());
	}
//	@Test
//	public void addRequestTest() {
//		// Item list is not null, so that can add a new item - boundary
//		assertNotNull("Check if there is valid Request arraylist to add to", requestList);
//		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
//		//The item just added is as same as the first item of the list
//		C206_CaseStudy.addRequest(requestList, q1);
//		assertEquals("Check that Request arraylist size is 1", 1, requestList.size());
//		assertSame("Check that Request is added", q1, requestList.get(0));
//
//		//Add another item. test The size of the list is 2? -normal
//		//The item just added is as same as the second item of the list
//		C206_CaseStudy.addRequest(requestList, q2);
//		assertEquals("Check that Request arraylist size is 2", 2, requestList.size());
//		assertSame("Check that Request is added", q2, requestList.get(1));
//	}

	/*@Test
	public void addRequestTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Request arraylist to add to", requestList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addRequest(requestList, q1);
		assertEquals("Check that Request arraylist size is 1", 1, requestList.size());
		assertSame("Check that Request is added", q1, requestList.get(0));
>>>>>>> branch 'master' of https://github.com/20017391-Guo-Jun-Yi/Renovation.git

//	@Test
//	public void viewAllRequestTest() {
//		// Check Not empty - Boundary	
//		assertNotNull("Test if there is valid user arraylist to retrieve item", requestList);
//
//		// Empty +2 See inside = 2 - Normal
//		C206_CaseStudy.addRequest(requestList, q1);
//		C206_CaseStudy.addRequest(requestList, q2);
//		assertEquals("Test that user arraylist size is 2", 2, requestList.size());
//
//		// See output 2 = 2 - Normal
//		String Allrequest = C206_CaseStudy.viewAllRequest(requestList);
//		String testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Property Type", "Area Size", "Request Name", "Contact number", "Email", "Budget", "Target Completion Date", "Renovation type", "No. of rooms", "No. of toilets", "Renovation style", "Urgent request");
//		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "HDB", "96.4", "Azri", "81234567", "azri@gmail.com", "12345.50", "12-10-2021", "whole house", "4", "1", "vintage", "yes");
//		testOutput += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "private", "164.2", "Alif", "82345678", "alif@gmail.com", "23456.60", "15-09-2021", "whole house", "6", "2", "classic", "yes");
//		assertEquals("Test that ViewAllRequest", testOutput, Allrequest);
//	}

	@Test
	public void deleteRequestTest()
	{
		// See got stuff or not 1 - Boundary
		assertNotNull("Test if there is valid user arraylist to add to", requestList);

		// See can delete or not - Normal
		C206_CaseStudy.addRequest(requestList, q2);
		Boolean ok = C206_CaseStudy.deleteRequest(requestList, "Alif");
		assertTrue("Test if the user is ok to delete", ok);

		// See can delete - Normal
		boolean t = (userList.remove(u2));
		assertTrue(t);

		// See can delete again - Error
		boolean t2 = (userList.remove(u2));
		assertFalse(t2);

	}
	 */


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
		p1 = null;
		p2 = null;
		pList = null;
	}
}