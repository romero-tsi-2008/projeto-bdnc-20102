package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOusuarioIF extends DAOdefaultIF{
	
	public List<Usuario> listarUsuarios();
	
	public Usuario findById(int id);
	
	public List<Usuario> findByName(String nome);
	
	public List<Usuario> findUsuarioByNomeCidade(String nomeCidade);
	
//	public List<Usuario> subconsulta(String nome);
}
