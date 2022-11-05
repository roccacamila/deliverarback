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
		if (queue.equals("franquicia")) {
			   template.convertAndSend("/topic/franquicia", greeting);
			}
		if (queue.equals("desarrolloInterno")) {
			   template.convertAndSend("/topic/desarrolloInterno", greeting);
			}
		if (queue.equals("operador")) {
			   template.convertAndSend("/topic/operador", greeting);
			}
		if (queue.equals("partners")) {
			   template.convertAndSend("/topic/partners", greeting);
			}
		if (queue.equals("administrador")) {
			   template.convertAndSend("/topic/administrador", greeting);
			}
	}

}
