package model;

import java.util.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CL")
public class Cliente extends Usuario implements ClienteIF{
	
	private long numeroDePedidos;
	
	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL)
	private List<Pedido> pedidos;	
	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	
	public Cliente() {}
	
	
		
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#getNumeroDePedidos()
	 */
	public long getNumeroDePedidos() {
		return numeroDePedidos;
	}
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#setNumeroDePedidos(int)
	 */
	public void setNumeroDePedidos(long numeroDePedidos) {
		this.numeroDePedidos = numeroDePedidos;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#incrementaNumeroDePedidos()
	 */	
	public void incrementaNumeroDePedidos() {
		this.setNumeroDePedidos(getNumeroDePedidos()+1);
	}
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#getPedidos()
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#setPedidos(java.util.ArrayList)
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#addPedidos(br.com.classes.PedidoIF)
	 */
	public void addPedidos(Pedido p){
		this.pedidos.add(p);
	}
	
	public void removePedidos(PedidoIF p){
		this.pedidos.remove(p);
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void addComentario(Comentario c){
		this.comentarios.add(c);
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	
	
		
	
}
