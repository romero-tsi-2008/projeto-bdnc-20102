package persistence.jpa;

import java.util.List;

import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOcidadeJPA extends DAOdefaultJPA<Cidade> implements DAOcidadeIF{
	
	public List<Cidade> listarCidades(){
		return (List<Cidade>) findAllByQueryLimited("select c from cidade c", 20);
	}
		
	public Cidade findById(int id){
		return (Cidade) findByQuery("select c from Cidade c where c.id = "+id);
	}
	
	public Cidade findByName(String nome){
		return (Cidade) findByQuery("select u from Cidade where u.nome = "+nome);				
	}
	
	public List<Cidade> cidadesQueSaoDaUF1() {
		Query q = manager.createQuery("select c from Cidade c where c.id in (select c2.id from Cidade c2 join c2.uf estado where estado.id = 1)");
		return (List<Cidade>) q.getResultList();
	}
}
