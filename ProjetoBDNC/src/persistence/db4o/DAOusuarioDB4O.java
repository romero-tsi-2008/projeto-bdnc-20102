package persistence.db4o;

import java.util.List;

import model.Usuario;
import model.Usuario;
import DAOInterface.DAOusuarioIF;
import com.db4o.*;
import com.db4o.query.*;

public class DAOusuarioDB4O extends DAOdefaultDB4O implements DAOusuarioIF{

	public List<Usuario> listarUsuarios() {
		Query q = db.query();
		q.constrain(Usuario.class);
		List<Usuario> resultado = (List<Usuario>) q.execute(); 
		return resultado;
	}

	public Usuario findById(int id) {
		Query q = db.query();
		q.constrain(Usuario.class);
		q.descend("id").constrain(id);
		Usuario resultado = (Usuario) q.execute().get(0); 
		return resultado;
	}

	public List<Usuario> findByName(String nome) {
		Query q = db.query();
		q.constrain(Usuario.class);
		q.descend("nome").constrain(nome);
		List<Usuario> resultado = (List<Usuario>) q.execute(); 
		return resultado;
	}

	public List<Usuario> findUsuarioByNomeCidade(String nomeCidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
