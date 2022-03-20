package Pacote.Flor;


import DAO.FlorDAO;

public class FlorMain {
	public static void main (String[] args) throws Exception {
		FlorDAO dao = new FlorDAO();
		salvar(dao);

	}
	public static void salvar(FlorDAO dao) {
		try{
			Flor flor = new Flor();
			flor.setNome("Papoula");
			flor.setQuantidade(2);
			flor.setDescricao("nenhuma");
			flor.setPreco(0);
			dao.save(flor);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dao.close();
	}
}
