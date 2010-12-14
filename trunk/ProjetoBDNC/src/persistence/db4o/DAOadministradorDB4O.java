package persistence.db4o;

import java.util.List;

import model.Administrador;
import DAOInterface.DAOadministradorIF;

import com.db4o.*;
import com.db4o.query.*;

public class DAOadministradorDB4O extends DAOdefaultDB4O implements DAOadministradorIF{

	@Override
	public List<Administrador> listarAdministradores() {
		Query q = db.query();
		q.constrain(Administrador.class);
		List<Administrador> resultado = (List<Administrador>) q.execute(); 
		return resultado;
	}

	@Override
	public Administrador findByID(int id) {
		Query q = db.query();
		q.constrain(Administrador.class);
		q.descend("id").constrain(id);
		Administrador resultado = (Administrador) q.execute(); 
		return resultado;
	}

	@Override
	public List<Administrador> findByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
