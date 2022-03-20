package DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("champ_de_fluer");
	}

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close() {
		if (emf.isOpen()) {
			emf.close();
		}
	}
}
