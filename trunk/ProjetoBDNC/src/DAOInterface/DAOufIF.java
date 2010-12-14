package DAOInterface;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOufIF extends DAOdefaultIF{
	
	public UF findById(int id);
	
	public UF findByName(String nome);
}
