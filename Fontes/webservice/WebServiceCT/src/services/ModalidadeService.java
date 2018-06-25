/**
 * Back-end de modadalidades de aula/treinamento
 * 
 * Implementa interface DAO
 * 
 * @version 0.1
 * @see DAO, Modalidade
 */

package services;

import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import controle.ConexaoDB;
import modelo.Modalidade;

@Path("/modalidade")
public class ModalidadeService implements DAO<Modalidade> {

	@POST
	@Consumes("application/json")
	@Override
	public Response adicionar(Modalidade obj) {
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.persist(obj);
		ConexaoDB.manager.getTransaction().commit();
		
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{id}")	
	@Consumes("application/json")
	@Override
	public Response excluir(@PathParam("id") int id) {
		Modalidade m = ConexaoDB.manager.find(Modalidade.class, id);
		
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(m);
		ConexaoDB.manager.getTransaction().commit();

		return Response.status(200).build();
	}

	@GET
	@Produces("application/json")
	@Override
	public Response listarTodos() {
		TypedQuery<Modalidade> resultado = ConexaoDB.manager.createQuery(
				"SELECT NEW Modalidade(id, nome) FROM Modalidade m",
				Modalidade.class);

		return Response.status(200).entity(resultado.getResultList()).type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Override
	public Response listar(@PathParam("id") int id) {
		Modalidade m = ConexaoDB.manager.find(Modalidade.class, id);

		return Response.status(200).entity(m).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Override
	public Response alterar(Modalidade objNovo, @PathParam("id") int idAntigo) {
		Modalidade modalidadeAntiga = ConexaoDB.manager.find(Modalidade.class, idAntigo); 
		
		ConexaoDB.manager.getTransaction().begin();
		modalidadeAntiga.setNome(objNovo.getNome());
		ConexaoDB.manager.getTransaction().commit();
		
		return Response.status(201).entity("Modalidade alterada").build();	
	}
}
