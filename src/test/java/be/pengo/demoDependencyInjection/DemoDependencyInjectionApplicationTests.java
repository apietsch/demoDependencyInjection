package be.pengo.demoDependencyInjection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoDependencyInjectionApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@MockBean
	MessageService messageService;

	@Test
	void contextLoads() {
		when(this.messageService.sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(false);
		when(this.messageService.sendMessage("hello", "rec")).thenReturn(true);
		when(this.messageService.sendMessage("hello1", "rec")).thenReturn(true);

		MyMessageApplication bean = context.getBean(MyMessageApplication.class);
		boolean processMessage = bean.processMessage("hello", "rec");
		assertTrue(processMessage);
		boolean processMessage2 = bean.processMessage("hello4", "rec");
		assertFalse(processMessage2);
		boolean processMessage3 = bean.processMessage("hello1", "rec");
		assertTrue(processMessage3);

	}

}
