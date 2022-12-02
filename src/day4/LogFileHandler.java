package day4;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFileHandler {
	private static Handler fileHandler = null;

	public static Logger setLogger(String location, Logger logger) {
		String fileLocation;
		if (location == null || location.equals("")) {
			fileLocation = "./logger.properties";
		} else {
			fileLocation = location;
		}
		try {
			fileHandler = new FileHandler(fileLocation);
			SimpleFormatter simple = new SimpleFormatter();
			fileHandler.setFormatter(simple);
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logger;
	}
}
