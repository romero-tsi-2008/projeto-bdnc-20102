package persistence.db4o;

import java.util.List;

import model.Marca;

import DAOInterface.DAOdefaultIF;
import DAOInterface.DAOmarcaIF;

import com.db4o.query.Query;

public class DAOmarcaDB4O extends DAOdefaultDB4O implements DAOmarcaIF{
	
	public List<Marca> listarMarcas() {
		Query q = db.query();
		q.constrain(Marca.class);
		List<Marca> resultado = (List<Marca>) q.execute(); 
		return resultado;
	}

	public Marca findById(int id) {
		Query q = db.query();
		q.constrain(Marca.class);
		q.descend("id").constrain(id);
		Marca resultado = (Marca) q.execute().get(0); 
		return resultado;
	}

	public Marca findByName(String nome) {
		Query q = db.query();
		q.constrain(Marca.class);
		q.descend("nome").constrain(nome);
		Marca resultado = (Marca) q.execute().get(0); 
		return resultado;
	}
	
}
