package connections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Binding {
	
private ConectarRabbit conector;
	
	public Binding() {
		this.conector = new ConectarRabbit();
	}
	
	public void bind(String exchange, String queue) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		conector.comenzarConexion();
		conector.bind(exchange, queue);
		conector.cerrarConexion();
	}
	
	public void unbind(String exchange, String queue) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException {
		conector.comenzarConexion();
		conector.unbind(exchange, queue);
		conector.cerrarConexion();
	}

}
