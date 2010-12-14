package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOenderecoIF extends DAOdefaultIF{
	
	public Endereco findById(int id);
	
	public List<Endereco> listarEnderecos();

}
