package persistence.db4o;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import model.Equipamento;
import model.Produto;
import model.Usuario;

import DAOInterface.DAOdefaultIF;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.query.*;

public class DAOdefaultDB4O<X> implements DAOdefaultIF<X> {
	
	public static ObjectContainer db;
	public Configuration conf = Db4o.newConfiguration();
	
	
	public void begin() {
		if (db == null) {
			db = Db4o.openFile(conf, "projetobdnc.db4o");
			conf.objectClass(Usuario.class).cascadeOnUpdate(true);
			conf.objectClass(Equipamento.class).cascadeOnUpdate(true);
			conf.objectClass(Produto.class).cascadeOnUpdate(true);
		}
	}

	public void close() {
		if (db != null) {
			db.close();
			db = null;
		}
	}

	public void commit() {
		db.commit();
	}

	public void rollback() {
		db.rollback();
	}

	public void persist(X obj) {
		db.store(obj);
	}

	public void remove(X obj) {
		db.delete(obj);
	}

	@Override
	public void merge(X obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<X> findAllByQueryLimited(String query, int max) {
		// TODO Auto-generated method stub
		return null;
	}

}
