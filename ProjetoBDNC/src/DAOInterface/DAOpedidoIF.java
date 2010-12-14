package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOpedidoIF extends DAOdefaultIF{
	
	public List<Pedido> listarPedidos();
	
	public Pedido findById(int id);

}
