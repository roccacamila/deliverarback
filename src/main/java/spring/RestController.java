package spring;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import controllers.Controlador;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	//ENDPOINT 1
	/*@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/publicarMensaje")
	/*public void publicarMensaje(@RequestParam(name="canal") String exchange, @RequestParam(name="mensaje") String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().enviarMensaje(exchange, mensaje);
	}*/
	
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/publicarMensaje")
	public void publicarMensaje(@RequestParam(name="canal") String exchange,@RequestBody String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().enviarMensaje(exchange,mensaje);
	}
		
	
	//ENDPOINT 2
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/bind")
	public void bind(@RequestParam(name="canal") String exchange, @RequestParam(name="suscriptor") String queue) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().bind(exchange, queue);
	}
	
	//ENDPOINT 3
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/broadcast")
	public void broadcast(@RequestBody String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().broadcast(mensaje);
	}
	
	//ENDPOINT 4
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping("/unbind")
	public void unbind(@RequestParam(name="canal") String exchange, @RequestParam(name="suscriptor") String queue) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException  {
		Controlador.getInstancia().unbind(exchange, queue);
	}
	
}
