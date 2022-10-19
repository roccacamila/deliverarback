package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Listener {
	
	@Autowired
	private SimpMessagingTemplate template;
	 
	public void sendToTopicGreetings(Mensaje greeting) {
	      template.convertAndSend("/topic/user", greeting);
	  }

}
