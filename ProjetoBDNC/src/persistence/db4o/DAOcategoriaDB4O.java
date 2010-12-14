package persistence.db4o;

import java.util.List;

import model.Categoria;
import model.Cliente;
import DAOInterface.DAOcategoriaIF;

import com.db4o.*;
import com.db4o.query.*;

public class DAOcategoriaDB4O extends DAOdefaultDB4O<Categoria> implements DAOcategoriaIF {

	public List<Categoria> listarCategorias() {
		Query q = db.query();
		q.constrain(Categoria.class);
		List<Categoria> resultado = (List<Categoria>) q.execute();
		return resultado;
	}

	public Categoria findById(int id) {
		Query q = db.query();
		q.constrain(Categoria.class);
		q.descend("id").constrain(id);
		Categoria resultado = (Categoria) q.execute().get(0); 
		return resultado;	
	}

	public Categoria findByName(String nome) {
		Query q = db.query();
		q.constrain(Categoria.class);
		q.descend("nome").constrain(nome);
		Categoria resultado = (Categoria) q.execute().get(0); 
		return resultado;	
	}

}
