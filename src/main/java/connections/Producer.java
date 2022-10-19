package connections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Producer {
	
	private ConectarRabbit conector;
	
	public Producer() {
		this.conector = new ConectarRabbit();
	}
	
	public void enviarMensaje(String exchange, String routingKey, String mensaje) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		conector.comenzarConexion();
		conector.enviarMensaje(exchange, routingKey, mensaje);
		conector.cerrarConexion();
	}
}
