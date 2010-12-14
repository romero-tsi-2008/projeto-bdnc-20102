package persistence.jpa;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOadministradorJPA extends DAOdefaultJPA implements DAOadministradorIF{
	
	public Administrador findByID(int id){		
		return (Administrador) findByQuery("select a from Administrador a where a.id ="+id);	
	}
	
	public List<Administrador> findByName(String nome){
		return (List<Administrador>) findAllByQueryLimited("select a from Administrador a where a.nome like "+nome, 50);
	}
	
	public List<Administrador> listarAdministradores(){		
		return (List<Administrador>) findAllByQueryLimited("select a from Administrador a", 50);
	}
}
