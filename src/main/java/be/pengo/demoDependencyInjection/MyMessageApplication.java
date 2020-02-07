package be.pengo.demoDependencyInjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyMessageApplication {

	private static Logger logger = LoggerFactory.getLogger(MyMessageApplication.class);

	private MessageService service;
	
	@Autowired
	public MyMessageApplication(MessageService svc){
		logger.info("Message Service gets wired through constructor!");
		this.service=svc;
	}
	
	@Autowired
	public void setService(MessageService svc){
		logger.info("Message Service gets wired through setter!");
		this.service=svc;
	}
	
	public boolean processMessage(String msg, String rec){
		logger.info("will sending message.. " + msg);
		return this.service.sendMessage(msg, rec);
	}
}