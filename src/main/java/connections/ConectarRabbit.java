package connections;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class ConectarRabbit {
	
	public  final String CONFIG_PROPERTY_URI = "amqps://xwcoojjj:UJEmMGUmrRIK7uZiPPgXBAGkL6lzB1jO@jackal.rmq.cloudamqp.com/xwcoojjj";
	private Connection conn;
	private Channel channel;
	
	public ConectarRabbit() {
	}
	
	public Channel comenzarConexion() throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException{
		conn = this.createConnection();
		channel = conn.createChannel();
		return channel;
	}
	
	private Connection createConnection() throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException{
		final ConnectionFactory factory = new ConnectionFactory();
		factory.setUri(this.CONFIG_PROPERTY_URI);
		return factory.newConnection();
	}
	
	public void enviarMensaje(String exchange, String routingKey, String mensaje) throws IOException {
		channel.exchangeDeclare(exchange, "direct", true);
		byte[] messageBodyBytes = mensaje.getBytes();
		channel.basicPublish(exchange, routingKey, null, messageBodyBytes);
	}
	
	public void cerrarConexion() throws IOException, TimeoutException {
		channel.close();
		conn.close();
	}
}
