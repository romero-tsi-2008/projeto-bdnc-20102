package persistence.jpa;

import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOitemJPA extends DAOdefaultJPA implements DAOitemIF{
	
	public Item findById(int id) {
		return (Item) findByQuery("select i from Item i where i.id = "+id);
	}
}
