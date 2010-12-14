package persistence.jpa;

import java.util.List;
import javax.persistence.*;


import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOusuarioJPA extends DAOdefaultJPA implements DAOusuarioIF {
	
	public Usuario findById(int id){		
		return (Usuario) findByQuery("select u from Usuario u where u.id ="+id);	
	}
	
	public List<Usuario> listarUsuarios(){		
		return (List<Usuario>) findAllByQueryLimited("select u from Usuario u", 3000);
	}
	
	public List<Usuario> findByName(String nome){
		return (List<Usuario>) findAllByQueryLimited("select u from Usuario u where u.nome like "+nome, 3000);		
	}

	@Override
	public List<Usuario> findUsuarioByNomeCidade(String nomeCidade) {
		// TODO Auto-generated method stub
		return (List<Usuario>) findAllByQueryLimited("select u from Usuario join cidade Cidade c.usuarios where c.nome like "+nomeCidade, 3000);
	}
	
//	public List<Usuario> subconsulta(String nome) {
//		Query q = manager.createQuery("select u from Usuario u where count(u.telefones) < (select count(u2) from Usuario u2 join u2.telefones t where u2.nome like %"+nome+"%");
//		return (List<Usuario>) q.getResultList();		
//	}
	
	/*
	public UsuarioIF findByIDSingle(int id){		
		Query q = getManager().createQuery("select u from Usuario u where u.id = :id");
		q.setParameter("id", id);
		UsuarioIF usuario = (UsuarioIF) q.getSingleResult();
		return usuario;	
	}
	
	public List<UsuarioIF> listarUsuariosPorNome(String nome){		
		Query q = getManager().createQuery("select u from Usuario u where u.nome like '%"+nome+"%'");
		//q.setParameter("nome",  "'%"+nome+"%'");
		List<UsuarioIF> usuarios = q.getResultList();
		return usuarios;	
	}
	
	public List<UsuarioIF> listarUsuariosPorApelido(String apelido){		
		Query q = getManager().createQuery("select u from Usuario u where u.apelido like '%"+apelido+"%'");
		//q.setParameter("apelido", apelido);
		List<UsuarioIF> usuarios = q.getResultList();
		return usuarios;	
	}
	
	public List<Usuario> listarUltimosUsuarios(){		
		Query q = getManager().createQuery("select u from Usuario u order by u.id desc");
		List<Usuario> usuarios = q.getResultList();
		return usuarios;	
	}	
	

	
	public Usuario findByLogin(String email, String senha){
		Query q = getManager().createQuery("select u from Usuario u where u.email = :e and u.senha = :s");
		q.setParameter("e", email);
		q.setParameter("s", senha);
		
		Usuario usuario = (Usuario) q.getSingleResult();
		if (usuario != null)
			return usuario;
		else 
			return null;
	}
	
	public Cliente findCliente(int id){
		return getManager().find(Cliente.class, id);
	}
	
	public Administrador findAdministrador(int id){
		
			return getManager().find(Administrador.class, id);
	}
	
	public Usuario buscaAdmin(String email, String senha){
		
		Query q = getManager().createQuery("select a from Administrador a where a.email like :email and a.senha like :senha");
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		Usuario admin;
		try{
			admin = (Usuario) q.getSingleResult();
		}
		catch(Exception e){
			return null;
		}
		return admin;
	
	}
	
	public Usuario buscaCliente(String email, String senha){
		if(!getManager().isOpen()){
			this.begin();
		}
		Query q = getManager().createQuery("select c from Cliente c where c.email = '"+email+"' and c.senha='"+senha+"'" );
		Usuario cliente;
		try{
		cliente = (Usuario) q.getSingleResult();
		}catch(Exception e){
			return null;
		}
		return cliente;
	} */
}
