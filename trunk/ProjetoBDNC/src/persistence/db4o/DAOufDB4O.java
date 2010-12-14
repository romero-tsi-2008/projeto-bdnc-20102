package persistence.db4o;

import java.util.List;

import model.UF;
import DAOInterface.DAOufIF;

import com.db4o.query.*;

public class DAOufDB4O extends DAOdefaultDB4O implements DAOufIF{

	@Override
	public UF findById(int id) {
		Query q = db.query();
		q.constrain(UF.class);
		q.descend("id").constrain(id);
		UF resultado = (UF) q.execute().get(0); 
		return resultado;
	}
	
	@Override
	public UF findByName(String nome) {
		Query q = db.query();
		q.constrain(UF.class);
		q.descend("nome").constrain(nome);
		UF resultado = (UF) q.execute().get(0); 
		return resultado;
	}

}
