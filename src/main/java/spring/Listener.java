package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Listener {
	
	@Autowired
	private SimpMessagingTemplate template;
	 
	public void sendToTopicGreetings(Mensaje greeting, String queue) {
		System.out.println(greeting.getContenido());
		if (queue.equals("cliente")) {
		   template.convertAndSend("/topic/cliente", greeting);
		}
		if (queue.equals("proveedor")) {
		   template.convertAndSend("/topic/proveedor", greeting);
		}
		if (queue.equals("repartidor")) {
		   template.convertAndSend("/topic/repartidor", greeting);
		}
	}
	

	/*
	public void sendToTopicFranquicia(Mensaje greeting) {
	      template.convertAndSend("/topic/franquicia", greeting);
	  }

	public void sendToTopicPartners(Mensaje greeting) {
	      template.convertAndSend("/topic/partners", greeting);
	  }
	
	public void sendToTopicDesarolloInterno(Mensaje greeting) {
	      template.convertAndSend("/topic/desarrolloInterno", greeting);
	  }
	
	public void sendToTopicOperador(Mensaje greeting) {
	      template.convertAndSend("/topic/operador", greeting);
	  }
	
	public void sendToTopicAdministrador(Mensaje greeting) {
	      template.convertAndSend("/topic/franquicia", greeting);*/
	  

}
