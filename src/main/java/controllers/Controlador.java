package controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import connections.Suscriptor;
import connections.Producer;
import spring.Listener;

public class Controlador {

	private Producer producer;
	private Suscriptor suscriptor;
	
	private static Controlador instancia;
	
	private Controlador() {
		this.producer = new Producer();
	}
	
	public static Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	
	public void enviarMensaje(String exchange, String routingKey, String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		producer.enviarMensaje(exchange, routingKey, mensaje);
		System.out.println("Enviado");
	}
	
	public Object suscribe(String queue, String tag, Listener listener) throws KeyManagementException, NoSuchAlgorithmException, IOException, URISyntaxException, TimeoutException { //el tag es lo que identifica al consumer, ser�a cliente, proveedor, repartidor, etc.
		this.suscriptor = new Suscriptor(tag, listener);
		return suscriptor.consumirPush(queue, false);
	}
}
