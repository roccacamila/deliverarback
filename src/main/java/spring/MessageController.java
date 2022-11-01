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
	@SendTo("/topic/user")
	public Mensaje cliente() throws Exception {
		Controlador.getInstancia().suscribe("cliente", "cliente", listener);
	    return new Mensaje("Conectado como cliente","core service");
	}
	
	@MessageMapping("/suscribeproveedor")
	@SendTo("/topic/user")
	public Mensaje proveedor() throws Exception {
		Controlador.getInstancia().suscribe("proveedor", "cliente", listener);
	    return new Mensaje("Conectado como proveedor","core service");
	}
	
	@MessageMapping("/suscriberepartidor")
	@SendTo("/topic/user")
	public Mensaje repartidor() throws Exception {
		Controlador.getInstancia().suscribe("repartidor", "cliente", listener);
	    return new Mensaje("Conectado como  repartidor","core service");
	}
}
