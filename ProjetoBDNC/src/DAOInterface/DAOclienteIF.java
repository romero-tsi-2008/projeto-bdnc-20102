package DAOInterface;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;


public interface DAOclienteIF extends DAOdefaultIF{

	public Cliente findCliente(int id);
	
}
