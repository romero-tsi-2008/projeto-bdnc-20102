package persistence.db4o;

import java.util.List;

import model.Cidade;
import model.UF;
import DAOFactory.*;
import DAOInterface.DAOcidadeIF;
import DAOInterface.DAOufIF;

import com.db4o.*;
import com.db4o.query.*;

public class DAOcidadeDB4O extends DAOdefaultDB4O<Cidade> implements DAOcidadeIF {

	public List<Cidade> listarCidades() {
		Query q = db.query();
		q.constrain(Cidade.class);
		List<Cidade> resultado = (List<Cidade>) q.execute(); 
		return resultado;
	}

	@Override
	public Cidade findById(int id) {
		Query q = db.query();
		q.constrain(Cidade.class);
		q.descend("id").constrain(id);
		Cidade resultado = (Cidade) q.execute().get(0); 
		return resultado;		
	}

	public Cidade findByName(String nome) {
		Query q = db.query();
		q.constrain(Cidade.class);
		q.descend("nome").constrain(nome);
		Cidade resultado = (Cidade) q.execute().get(0); 
		return resultado;		
	}

	public List<Cidade> cidadesQueSaoDaUF1() {
		DAOufIF DAOuf = DAOFactory.getInstance("db4o").createUfDAO();
		DAOuf.begin();
		UF uf = (UF) DAOuf.findById(1);		
		Query q = db.query();
		q.descend("uf").constrain(uf);
		List<Cidade> c = q.execute();
		return c;
	}

}
