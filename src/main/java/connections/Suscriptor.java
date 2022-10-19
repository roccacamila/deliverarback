package connections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import spring.Listener;
import spring.Mensaje;

public class Suscriptor {
	
	private ConectarRabbit conector;
	private Channel canal;
	private String consumerTag; //cada consumidor tiene que tener un consumerTag unico
	public Listener listener;
	

	
	public Suscriptor(String consumerTag) {
		this.conector = new ConectarRabbit();
		this.consumerTag = consumerTag;
	}
	
	public Suscriptor(String tag, Listener listener) {
		this.conector = new ConectarRabbit();
		this.consumerTag = tag;
		this.listener = listener;
	}

	public Object consumirPush(String queueName, boolean autoAck) throws IOException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException, TimeoutException {
		final Channel channel = conector.comenzarConexion();
		return channel.basicConsume(queueName, autoAck, "cliente",
		     new DefaultConsumer(channel) {
		         @Override
		         public void handleDelivery(String consumerTag,
		                                    Envelope envelope,
		                                    AMQP.BasicProperties properties,
		                                    byte[] body)
		             throws IOException
		         {
		             String routingKey = envelope.getRoutingKey();
		             String contentType = properties.getContentType();
		             properties.toString();
		             long deliveryTag = envelope.getDeliveryTag();
		             String message = new String(body, "UTF-8");
		             System.out.println(message);
		             listener.sendToTopicGreetings(new Mensaje("Queue: "+queueName+ " - Message: "+message));
		             channel.basicAck(deliveryTag, false);
		         }
		     });
	}

}
