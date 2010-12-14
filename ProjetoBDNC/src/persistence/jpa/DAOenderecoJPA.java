package persistence.jpa;

import java.util.List;

import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOenderecoJPA extends DAOdefaultJPA implements DAOenderecoIF{
	
	public Endereco findById(int id){
		return (Endereco) findByQuery("select e from Endereco e where e.id = "+id);
	}
	
	public List<Endereco> listarEnderecos(){
		return (List<Endereco>) findAllByQueryLimited("select e from Endereco e", 500);
	}
}
