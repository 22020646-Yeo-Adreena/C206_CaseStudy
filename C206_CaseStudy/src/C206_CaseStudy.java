import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<ServiceProvider> serviceProvider = new ArrayList<ServiceProvider>();
		// TODO Auto-generated method stub
		ServiceProvider provider1 = new ServiceProvider("user1", "user1@example.com", "Allbest Marine", "Renovator");
		ServiceProvider provider2 = new ServiceProvider("user2", "user2@example.com", "Allbest Equipment", "Designer");

		serviceProvider.add(provider1);
		serviceProvider.add(provider2);

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add service provider
				ServiceProvider newProvider = inputProvider();
				
				for(ServiceProvider provider : serviceProvider) {
					if(newProvider.equals(serviceProvider)) {
						System.out.println("There is an existing service provider");
					}else {
						C206_CaseStudy.addServiceProvider(serviceProvider, newProvider);
					}
				}
				
			} else if (option == 2) {
				// View all service providers
				C206_CaseStudy.viewServiceProviders(serviceProvider);
			} else if (option == 3) {
				//Display list of service providers to choose from
				C206_CaseStudy.viewServiceProviders(serviceProvider);
				// Delete an existing service provider
				C206_CaseStudy.deleteServiceProvider(serviceProvider);
			} else {
				System.out.println("Goodbye!");
			}

		}

	}

	public static void menu() {
		System.out.println("RENOVATION PORTAL");
		System.out.println("1. Add service provider");
		System.out.println("2. View all service provider");
		System.out.println("3. Delete an existing service provider");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static ServiceProvider inputProvider() {
		String username = Helper.readString("Enter username >");
		String email = Helper.readString("Enter email >");
		String company = Helper.readString("Enter company >");
		String credentials = Helper.readString("Enter credentials >");
		

		ServiceProvider newProvider = new ServiceProvider(username, email, company, credentials);
		return newProvider;

	}

	public static void addServiceProvider(ArrayList<ServiceProvider> serviceProvider, ServiceProvider newProvider) {
		serviceProvider.add(newProvider);
	}
	public static String retrieveAllServiceProvider(ArrayList<ServiceProvider> serviceProvider) {
		String output = "";
		
		for (ServiceProvider provider : serviceProvider) {
			output += String.format("%s %-10s %-15s %-10s\n", provider.getUsername(),
					 provider.getEmail(), provider.getCompany(), provider.getCredentials());
		}
		return output;
		
	}

	public static void viewServiceProviders(ArrayList<ServiceProvider> serviceProvider) {
		System.out.println("SERVICE PROVIDER LIST");
		String output = String.format("%s %-10s %-15s %-10s", "Username",
				"Email", "Company", "Credentials");
		output += retrieveAllServiceProvider(serviceProvider);
		System.out.println(output);
	}
	public static boolean confirmDeleteServiceProvider(ArrayList<ServiceProvider> serviceProvider, String username, char confirm) {
		for(int i =0; i < serviceProvider.size(); i++) {
			ServiceProvider provider = serviceProvider.get(i);
			 if (provider.getUsername().equalsIgnoreCase(username)) {
	               if(confirm == 'y' || confirm == 'Y') {
	                serviceProvider.remove(provider);
	                return true;
	               }
	              }
	          }
	          return false;
		}
		
	

	public static void deleteServiceProvider(ArrayList<ServiceProvider> serviceProvider) {
		String username = Helper.readString("\nEnter Username to delete: ");
	    char confirm = Helper.readChar("Are you sure do you want to delete (y/n): ");
	          boolean isDeleted = confirmDeleteServiceProvider(serviceProvider, username, confirm);
	          
	          if (isDeleted) {
	           System.out.println("\n* User has been deleted successfully. *\n");
	          }else if(confirm == 'n' || confirm == 'N') {
	           System.out.println("\n* Deletion cancel! *\n");
	          }else {
	              System.out.println("\n* Invalid User! *\n");
	          }
		
	}
}
