import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class C206_CaseStudyTest {
	
	private Packages p1;
	private Packages p2;
	
	private ArrayList<Packages> pList;
	
	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
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

	@After
	public void tearDown() throws Exception {
		p1 = null;
		pList = null;
	}
}