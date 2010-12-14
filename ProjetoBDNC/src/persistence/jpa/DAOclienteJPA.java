package persistence.jpa;

import java.util.List;
import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOclienteJPA extends DAOdefaultJPA implements DAOclienteIF{
	
	public Cliente findCliente(int id){
		return (Cliente) findByQuery("select c from Cliente c where id = "+id);
	}
}
