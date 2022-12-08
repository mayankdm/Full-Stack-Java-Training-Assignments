package week1;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {
	public static void main(String[] args) { 
		Logger logger = LogFileHandler.setLogger(null,Logger.getLogger(Tester.class.getName()));
		logger.log(Level.WARNING, "Warning Text!");
		logger.log(Level.CONFIG, "Config Text!");
		logger.log(Level.ALL, "All Text!");
		logger.log(Level.FINE, "A fine Text!");
		logger.log(Level.FINER, "A finer Text!");
		logger.log(Level.FINEST, "A finest Text!");
		logger.log(Level.INFO, "An info Text!");
		logger.log(Level.SEVERE, "Severe Text!");
		logger.log(Level.OFF, "No Loggings!");
		
		try {
			UserAuthentication authentication = new UserAuthentication();
			authentication.loginUser("Jon", "12345");
			System.out.println("User has logged in successfully");
		} catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
