package persistence.jpa;

import java.util.List;

import javax.persistence.*;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOpedidoJPA extends DAOdefaultJPA implements DAOpedidoIF{
	
	public List<Pedido> listarPedidos(){		
		return (List<Pedido>) findAllByQueryLimited("select p from Pedido p", 20);
	}
	
	public Pedido findById(int id){
		return (Pedido) findByQuery("select u from Usuario u where u.nome where id = "+id);
	}
	/*
	public List<PedidoIF> listarPedidosPendentes(){		
		Query q = getManager().createQuery("select p from Pedido p where p.ativo = 1");
		List<PedidoIF> pedidos = q.getResultList();
		return pedidos;	
	}	
	
	public UsuarioIF clientePedido(PedidoIF pedido){
		Query q = getManager().createQuery("select u from Usuario u join Pedido p where p.id = :pedidoID");
		q.setParameter("pedidoID", pedido.getId());
		UsuarioIF cliente = (Cliente) q.getSingleResult();
		if(cliente != null)
			return cliente;
		else 
			return null;
	}	
	
	public long findNumPedidosDoCliente(UsuarioIF u) {		
		Query query = getManager().createQuery("select count(p) from Pedido p where p.cliente = :usuario");
		query.setParameter("usuario", u);		
		long numPedidos = (Long) query.getSingleResult(); 
		return numPedidos;
	}

	public void desativaByID(int id){
		Query q = getManager().createQuery("update Pedido p set p.ativo = 0, p.DataDaConclusao = current_timestamp where p.id = :id");		
		q.setParameter("id", id);
		q.executeUpdate();		
	}*/
}
