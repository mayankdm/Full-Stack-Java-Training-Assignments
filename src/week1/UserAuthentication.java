package week1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAuthentication {
	public Logger logger = LogFileHandler.setLogger(null,Logger.getLogger(Tester.class.getName()));

	public void loginUser(String username, String password) throws Exception {
		try {
			if (username.isBlank() || password.isBlank()) {
				throw new Exception("Service.INVALID_CREDENTIALS");
			}
			logger.info(username + " logged in successfully");
		} catch (Exception exception) {
			logger.log(Level.SEVERE, exception.getMessage() + " " + exception.getCause());
			throw exception;
		}
	}
}
