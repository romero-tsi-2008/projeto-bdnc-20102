package DAOInterface;

import java.util.List;

import javax.persistence.Query;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;


public interface DAOcidadeIF extends DAOdefaultIF<Cidade>{
	
	public List<Cidade> listarCidades();
		
	public Cidade findById(int id);
	
	public Cidade findByName(String nome);
	
	public List<Cidade> cidadesQueSaoDaUF1();
}
