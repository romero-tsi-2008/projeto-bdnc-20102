package persistence.db4o;
import java.util.List;

import model.Equipamento;
import DAOInterface.DAOequipamentoIF;

import com.db4o.*;
import com.db4o.query.*;

public class DAOequipamentoDB4O extends DAOdefaultDB4O implements DAOequipamentoIF{

	public List<Equipamento> listarEquipamentos() {
		Query q = db.query();
		q.constrain(Equipamento.class);
		List<Equipamento> resultado = (List<Equipamento>) q.execute(); 
		return resultado;
	}

	public Equipamento findById(int id) {
		Query q = db.query();
		q.constrain(Equipamento.class);
		q.descend("id").constrain(id);
		Equipamento resultado = (Equipamento) q.execute().get(0); 
		return resultado;
	}

}
