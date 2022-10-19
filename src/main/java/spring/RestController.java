package spring;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.Controlador;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	//ENDPOINT 1
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/publicarMensaje")
	public void publicarMensaje(@RequestParam(name="exchange") String exchange, @RequestParam(name="routingKey") String routingKey, @RequestParam(name="mensaje") String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().enviarMensaje(exchange, routingKey, mensaje);
	}
		
}
