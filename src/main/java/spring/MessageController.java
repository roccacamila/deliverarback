package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import controllers.Controlador;

@Controller
public class MessageController {
	
	@Autowired
	public Listener listener;
	
	@MessageMapping("/suscribecliente")
	@SendTo("/topic/cliente")
	public Mensaje cliente() throws Exception {
		Controlador.getInstancia().consumirPush("cliente", "cliente", listener);
	    return new Mensaje("Consumiendo de cliente");
	}
}
