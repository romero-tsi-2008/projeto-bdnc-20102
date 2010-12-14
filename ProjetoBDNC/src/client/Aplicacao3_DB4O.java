package client;

import java.util.Iterator;
import java.util.List;

import com.db4o.Db4o;

import model.Categoria;
import model.Equipamento;
import model.Marca;
import model.Produto;
import model.Usuario;
import model.UsuarioIF;
import DAOFactory.DAOFactory;
import DAOInterface.DAOcategoriaIF;
import DAOInterface.DAOequipamentoIF;
import DAOInterface.DAOmarcaIF;
import DAOInterface.DAOprodutoIF;
import DAOInterface.DAOusuarioIF;

public class Aplicacao3_DB4O {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Início de marcação de tempo
		long temp = System.currentTimeMillis();
		
		
		
		//Excluir M:N -sem- cascata
		DAOequipamentoIF DAOekip = DAOFactory.getInstance("db4o").createEquipamentoDAO();
		DAOekip.begin();
		Db4o.newConfiguration().objectClass(Equipamento.class).cascadeOnDelete(false);
		long tempManyToManySem = System.currentTimeMillis();
		System.out.println("\n\nInício de consulta M:N -sem- cascata (exclusao de um equipamento)");
		
		System.out.println("Removendo o equipamento 2...");
		
		Equipamento ekip2 = (Equipamento) DAOekip.findById(2);
		DAOekip.remove(ekip2);
		DAOekip.commit();
		DAOekip.close();
		System.out.println("Tempo da exclusão M:N -sem- cascata: "+(System.currentTimeMillis()-tempManyToManySem));
		//-----------------------------------
		
		
		
		
		
		//Excluir M:N -com- cascata
		DAOekip = DAOFactory.getInstance("db4o").createEquipamentoDAO();
		DAOekip.begin();
		Db4o.newConfiguration().objectClass(Equipamento.class).cascadeOnDelete(true);
		Db4o.newConfiguration().objectClass(Produto.class).cascadeOnDelete(true);

		long tempManyToManyCom = System.currentTimeMillis();
		System.out.println("\n\nInício de consulta M:N -com- cascata (exclusao de um equipamento)");
		
		System.out.println("Removendo o equipamento 1...");
		
		Equipamento ekip1 = (Equipamento) DAOekip.findById(1);
		DAOekip.remove(ekip1);
		DAOekip.commit();
		DAOekip.close();
		System.out.println("Tempo da exclusão M:N -comm- cascata: "+(System.currentTimeMillis()-tempManyToManyCom));
		//-----------------------------------

		
		
		
		
		//Excluir 1:M -sem- cascata		
		System.out.println("\n\nRealizando consulta 1:M -sem- cascata (exclusao de uma categoria em relacao aos seus produtos)");
		
		//uma categoria tem uma lista de produtos
		//para poder exlcuir uma categoria devemos primeiro excluir os produtos que estao relacionados com esta categoria
		System.out.println("Excluindo os produtos que esta relacionados com a categoria 1...)");
		DAOprodutoIF DAOprod = DAOFactory.getInstance("db4o").createProdutoDAO();		
		DAOprod.begin();
		
		List<Produto> prods_lista = DAOprod.findByCategoria(1);
		Iterator it2 = prods_lista.iterator();
		while (it2.hasNext()) {
			Produto p = (Produto) it2.next();
			DAOprod.remove(p);
		}
		DAOprod.commit();		
		DAOprod.close();
		//agora vamos exlcuir a categoria 1 em si
		DAOcategoriaIF DAOcateg = DAOFactory.getInstance("db4o").createCategoriaDAO();
		System.out.println("Excluindo categoria 1...)");
		DAOcateg.begin();
		long tempOneToManySem = System.currentTimeMillis();
		Categoria categ = (Categoria) DAOcateg.findById(1);
		
		DAOcateg.remove(categ);
		DAOcateg.commit();
		DAOcateg.close();		
		System.out.println("Tempo da exclusão 1:M -sem- cascata: "+(System.currentTimeMillis()-tempOneToManySem));
		//-----------------------------------
		
		
		
		
		//Excluir 1:M -com- cascata		
		DAOusuarioIF DAOusuario = DAOFactory.getInstance("db4o").createUsuarioDAO();
		System.out.println("\n\nInício de consulta 1:M -com- cascata ()exclusao de um usuario em relacao a seus telefones");
		DAOusuario.begin();
		Db4o.newConfiguration().objectClass(Usuario.class).cascadeOnDelete(true);
		long tempOneToManyCom = System.currentTimeMillis();
		UsuarioIF user1 = (UsuarioIF) DAOusuario.findById(1);
		
		DAOusuario.remove(user1);
		DAOusuario.commit();
		Db4o.newConfiguration().objectClass(Usuario.class).cascadeOnDelete(false);
		DAOusuario.close();		
		System.out.println("Tempo da exclusão 1:M -com- cascata: "+(System.currentTimeMillis()-tempOneToManyCom));
		//-----------------------------------
		
		
		
		
		
		//Excluir 1:1 -sem- cascata
		DAOusuario = DAOFactory.getInstance("db4o").createUsuarioDAO();
		System.out.println("\n\nRealizando consulta 1:1 -sem- cascata (exclusao de um usuario em relacao a sua cidade)");
		DAOusuario.begin();
		Db4o.newConfiguration().objectClass(Usuario.class).cascadeOnDelete(false);
		long tempOneToOneSem = System.currentTimeMillis();
		UsuarioIF user2 = (UsuarioIF) DAOusuario.findById(2);				
		
		DAOusuario.remove(user2);
		DAOusuario.commit();
		DAOusuario.close();
		System.out.println("Tempo da exclusão 1:1 -sem- cascata: "+(System.currentTimeMillis()-tempOneToOneSem));
		//-----------------------------------
		
		
		
		
		//Excluir 1:1 -com- cascata
		DAOusuario = DAOFactory.getInstance("db4o").createUsuarioDAO();
		System.out.println("\n\nInício de consulta 1:1 -com- cascata (exclusao de um usuario em relacao a seu endereco)");
		DAOusuario.begin();
		Db4o.newConfiguration().objectClass(Usuario.class).cascadeOnDelete(true);
		
		long tempOneToOneCom = System.currentTimeMillis();
		UsuarioIF user3 = (UsuarioIF) DAOusuario.findById(3);				
		
		DAOusuario.remove(user3);
		DAOusuario.commit();
		Db4o.newConfiguration().objectClass(Usuario.class).cascadeOnDelete(false);
		DAOusuario.close();
		System.out.println("Tempo da exclusão 1:1 -com- cascata: "+(System.currentTimeMillis()-tempOneToOneCom));

		//-----------------------------------
		
		
		
		
		System.out.println("\nTempo total de execucao: "+(System.currentTimeMillis()-temp));
		
	}

}
