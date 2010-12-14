package persistence.jpa;

import java.util.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOequipamentoJPA extends DAOdefaultJPA implements DAOequipamentoIF{
	
	public Equipamento findById(int id){
		return (Equipamento) findByQuery("select e from Equipamento e where e.id = "+id);
	}
	
	public List<Equipamento> listarEquipamentos(){
		return (List<Equipamento>) findAllByQueryLimited("select e from Equipamento e", 10);
	}
}
