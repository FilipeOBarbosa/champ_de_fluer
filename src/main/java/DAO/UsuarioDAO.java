package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import Pacote.Flor.Flor;

public class UsuarioDAO extends DAO{
	private EntityManager entityManager;

	private static UsuarioDAO flor = new UsuarioDAO();


	public UsuarioDAO() {
		try{
			this.entityManager = getEntityManager();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Algo deu errado!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void save(Flor flor) throws Exception {
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(flor);
			entityManager.getTransaction().commit();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Algo deu errado ao salvar a flor!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

	public Flor getId(int id) throws Exception {
		try{
			entityManager.getTransaction().begin();
			Flor flor = entityManager.find(Flor.class, id);
			entityManager.getTransaction().commit();
			return  flor;
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Não foi possivel achar a flor","ERRO",JOptionPane.ERROR_MESSAGE);
			throw new Exception("Não foi possivel achar a flor");
		}
	}

	public List<Flor> getAll() throws Exception {
		EntityManager em = entityManager;
		List<Flor> resultado = null;
		try {
			TypedQuery<Flor> query = em.createQuery("SELECT u FROM Flor u", Flor.class);
			resultado = query.getResultList();
		} catch (Exception pe) {
			pe.printStackTrace();
			JOptionPane.showMessageDialog(null,"Não foi possivel achar a flores","ERRO",JOptionPane.ERROR_MESSAGE);
			throw new Exception("Ocorreu algum erro ao tentar recuperar as Flores", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
}
