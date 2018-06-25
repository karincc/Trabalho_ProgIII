package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/exemplo")

public class Exemplo {
	@GET
	@Produces("text/plain")
	public String imprimir() {
		return "Teste de WebService";
	}
}
