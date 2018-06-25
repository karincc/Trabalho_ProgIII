/**
 * Interface DAO
 * 
 * @version 0.1
 */

package services;

import javax.ws.rs.core.Response;

public interface DAO<T> {
	/**
	 * Insert/POST
	 * 
	 * @param obj
	 */
	Response adicionar(T obj);
	
	
	/**
	 * Updade/PUT
	 * 
	 * @param objNovo
	 * @param idAntigo
	 */
	Response alterar(T objNovo, int idAntigo);
	
	/**
	 * DELETE
	 * 
	 * @param id
	 */
	Response excluir(int id);
	
	/**
	 * GET
	 * 
	 * @return status 200
	 */
	Response listarTodos();
	
	/**
	 * GET
	 * 
	 * @return status 200
	 */
	Response listar(int id);	
}
