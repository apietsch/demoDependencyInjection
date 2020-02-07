package be.pengo.demoDependencyInjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoDependencyInjectionApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoDependencyInjectionApplication.class);
	
	@Bean
	public MessageService getMessageService(){
		return new EmailServiceImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDependencyInjectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		logger.info("CommandLineRunner demo");
		return null;
	}
}
