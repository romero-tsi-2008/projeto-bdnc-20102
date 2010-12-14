package client;
import model.*;
import DAOFactory.DAOFactory;
import DAOInterface.*;
public class Aplicacao2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		long temp = System.currentTimeMillis();
		
		
		
		//Alterar um relacionamento 1:1 ---------------------------------------------------------------------------------
			//Este relacionamento entre usuario e cidade é 1:1 porque um usuario só pode ter apenas um cidade, embora
			//esta mesma cidade possa estar para vários usuários, no entanto é um relacionamento 1:1 UNIdirecional
		
		DAOufIF DAOuf = DAOFactory.getInstance("jpa").createUfDAO();
		DAOuf.begin();
		
		//resgatando um UF
		UF uf1 = DAOuf.findById(1);
		DAOuf.close();
		
		DAOcidadeIF DAOcidade = DAOFactory.getInstance("jpa").createCidadeDAO();
		DAOcidade.begin();
		
		
		//Criando uma nova Cidade para o UF 1		
		Cidade c = new Cidade();
		c.setNome("Joao Pessoa");
		c.setUf(uf1);		
		long tempOneToOne = System.currentTimeMillis();
		System.out.println("\nCriando uma nova cidade chamada 'Joao Pessoa'...");
		DAOcidade.persist(c);
		DAOcidade.commit();
		DAOcidade.close();
		
		DAOusuarioIF DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		DAOusuario.begin();		
		//selecionando um usuario de codigo 1
		Usuario usuario1 = DAOusuario.findById(1);		
		System.out.println("Alterando relacionamento 1:1...");
		usuario1.setCidade(c);		
		DAOusuario.commit();
		System.out.println("\nTempo para alteracao 1:1: "+(System.currentTimeMillis()-tempOneToOne));
		
	
		

		//Alterar um relacionamento 1:M	----------------------------------------------------------------------------------
		long tempOneToMany = System.currentTimeMillis();
		
		//selecionando um usuario de codigo 100
		Usuario usuario100 = DAOusuario.findById(100);		

		System.out.println("\n\nAlterando relacionamento 1:M...");
		usuario100.addTelefones(new Telefone(usuario100, "12452467"));		
		usuario100.setApelido("doidim");
		DAOusuario.merge(usuario100);
		
		DAOusuario.commit();
		DAOusuario.close();
		System.out.println("\nTempo de alteração em relacionamento 1:M: "+(System.currentTimeMillis()-tempOneToMany));	
		
		
		//Alterar um relacionamento M:N	----------------------------------------------------------------------------------
		DAOprodutoIF DAOproduto = DAOFactory.getInstance("jpa").createProdutoDAO();
		DAOproduto.begin();
		
		long tempManyToMany = System.currentTimeMillis();		
		
		//selecionando um Produto
		Produto prod10 = DAOproduto.findById(10);
		
		System.out.println("\n\nAlterando relacionamento M:N...");
		prod10.setNomeproduto("Teclado");
		DAOproduto.merge(prod10);
		DAOproduto.commit();
		DAOproduto.close();
		System.out.println("\nTempo de alteração em relacionamento M:M: "+(System.currentTimeMillis()-tempManyToMany));
		
		System.out.println("\nTempo total de execucao: "+(System.currentTimeMillis()-temp));		
	}

}
