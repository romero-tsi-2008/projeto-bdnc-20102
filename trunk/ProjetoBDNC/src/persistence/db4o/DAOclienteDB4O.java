package persistence.db4o;

import model.Cliente;
import DAOInterface.DAOclienteIF;
import com.db4o.*;
import com.db4o.query.*;

public class DAOclienteDB4O extends DAOdefaultDB4O implements DAOclienteIF {

	public Cliente findCliente(int id) {
		Query q = db.query();
		q.constrain(Cliente.class);
		q.descend("id").constrain(id);
		Cliente resultado = (Cliente) q.execute().get(0);
		return resultado;
	}

}
