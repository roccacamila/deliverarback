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
	
	//Modulo 1
	@MessageMapping("/cliente")
	@SendTo("/topic/user")
	public Mensaje cliente() throws Exception {
		Controlador.getInstancia().suscribe("cliente", "cliente", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como cliente\"}","core service");
	}
	
	//Modulo 2
	@MessageMapping("/proveedor")
	@SendTo("/topic/user")
	public Mensaje proveedor() throws Exception {
		Controlador.getInstancia().suscribe("proveedor", "proveedor", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como proveedor\"}","core service");
	}
	
	//Modulo 3
	@MessageMapping("/repartidor")
	@SendTo("/topic/user")
	public Mensaje repartidor() throws Exception {
		Controlador.getInstancia().suscribe("repartidor", "repartidor", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como repartidor\"}","core service");
	}
	
	//Modulo 4
	@MessageMapping("/franquicia")
	@SendTo("/topic/user")
	public Mensaje franquicia() throws Exception {
		Controlador.getInstancia().suscribe("franquicia", "franquicia", listener);
	    return new Mensaje("{\"mensaje\": \"Conectado como franquicia\"}","core service");
	}
	
	//Modulo 5
	@MessageMapping("/partners")
	@SendTo("/topic/user")
	public Mensaje partners() throws Exception {
		Controlador.getInstancia().suscribe("partners", "partners", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como partners\"}","core service");
	}
	
	//Modulo 6
	@MessageMapping("/desarrolloInterno")
	@SendTo("/topic/user")
	public Mensaje desarrolloInterno() throws Exception {
		Controlador.getInstancia().suscribe("desarrolloInterno", "desarrolloInterno", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como desarollo interno\"}","core service");
	}
	
	//Modulo 7
	@MessageMapping("/operador")
	@SendTo("/topic/user")
	public Mensaje operador() throws Exception {
		Controlador.getInstancia().suscribe("operador", "operador", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como operador\"}","core service");
	}
	
	//Modulo 8
	@MessageMapping("/administrador")
	@SendTo("/topic/user")
	public Mensaje administrador() throws Exception {
		Controlador.getInstancia().suscribe("administrador", "administrador", listener);
		return new Mensaje("{\"mensaje\": \"Conectado como administrador\"}","core service");
	}
		
	

}
