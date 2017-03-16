package actionPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {
	
	private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	public String getLogger() throws Exception{
		logger.trace("trace level");
		return "success";
	}
}
