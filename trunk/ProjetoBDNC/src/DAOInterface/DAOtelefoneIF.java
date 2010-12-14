package DAOInterface;

import java.util.HashMap;
import java.util.List;
import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;


public interface DAOtelefoneIF extends DAOdefaultIF{
	
	public List<Telefone> listarTelefones();
	
	public Telefone findById(int id);
	
	public List<Telefone> groupByUsuario();
	
	public String totalTelefones();
	
	public List<Telefone> findByUsuario(int i);
	
	public HashMap<Usuario, List<Telefone>> groupByUsuario2();

}
