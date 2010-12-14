package persistence.jpa;

import java.util.*;

import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOcategoriaJPA extends DAOdefaultJPA<Categoria> implements DAOcategoriaIF{	
	
	/*
	public List<Produto> listarProdutosPorCategoria(Categoria c){
		Query query = manager.createQuery("select p from Produto p where p.categoria = "+c).setMaxResults(10).setFirstResult(0);
		List<Produto> prods = query.getResultList();		
		return prods;
	}*/
	
	public List<Categoria> listarCategorias(){
		return (List<Categoria>) findAllByQueryLimited("select c from Categoria c", 100);
	}		
	
	public Categoria findById(int id){		
		return (Categoria) findByQuery("select c from Categoria c where c.id = "+id);		
	}
	
	public Categoria findByName(String nome){
		return (Categoria) findByQuery("select c from Categoria c where c.nome = '"+nome+"'");	
	}
}
