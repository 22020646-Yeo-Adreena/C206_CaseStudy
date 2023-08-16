/**
 * 
 */

/**
 * @author 22020646
 *
 */
public class ServiceProvider {

	private String username;
	private String email;
	private String company;
	private String credentials;

	public ServiceProvider(String username, String email, String company, String credentials) {
		this.username = username;
		this.email = email;
		this.company = company;
		this.credentials = credentials;

	}

	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getCredentials() {
		return credentials;
	}

	

}


