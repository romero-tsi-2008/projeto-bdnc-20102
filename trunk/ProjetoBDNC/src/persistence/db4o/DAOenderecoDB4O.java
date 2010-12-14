package persistence.db4o;

import java.util.List;

import model.Endereco;
import model.Endereco;
import DAOInterface.DAOenderecoIF;
import com.db4o.*;
import com.db4o.query.*;

public class DAOenderecoDB4O extends DAOdefaultDB4O implements DAOenderecoIF{

	public Endereco findById(int id) {
		Query q = db.query();
		q.constrain(Endereco.class);
		q.descend("id").constrain(id);
		Endereco resultado = (Endereco) q.execute().get(0); 
		return resultado;		
	}
	
	public List<Endereco> listarEnderecos() {
		Query q = db.query();
		q.constrain(Endereco.class);
		List<Endereco> resultado = (List<Endereco>) q.execute(); 
		return resultado;
	}

}
