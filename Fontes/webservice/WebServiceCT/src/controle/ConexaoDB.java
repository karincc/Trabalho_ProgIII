/**
 * Classe de conexao com base de dados
 * 
 * @version 0.1
 */

package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoDB {
	
	private static EntityManagerFactory entityManagerFactory;
	public static EntityManager manager;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("CT");
		manager = entityManagerFactory.createEntityManager();
	}
}
