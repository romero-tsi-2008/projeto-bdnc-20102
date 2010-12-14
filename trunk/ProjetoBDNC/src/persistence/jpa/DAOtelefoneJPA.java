package persistence.jpa;


import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOtelefoneJPA extends DAOdefaultJPA implements DAOtelefoneIF{	
			
		public Telefone findById(int id){
			return (Telefone) findByQuery("select t from Telefone t where id = "+id);
		}
		
		public List<Telefone> listarTelefones(){
			return (List<Telefone>) findAllByQueryLimited("select t from Telefone t", 3000);
		}
		
		public List<Telefone> groupByUsuario() {
			return (List<Telefone>) findAllByQueryLimited("select t from Telefone t group by t.usuario, t order by t.usuario.nome", 300);
		}		
		
		public String totalTelefones() {
			Query q = getManager().createQuery("select count(t) from Telefone t");
			return q.getSingleResult().toString();
		}
		
		public List<Telefone> findByUsuario(int id) {
			Query q = getManager().createQuery("select distinct u.telefones from Usuario u join u.telefones t where u.id = "+id);
			return (List<Telefone>)q.getResultList();
		}

		@Override
		public HashMap<Usuario, List<Telefone>> groupByUsuario2() {
			// TODO Auto-generated method stub
			return null;
		}
}
