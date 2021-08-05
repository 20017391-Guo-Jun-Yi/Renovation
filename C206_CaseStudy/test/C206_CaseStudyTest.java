import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class C206_CaseStudyTest {
	private Appointment app1;
	private Appointment app2;
	private Packages p1;
	private Packages p2;
	
	private ArrayList<Packages> pList;

	private ArrayList<Appointment> appointmentList;
	
public C206_CaseStudyTest() {
	super();
}


	

	@Before
	public void setUp() throws Exception {

		app1 = new Appointment("01/08/2021", "14:00", "JEN", "Lixuan", "RP");
		app2 = new Appointment("02/09/2021", "16:00", "MARY", "JOHN", "SP");
		
		appointmentList= new ArrayList<Appointment>();
	

		//prep test data
		p1 = new Packages(1, "SamplePackage1", "30-07-2021", "06-08-2021", "$5000");
		p2 = new Packages(2, "SamplePackage2", "31-07-2021", "06-08-2021", "$6000");
		pList = new ArrayList<Packages>();
		
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
		C206_CaseStudy.deletePackages(pList);
		assertEquals("Check that Packages arraylist size is 0", 0, pList.size());
		assertSame("Check that Packages is deleted", p1, pList.get(0));

	}


	@Test
	public void addusertest()
	{
		
	}
	public void viewalltest()
	{
		
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
	/*@Test
	public void testDeleteAppointment() {
		// Item list is not null, so that can delete a new item.
		assertNotNull("Test if there is valid appointment arraylist to delete from", appointmentList);
		
		//After deleting all item, the size of the list is 0
		C206_CaseStudy.deleteAppointment(appointmentList);		
		
		assertEquals("Test if that appointment arraylist size is 0?", 0, appointmentList.size());
		
		
		
		//The item just deleted is as same as the first item of the list.
		assertSame("Test that appointment deleted is same as item of the list?", app1, appointmentList.get(0));
		
	}*/
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

	@After
	public void tearDown() throws Exception {
		app1 = null;
		app2 = null;
		
		appointmentList = null;
		
		p1 = null;
		pList = null;
	}
}