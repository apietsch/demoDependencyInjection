package be.pengo.demoDependencyInjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

public class EmailServiceImpl implements MessageService {

	private static final Logger logger = LoggerFactory.getLogger(DemoDependencyInjectionApplication.class);

	@Override
	public boolean sendMessage(String msg, String rec) {
		logger.info("EmailService sending message.. " + msg);
		return true;
	}
}
