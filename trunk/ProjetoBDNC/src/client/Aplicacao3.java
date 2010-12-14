package client;

import java.util.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

import java.math.*;

import javax.persistence.CascadeType;

public class Aplicacao3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Início de marcação de tempo
		long temp = System.currentTimeMillis();
		
		
		
		//Excluir M:N -sem- cascata
		DAOequipamentoIF DAOekip = DAOFactory.getInstance("jpa").createEquipamentoDAO();
		DAOekip.begin();
		long tempManyToManySem = System.currentTimeMillis();
		System.out.println("\n\nInício de consulta M:N -sem- cascata (exclusao de um um equipamento)");
		
		System.out.println("Removendo o equipamento 2...");
		
		Equipamento ekip2 = (Equipamento) DAOekip.findById(2);
		DAOekip.remove(ekip2);
		DAOekip.commit();
		DAOekip.close();
		System.out.println("\nTempo da exclusão M:N -sem- cascata: "+(System.currentTimeMillis()-tempManyToManySem));
		//-----------------------------------
		
		
		
		
		
		//Excluir M:N -com- cascata
			//para realizar esta consulta é necessário colocar na propriedade 'produtos' da classe Equipamento
			//a senguinte anotation: CascadeType.REMOVE
		DAOekip = DAOFactory.getInstance("jpa").createEquipamentoDAO();
		DAOekip.begin();
		long tempManyToManyCom = System.currentTimeMillis();
		System.out.println("\n\nInício de consulta M:N -com- cascata (exclusao de um um equipamento)");
		
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
		System.out.println("Excluindo os produtos que estao relacionado com a categoria 1...)");
		DAOprodutoIF DAOprod = DAOFactory.getInstance("jpa").createProdutoDAO();		
		DAOprod.begin();
		
		List<Produto> prods_lista = (List<Produto>) DAOprod.findByCategoria(1);
		Iterator it = prods_lista.iterator();
		while (it.hasNext()) {
			Produto p = (Produto) it.next();
			DAOprod.remove(p);
		}
		DAOprod.commit();		
		DAOprod.close();
		//agora vamos exlcuir a categoria 1 em si
		DAOcategoriaIF DAOcateg = DAOFactory.getInstance("jpa").createCategoriaDAO();
		System.out.println("Excluindo categoria 1...)");
		DAOcateg.begin();
		long tempOneToManySem = System.currentTimeMillis();
		Categoria categ = (Categoria) DAOcateg.findById(1);
		
		DAOcateg.remove(categ);
		DAOcateg.commit();
		DAOcateg.close();		
		System.out.println("\nTempo da exclusão 1:M -sem- cascata: "+(System.currentTimeMillis()-tempOneToManySem));
		//-----------------------------------
		
		
		
		
		//Excluir 1:M -com- cascata		
		DAOusuarioIF DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		System.out.println("\n\nInício de consulta 1:M -com- cascata ()exclusao de um usuario em relacao a seus telefones");
		DAOusuario.begin();
		long tempOneToManyCom = System.currentTimeMillis();
		UsuarioIF user1 = (UsuarioIF) DAOusuario.findById(1);
		
		DAOusuario.remove(user1);
		DAOusuario.commit();
		DAOusuario.close();		
		System.out.println("\nTempo da exclusão 1:M -com- cascata: "+(System.currentTimeMillis()-tempOneToManyCom));
		//-----------------------------------
		
		
		
		
		
		//Excluir 1:1 -sem- cascata
		DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		System.out.println("\n\nRealizando consulta 1:1 -sem- cascata (exclusao de um usuario em relacao a sua cidade)");
		DAOusuario.begin();
		long tempOneToOneSem = System.currentTimeMillis();
		UsuarioIF user2 = (UsuarioIF) DAOusuario.findById(2);				
		
		DAOusuario.remove(user2);
		DAOusuario.commit();
		DAOusuario.close();
		System.out.println("\nTempo da exclusão 1:1 -sem- cascata: "+(System.currentTimeMillis()-tempOneToOneSem));
		//-----------------------------------
		
		
		
		
		//Excluir 1:1 -com- cascata
		DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		System.out.println("\n\nInício de consulta 1:1 -sem- cascata (exclusao de um usuario em relacao a seu endereco)");
		DAOusuario.begin();
		long tempOneToOneCom = System.currentTimeMillis();
		UsuarioIF user3 = (UsuarioIF) DAOusuario.findById(3);				
		
		DAOusuario.remove(user3);
		DAOusuario.commit();
		DAOusuario.close();
		System.out.println("\nTempo da exclusão 1:1 -sem- cascata: "+(System.currentTimeMillis()-tempOneToOneCom));

		//-----------------------------------
		
		
		

		
		System.out.println("Tempo total de execucao: "+(System.currentTimeMillis()-temp));
	}

}
