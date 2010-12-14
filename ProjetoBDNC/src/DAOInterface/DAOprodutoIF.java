package DAOInterface;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOprodutoIF extends DAOdefaultIF{
	
	public List<Produto> listarProdutos();
	
	public Produto findById(int id);
	
	public List<Produto> findByName(String nome);
	
	public List<Produto> findByCategoria(int id);
	
	public List<Produto> findByMarca(int id);
}
