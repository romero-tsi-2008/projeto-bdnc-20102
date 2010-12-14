package persistence.jpa;

import java.util.List;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOufJPA extends DAOdefaultJPA implements DAOufIF{
	/*
	public List<UF> listarEstados(){
		Query query = manager.createQuery("select u from UF u");
		List<UF> estados = query.getResultList();		
		return estados;
	}*/
		
	public UF findById(int id){
		return (UF) findByQuery("select u from UF u where u.id = "+id);
	}
	
	public UF findByName(String nome){
		return (UF) findByQuery("select u from UF where u.nome ="+nome);
	}	
}
