package persistence.jpa;


import java.util.List;
import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOprodutoJPA extends DAOdefaultJPA implements DAOprodutoIF {
		
	public Produto findById(int id){
		return (Produto) findByQuery("select p from Produto p where p.id = "+id);
	}
	
	public List<Produto> listarProdutos(){
		return (List<Produto>) findAllByQueryLimited("select p from Produto p", 20);
	}
	
	public List<Produto> findByName(String nome){
		return (List<Produto>) findAllByQueryLimited("select p from Produto p where p.nome like '%"+nome+"'%", 20);
	}
	
	public List<Produto> findByCategoria(int id) {
		return (List<Produto>) findAllByQueryLimited("select p from Produto p join p.categoria c where c.id = "+id, 120);
	}

	public List<Produto> findByMarca(int id) {
		return (List<Produto>) findAllByQueryLimited("select p from Produto p join p.marcas m where m.id = "+id, 500);
	}
	
	/*
	public void find(Produto prod){
		getManager().find(Produto.class, prod);

	}
	
	public List<ProdutoIF> findByCategoria(Categoria cat){
		Query query = getManager().createQuery("select p from Produto p where p.categoria = :cat");
		query.setParameter("cat", cat);
		List<ProdutoIF> prods = query.getResultList();
		return prods;
	}
	

	public List<ProdutoIF> pesquisaPorData(){
		Query query = getManager().createQuery("select p from Produto p order by p.dataDaInclusao desc").setMaxResults(6).setFirstResult(0);
		List<ProdutoIF> prods = query.getResultList();
		return prods;
	}
	
	public List<ProdutoIF> finByPreco(double preco) {
		Query query = getManager().createQuery("select p from Produto p where p.preco <= :preco");
		query.setParameter("preco", preco);
		List<ProdutoIF> prods = query.getResultList();
		return prods;
	}
	public List<Produto> pesquisaSimples(String p){
		Query q = manager.createQuery("select p from Produto p where p.nomeproduto like '%"+p+"%'");
		return q.getResultList();
	}
	
	public List<Produto> PesquisaAvancada(String p, int c){		
		Query query = manager.createQuery("select p from Categoria c join c.produtos p where p.nomeproduto like '%"+p+"%' and c.id = "+ c);	
		return query.getResultList();
	}
	
	public List<ProdutoIF> getTopVendas() {
		Query query = manager.createQuery("select p from Produto p order by p.numeroDeVendas");
		return query.getResultList();
	}
	
	public List<Comentario> getComentarios(int id){
		Query q = manager.createQuery("select c from Produto p join p.comentarios where p.id = :i");
		q.setParameter("i", id);
		return q.getResultList();
	}*/
}
