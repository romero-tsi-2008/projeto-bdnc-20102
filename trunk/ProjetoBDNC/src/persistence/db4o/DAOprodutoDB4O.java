package persistence.db4o;

import java.util.List;

import model.Categoria;
import model.Marca;
import model.Produto;
import model.Produto;
import model.Categoria;
import DAOFactory.DAOFactory;
import DAOInterface.DAOmarcaIF;
import DAOInterface.DAOprodutoIF;
import DAOInterface.DAOcategoriaIF;

import com.db4o.*;
import com.db4o.query.*;


public class DAOprodutoDB4O extends DAOdefaultDB4O implements DAOprodutoIF {

	@Override
	public List<Produto> listarProdutos() {
		Query q = db.query();
		q.constrain(Produto.class);
		List<Produto> resultado = (List<Produto>) q.execute(); 
		return resultado;
	}

	public Produto findById(int id) {
		Query q = db.query();
		q.constrain(Produto.class);
		q.descend("id").constrain(id);
		Produto resultado = (Produto) q.execute().get(0); 
		return resultado;
	}

	public List<Produto> findByName(String nome) {
		Query q = db.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(nome);
		List<Produto> resultado = (List<Produto>) q.execute(); 
		return resultado;
	}

	public List<Produto> findByCategoria(int id) {
		DAOcategoriaIF DAOcategoria = DAOFactory.getInstance("db4o").createCategoriaDAO();
		DAOcategoria.begin();
		Categoria cat = (Categoria) DAOcategoria.findById(id);		 
		Query q = db.query();
		q.constrain(Produto.class);
		q.descend("categoria").constrain(cat);
		List<Produto> resultado = (List<Produto>) q.execute();
		
		return resultado;
	}

	@Override
	public List<Produto> findByMarca(int id) {
		DAOmarcaIF DAOmarca = DAOFactory.getInstance("db4o").createMarcaDAO();
		DAOmarca.begin();
		Marca m = (Marca) DAOmarca.findById(id);
		int marcaId = m.getId(); 
		Query q = db.query();
		q.constrain(Produto.class);
		q.descend("marcas").constrain(marcaId);
		List<Produto> resultado = (List<Produto>) q.execute(); 
		return resultado;
	}

}
