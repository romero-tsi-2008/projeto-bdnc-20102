package persistence.db4o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Telefone;
import model.Usuario;
import DAOInterface.DAOtelefoneIF;
import com.db4o.*;
import com.db4o.query.*;

public class DAOtelefoneDB4O extends DAOdefaultDB4O implements DAOtelefoneIF {

	public List<Telefone> listarTelefones() {
		Query q = db.query();
		q.constrain(Telefone.class);
		List<Telefone> resultado = (List<Telefone>) q.execute(); 
		return resultado;
	}

	public Telefone findById(int id) {
		Query q = db.query();
		q.constrain(Telefone.class);
		q.descend("id").constrain(id);
		Telefone resultado = (Telefone) q.execute().get(0); 
		return resultado;
	}

	public HashMap<Usuario, List<Telefone>> groupByUsuario2() {
		Query q = db.query();
		q.constrain(Usuario.class);
		List<Usuario> usuarios = (List<Usuario>) q.execute();
		HashMap<Usuario, List<Telefone>> resultado = new HashMap<Usuario, List<Telefone>>();
		Iterator it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario u = (Usuario) it.next();
			List<Telefone> tels_u = u.getTelefones();
			resultado.put(u, tels_u);
		}		
		return resultado;
	}

	public String totalTelefones() {
		Query q = db.query();
		q.constrain(Telefone.class);
		List<Telefone> resultado = (List<Telefone>) q.execute();
		int quantidade = resultado.size();
		return String.valueOf(quantidade);
	}

	public List<Telefone> findByUsuario(int id) {
		Query q = db.query();
		q.constrain(Usuario.class);
		q.descend("id").constrain(id);
		Usuario user = (Usuario) q.execute().get(0);		
		List<Telefone> tels = (List<Telefone>) user.getTelefones();
		return tels;
	}

	@Override
	public List<Telefone> groupByUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
