package controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import connections.Suscriptor;
import connections.Binding;
import connections.Producer;
import spring.Listener;

public class Controlador {

	private Producer producer;
	private Suscriptor suscriptor;
	private Binding binder;
	
	private static Controlador instancia;
	
	private Controlador() {
		this.producer = new Producer();
		this.binder = new Binding();
	}
	
	public static Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	
	public void enviarMensaje(String exchange, String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		producer.enviarMensaje(exchange, mensaje);
		System.out.println("Enviado");
	}
	
	public void broadcast(String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		producer.broadcast(mensaje);
		System.out.println("Enviado");
	}
	
	public Object suscribe(String queue, String tag, Listener listener) throws KeyManagementException, NoSuchAlgorithmException, IOException, URISyntaxException, TimeoutException { //el tag es lo que identifica al consumer, ser�a cliente, proveedor, repartidor, etc.
		this.suscriptor = new Suscriptor(tag, listener);
		return suscriptor.consumirPush(queue, false);
	}
	
	public void bind(String exchange, String queue) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		this.binder.bind(exchange, queue);
	}

	public List<String> getExchanges() {
		return null;
	}
}
