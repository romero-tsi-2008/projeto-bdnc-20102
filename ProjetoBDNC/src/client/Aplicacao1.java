package client;

import java.util.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

import java.math.*;


public class Aplicacao1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String historico = "";
		
		//Início da contagem do tempo total
		long temp = System.currentTimeMillis();
		
		//Persistindo Clientes...		
			//tempo para persistir 100 usuarios		
		DAOclienteIF DAOcliente = DAOFactory.getInstance("jpa").createClienteDAO();		
		DAOcliente.begin();
		
		System.out.println("\n\nPersistindo 100 usuarios...");
		long temp_usuarios = System.currentTimeMillis();
		for (int i=1; i<=100; i++) {
			UsuarioIF c = new Cliente();
			c.setNome("Cliente"+i);
			c.setCpf("11111111111");
			c.setApelido("Cli"+i);
			c.setEmail("email.com"+i);
			c.setSenha("senha"+i);
			DAOcliente.persist(c);			
		}					
		DAOcliente.commit();
		DAOcliente.close();
		//Fim de persistência de Clientes.
			//fim de contagem de tempo de persistencia de 300 usuarios
			historico += "\nTempo de persistencia de 300 usuarios: "+(System.currentTimeMillis()-temp_usuarios);
			
			
			
			
			
		
		//Persistindo Admin...		
			//tempo para persistir 1 Admin		
		DAOadministradorIF DAOadmin = DAOFactory.getInstance("jpa").createAdministradorDAO();		
		DAOadmin.begin();
		
		System.out.println("\n\nPersistindo 1 Admin...");
		long temp_admin = System.currentTimeMillis();
		for (int i=101; i<=101; i++) {
			UsuarioIF a = new Administrador();
			a.setId(i);
			a.setNome("Admin"+(i-100));
			a.setCpf("11111111111");
			a.setApelido("Admin"+(i-100));
			a.setEmail("email.com"+i);
			a.setSenha("senha"+i);
			DAOadmin.persist(a);			
		}					
		DAOadmin.commit();
		DAOadmin.close();
		//Fim de persistência de Admin.
			//fim de contagem de tempo de persistencia de 1 Admin
			historico += "\nTempo de persistencia de 1 administrador: "+(System.currentTimeMillis()-temp_admin);
			
			
		

		
		
		//Persistindo UFs...			
			//tempo para persistir 10 UFs			
		DAOufIF DAOuf = DAOFactory.getInstance("jpa").createUfDAO();
		DAOuf.begin();
				
		long temp_UFs = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 10 UFs...");
		for (int i=1; i<=10; i++) {
			UF uf = new UF();
			uf.setNome("UF"+i);
			DAOuf.persist(uf);			
		}
		DAOuf.commit();
		DAOuf.close();
		//Fim de persistência de UFs.
			//fim de contagem de tempo de persistencia de 100 usuarios
			historico += "\nTempo de persistencia de 10 UFs: "+(System.currentTimeMillis()-temp_UFs);
		
		
		
		//Persistindo Cidades...
			
		//primeiro pegamos um UF de codigo "1" 
		DAOuf = DAOFactory.getInstance("jpa").createUfDAO();
		DAOuf.begin();		
		UF uf = (UF) DAOuf.findById(1);
		
		//agora vamos persistindo as cidades desse UF de codigo "1"
		DAOcidadeIF DAOcidade = DAOFactory.getInstance("jpa").createCidadeDAO();
		DAOcidade.begin();
		long temp_Cidades = System.currentTimeMillis();
		
		System.out.println("\n\nPersistindo 20 cidades...");
		for (int i=1; i<=20; i++) {			
			Cidade cid = new Cidade();
			cid.setNome("Cidade"+i);
			cid.setUf(uf);
			DAOcidade.persist(cid);			
		}		
		DAOcidade.commit();
		DAOcidade.close();
		//Fim de persistência de Cidades.
			//fim de contagem de tempo de persistencia de 20 cidades
			historico += "\nTempo de persistencia de 20 cidades: "+(System.currentTimeMillis()-temp_Cidades);
		
		
		
		//Persistindo 101 Enderecos			
		DAOenderecoIF DAOend = DAOFactory.getInstance("jpa").createEnderecoDAO();
		DAOend.begin();		

		long temp_Enderecos = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 101 enderecos...");
		for(int i=1; i<=101; i++) {
			Endereco e = new Endereco();
			e.setBairro("Bairro"+i);
			e.setNumero(i);
			e.setRua("Rua"+i);
			e.setComplemento("Complemento"+i);
			DAOend.persist(e);
		}
		DAOend.commit();
		DAOend.close();		
		//Fim de persistência de Endereco
			//fim de contagem de tempo de persistencia de 100 Enderecos
			historico += "\nTempo de persistencia de 100 enderecos: "+(System.currentTimeMillis()-temp_Enderecos);
		
			
			
			
			
		//Persistindo 1 Endereco pra cada Usuario (101 enderecos)...
		DAOusuarioIF DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		DAOusuario.begin();		
		List<Usuario> lista_u = (List<Usuario>) DAOusuario.listarUsuarios();
		
		DAOend = DAOFactory.getInstance("jpa").createEnderecoDAO();
		DAOend.begin();		
		List<Endereco> lista_ends = (List<Endereco>) DAOend.listarEnderecos();
		
		long temp_Endereco = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 1 endereço para cada um dos 101 usuarios");

		for (int i=1; i<=lista_u.size(); i++) {
			Usuario user = lista_u.get(i-1);
			user.setEndereco(lista_ends.get(i-1));
			DAOusuario.merge(user);
		}
		DAOusuario.commit();
		DAOusuario.close();
		DAOend.close();
		//Fim da persistencia de Enderecos
		//fim de contagem de tempo de persistencia de 101 Enderecos
		historico += "\nTempo de persistencia de 101 Enderecos: "+(System.currentTimeMillis()-temp_Endereco);
			
			
		
		
			
		//Persistindo 1 Telefone pra cada Usuario (100 telefones)...			
		DAOtelefoneIF DAOtel= DAOFactory.getInstance("jpa").createTelefoneDAO();
		DAOtel.begin();
		
		DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		DAOusuario.begin();		
		lista_u = (List<Usuario>) DAOusuario.listarUsuarios();
		DAOusuario.close();
		
		long temp_Telefones = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 1 telefone para cada um dos 100 usuarios");
		for (int i=1; i<=lista_u.size(); i++) {
			Telefone tel = new Telefone();
			tel.setNumero("Tel"+i);
			tel.setUsuario(lista_u.get(i-1));
			DAOtel.persist(tel);			
		}
		
		System.out.println("\nPersistindo +1 telefone para cada os 50 primeiros usuarios");
		//Persistindo +1 Telefone para os 50 primeiros Usuarios...		
		for (int i=101; i<=151; i++) {
			Telefone tel = new Telefone();
			tel.setNumero("Tel"+i);
			tel.setUsuario(lista_u.get(i-(lista_u.size()-1)));			
			DAOtel.persist(tel);			
		}
		
		DAOtel.commit();		
		DAOtel.close();
		//Fim da persistencia de Telefones
			//fim de contagem de tempo de persistencia de 150 Telefones
			historico += "\nTempo de persistencia de 150 Telefones: "+(System.currentTimeMillis()-temp_Telefones);				
		
			

			
		//Persistindo 50 Categorias			
		DAOcategoriaIF DAOcategoria = DAOFactory.getInstance("jpa").createCategoriaDAO();
		DAOcategoria.begin();
		
		long temp_Categorias = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 50 Categorias");
		for(int i=1;i<=50;i++){
			Categoria cat = new Categoria();
			cat.setNome("cat"+i);
			DAOcategoria.persist(cat);
		}
		DAOcategoria.commit();
		DAOcategoria.close();
		//Fim da persistencia de Categoria
			//fim de contagem de tempo de persistencia de 50 Categorias
			historico += "\ntempo de persistencia de 50 Categorias: "+(System.currentTimeMillis()-temp_Categorias);
		
			
		
		//Persisinto 10 marcas
		DAOmarcaIF DAOmarca = DAOFactory.getInstance("jpa").createMarcaDAO();
		DAOmarca.begin();
			
		long temp_Marcas = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 10 Marcas");
		for(int i=1;i<=10;i++){
			Marca marca = new Marca();
			marca.setNome("marca"+i);
			DAOmarca.persist(marca);
		}
		DAOmarca.commit();
		DAOmarca.close();
		//Fim da persistencia de Marca
			//fim de contagem de tempo de persistencia de 10 Marcas
			historico += "\ntempo de persistencia de 10 Marcas: "+(System.currentTimeMillis()-temp_Marcas);
		

			
		//Persistindo 50 produtos
		
		//Pegando as categorias...
		DAOcategoria.begin();		
		List<Categoria> lista_categ = (List<Categoria>) DAOcategoria.listarCategorias();		
		DAOcategoria.close();
		
		//Pegando as marcas...
		DAOcategoria.begin();		
		List<Marca> marcas = (List<Marca>) DAOmarca.listarMarcas();		
		DAOcategoria.close();
		
		DAOprodutoIF DAOproduto = DAOFactory.getInstance("jpa").createProdutoDAO();
		DAOproduto.begin();		
		
		//tempo para persistir 50 Produtos
		long temp_Produtos = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 50 Produtos");
		for(int i=1;i<=50;i++){
			Produto prod = new Produto(i, "prod"+i);
			prod.setCategoria(lista_categ.get(i-1));
			prod.setMarca(marcas.get(0));
			DAOproduto.persist(prod);
		}
		DAOproduto.commit();
		DAOproduto.close();
		//Fim da persistencia de Produtos
			//fim de contagem de tempo de persistencia de 50 Telefones
			historico += "\nTempo de persistencia de 50 Produtos: "+(System.currentTimeMillis()-temp_Produtos);			
			
			
		
			
			
		//Persistindo 3 produtos na categoria 1
		DAOcategoria = DAOFactory.getInstance("jpa").createCategoriaDAO();
		DAOcategoria.begin();		
		Categoria categ1 = DAOcategoria.findById(1);
		
		DAOproduto = DAOFactory.getInstance("jpa").createProdutoDAO();
		DAOproduto.begin();
		
		List<Produto> prods_cat1 = (List<Produto>) DAOproduto.listarProdutos();		
		
		//tempo para persistir 3 produtos na categoria 1
		long temp_ProdCat = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 50 Produtos");
		List<Produto> novos_prods_cat1 = new ArrayList<Produto>();
		for(int i=1;i<=3;i++){
			Produto prod = prods_cat1.get(i-1);
			novos_prods_cat1.add(prod);		
			
		}
		categ1.setProdutos(novos_prods_cat1);
		DAOcategoria.persist(categ1);
		DAOcategoria.commit();
		DAOcategoria.close();		
		DAOproduto.close();
		//Fim da persistencia de 3 Produtos na Categoria 1
			//fim de contagem de tempo de persistencia 3 Produtos na Categoria 1
			historico += "\nTempo de persistencia de 3 Produtos na Categoria 1: "+(System.currentTimeMillis()-temp_ProdCat);
			
			
			
			
		
		//Persistindo 2 Equipamentos
		
		//Pegando as produtos...
		DAOproduto = DAOFactory.getInstance("jpa").createProdutoDAO();
		DAOproduto.begin();		
		List<Produto> produtos = (List<Produto>) DAOproduto.listarProdutos();		
		
		//tempo para persistir 2 Equipamentos
		long temp_Equip = System.currentTimeMillis();
		System.out.println("\n\nPersistindo 2 Equipamentos");

		DAOequipamentoIF DAOequip = DAOFactory.getInstance("jpa").createEquipamentoDAO();
		DAOequip.begin();
		
		List<Produto> prods1 = new ArrayList<Produto>();
		prods1.add(produtos.get(0));
		prods1.add(produtos.get(1));
		prods1.add(produtos.get(2));
		Equipamento ekip1 = new Equipamento();
		ekip1.setId(1);
		ekip1.setNome("Equip1");
		ekip1.setProdutos(prods1);
		DAOequip.persist(ekip1);
		
		List<Equipamento> aux = new ArrayList<Equipamento>();
		aux.add(ekip1);
		for (Produto p : prods1) {			
			p.setEquipamentos(aux);
			DAOproduto.persist(p);
		}
		
		List<Produto> prods2 = new ArrayList<Produto>();
		prods2.add(produtos.get(3));
		prods2.add(produtos.get(4));
		prods2.add(produtos.get(5));
		Equipamento ekip2 = new Equipamento();
		ekip2.setId(2);
		ekip2.setNome("Equip2");
		ekip2.setProdutos(prods2);
		DAOequip.persist(ekip2);
		
		aux = new ArrayList<Equipamento>();
		aux.add(ekip2);
		for (Produto p : prods2) {			
			p.setEquipamentos(aux);
			DAOproduto.persist(p);
		}

		DAOequip.commit();
		DAOproduto.commit();
		DAOproduto.close();
		DAOequip.close();
		//Fim da persistencia de Equipamentos
			//fim de contagem de tempo de persistencia de 2 Equipamentos
			historico += "\nTempo de persistencia de 2 Equipamentos: "+(System.currentTimeMillis()-temp_Equip);
			
			
			
			
		
		
		//Persistindo Cidades em Usuarios...								
			
		//Primeiro vamos pegar uma cidade de codigo "1"
		DAOcidade = DAOFactory.getInstance("jpa").createCidadeDAO();
		DAOcidade.begin();		
		Cidade city = (Cidade) DAOcidade.findById(1);		
		DAOcidade.close();
			
		
		DAOusuario = DAOFactory.getInstance("jpa").createUsuarioDAO();
		DAOusuario.begin();
		
		//Pegamos aqui a quantidade de usuarios
		List<Usuario> lista_usuarios = (List<Usuario>) DAOusuario.listarUsuarios();
		int quant_usuarios = lista_usuarios.size();		
		
		//Agora vamos inserir uma cidade para cada usuario
		System.out.println("\n\nInserindo cidade para os 100 usuarios");
		long temp_CidadeUsuario = System.currentTimeMillis();		
		for (int i=1; i<=quant_usuarios; i++) {
			UsuarioIF user = lista_usuarios.get(i-1);			
			user.setCidade(city);
			DAOusuario.persist(user);			
		}	
		DAOusuario.commit();
		DAOusuario.close();
		//Fim da persistencia de Cidades em Usuarios
			//fim de contagem de tempo de persistencia de Cidade em 100 Usuarios
			historico += "\nTempo de persistencia de Cidade em 100 usuarios: "+(System.currentTimeMillis()-temp_CidadeUsuario);
	
		
		
		//fim da contagem do tempo total
		historico += "\nTempo total de execucao: "+(System.currentTimeMillis()-temp);
		System.out.print(historico);
	}

}
