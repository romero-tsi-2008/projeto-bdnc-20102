package DAOInterface;

import java.util.List;

import model.Marca;

public interface DAOmarcaIF extends DAOdefaultIF{
	
	public List<Marca> listarMarcas();
	
	public Marca findById(int id);
	
	public Marca findByName(String nome);	
	
}
