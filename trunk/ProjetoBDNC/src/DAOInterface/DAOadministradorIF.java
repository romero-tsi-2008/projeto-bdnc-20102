package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOadministradorIF extends DAOdefaultIF{
	
	public List<Administrador> listarAdministradores();
	
	public Administrador findByID(int id);
	
	public List<Administrador> findByName(String nome);

}
