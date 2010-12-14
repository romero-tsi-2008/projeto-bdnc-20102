package persistence.db4o;
import java.util.List;

import model.Pedido;
import DAOInterface.DAOpedidoIF;

import com.db4o.*;
import com.db4o.query.*;

public class DAOpedidoDB4O extends DAOdefaultDB4O implements DAOpedidoIF{

	@Override
	public List<Pedido> listarPedidos() {
		Query q = db.query();
		q.constrain(Pedido.class);
		List<Pedido> resultado = (List<Pedido>) q.execute(); 
		return resultado;
	}

	@Override
	public Pedido findById(int id) {
		Query q = db.query();
		q.constrain(Pedido.class);
		q.descend("id").constrain(id);
		Pedido resultado = (Pedido) q.execute().get(0); 
		return resultado;
	}
	

}
