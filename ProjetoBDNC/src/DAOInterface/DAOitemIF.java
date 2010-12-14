package DAOInterface;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOitemIF extends DAOdefaultIF{
	public Item findById(int id);
}
