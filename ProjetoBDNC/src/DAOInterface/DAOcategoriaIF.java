package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOcategoriaIF extends DAOdefaultIF<Categoria>{
	
	public List<Categoria> listarCategorias();
		
	public Categoria findById(int id);
	
	public Categoria findByName(String nome);
}
