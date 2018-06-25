package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.Pessoa;

@Path("/pessoa")
public class PessoaServico implements DAO<Pessoa>{

	static List<Pessoa> pessoas = new ArrayList<>();
	
	@POST
	@Consumes("application/json")
	@Override
	public Response adicionar(Pessoa obj) {
		if  (obj == null) {
			return Response.status(404).entity("Erro ao adicionar").type(MediaType.TEXT_PLAIN).build();
		}
		pessoas.add(obj);
		return Response.status(200).build();
	}

	@Override
	public Response alterar(Pessoa objNovo, int idAntigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response excluir(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Produces("application/json")
	@Override
	public List<Pessoa> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa listar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
