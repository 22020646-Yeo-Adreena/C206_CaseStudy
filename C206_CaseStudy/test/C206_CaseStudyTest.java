import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class C206_CaseStudyTest {
	//prepare test data
	private ServiceProvider provider1;
	private ServiceProvider provider2;
	
	private static ArrayList<ServiceProvider> serviceProvider;
	
	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		provider1 = new ServiceProvider("user1", "user1@example.com", "Allbest Marine", "Renovator");
		provider2 = new ServiceProvider("user2", "user2@example.com", "Allbest Equipment", "Designer");
		
		serviceProvider = new ArrayList<ServiceProvider>();
	}

	@Test
	public void testAddServiceProvider() {
		// Adding a new service provider
		// Given an empty list, after adding one service provider, the size of the list
		// is 1- normal
		C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
		assertEquals("Test that the Service Provider arraylist size is 1.", 1, serviceProvider.size());
		// Adding multiple service providers -boundary
		C206_CaseStudy.addServiceProvider(serviceProvider, provider2);
		assertEquals("Test that the Service Provider arraylist size is 2.", 2, serviceProvider.size());
		// checking if the list size is 2
		assertEquals(2, serviceProvider.size());
		// Adding duplicate service providers -error
		C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
		assertSame("Test that the service provider added is as same as the previous item added", provider1,
				serviceProvider.get(0));

	}
	@Test
	public void testRetrieveAllServiceProvider() {
		// Test Case 1
		// Test if Item list is not null and empty-boundary
		assertNotNull("Test if there is valid service provider arraylist to add to", serviceProvider);
		assertEquals("Test that the serviceProvider arraylist is empty.", 0, serviceProvider.size());
		// Attempt to retrieve the service providers
		String allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allServiceProviders);
		// Test Case 2
		// Test if can retrieve service providers-normal
		C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
		C206_CaseStudy.addServiceProvider(serviceProvider, provider2);
		// Test that the list is not empty
		assertEquals("Test that ServiceProvider arraylist size is 2.", 2, serviceProvider.size());
		// Attempt to retrieve the service providers
		allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
		testOutput = String.format("%s %-10s %-15s %-10s\n", "user1", "user1@example.com", "Allbest Marine", "Renovator");
		testOutput += String.format("%s %-10s %-15s %-10s\n", "user2", "user2@example.com", "Allbest Equipment", "Designer");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allServiceProviders);
		// Test Case 3
		// Test can view service providers with updated list- normal
		// Add new provider
		ServiceProvider newProvider = new ServiceProvider("user3", "user3@gmail.com", "Allbest delivery", "Constructor");
		C206_CaseStudy.addServiceProvider(serviceProvider, newProvider);
		// Attempt to retrieve the service providers
		allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
		testOutput = String.format("%s %-10s %-15s %-10s\n", "user1", "user1@example.com", "Allbest Marine", "Renovator");
		testOutput += String.format("%s %-10s %-15s %-10s\n", "user2", "user2@example.com", "Allbest Equipment", "Designer");
		testOutput += String.format("%s %-10s %-15s %-10s\n", "user3", "user3@gmail.com", "Allbest delivery", "Constructor");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allServiceProviders);

	}
	
	@Test
    public void testDeleteServiceProvider() {
     assertNotNull("Check if there is valid service provider arraylist to delete from", serviceProvider);

     // Adding service providers for testing
     C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
     C206_CaseStudy.addServiceProvider(serviceProvider, provider2);

     // Test delete a service provider
     String deletedUsername = provider1.getUsername();
     boolean isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, deletedUsername, 'y');
     assertEquals("Test that user1 is deleted", true, isDeleted);
     assertEquals("Test that user arraylist size is 1", 1, serviceProvider.size());
     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));

     // Test to cancel deletion 
     String undeletedUsername = provider2.getUsername();
     isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, undeletedUsername, 'n');
     assertEquals("Test that user2 is not deleted", false, isDeleted);
     assertEquals("Test that user arraylist size is 1", 1, serviceProvider.size());
     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));

     // Test deleting a service provider thats not in the list
     String nonexistentServiceProvider = "nonexistentServiceProvider";
     isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, nonexistentServiceProvider, 'y');
     assertEquals("Test that nonexistent user is not deleted", false, isDeleted);
     assertEquals("Test that user arraylist size is still 1", 1, serviceProvider.size());
     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));
     
    }
	
	@After
	public void tearDown() throws Exception {
		provider1 = null;
		provider2 = null;
		serviceProvider = null;
	}
	@Test
	public void c206_test() {
		//fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
}

