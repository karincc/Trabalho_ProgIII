/**
 * Back-end de cadastro de Usuario
 * 
 * Implementa interface DAO
 * 
 * @version 0.1
 * @see DAO, Professor
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
import modelo.Usuario;

@Path("/usuario")
public class UsuarioService implements DAO<Usuario>{

	@POST
	@Consumes("application/json")
	@Override
	public Response adicionar(Usuario obj) {
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
		Usuario u = ConexaoDB.manager.find(Usuario.class, id);
		
		ConexaoDB.manager.getTransaction().begin();
		ConexaoDB.manager.remove(u);
		ConexaoDB.manager.getTransaction().commit();

		return Response.status(200).build();
	}

	@GET
	@Produces("application/json")
	@Override
	public Response listarTodos() {
		TypedQuery<Usuario> resultado = ConexaoDB.manager.createQuery(
				"SELECT NEW Usuario(id, dataNascimento, email, nome, sexo, senha) FROM Usuario u",
				Usuario.class);
		
		return Response.status(200).entity(resultado.getResultList()).type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Override
	public Response listar(@PathParam("id") int id) {
		Usuario u = ConexaoDB.manager.find(Usuario.class, id);
		return Response.status(200).entity(u).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Override
	public Response alterar(Usuario objNovo, @PathParam("id") int idAntigo) {
		Usuario usuarioAntigo = ConexaoDB.manager.find(Usuario.class, idAntigo); 
		
		ConexaoDB.manager.getTransaction().begin();
		usuarioAntigo.setDataNascimento(objNovo.getDataNascimento());
		usuarioAntigo.setEmail(objNovo.getEmail());
		usuarioAntigo.setNome(objNovo.getNome());
		usuarioAntigo.setSenha(objNovo.getSenha());
		usuarioAntigo.setSexo(objNovo.getSexo());
		ConexaoDB.manager.getTransaction().commit();
		
		return Response.status(201).entity("Usuario alterado").build();
	}
}
