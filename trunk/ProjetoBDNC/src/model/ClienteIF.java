package model;

import java.util.*;

public interface ClienteIF {

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#getNumeroDePedidos()
	 */
	public abstract long getNumeroDePedidos();

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#setNumeroDePedidos(int)
	 */
	public abstract void setNumeroDePedidos(long numeroDePedidos);

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#setNumeroDePedidos()
	 */
	public abstract void incrementaNumeroDePedidos();

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#getPedidos()
	 */
	public abstract List<Pedido> getPedidos();

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#setPedidos(java.util.ArrayList)
	 */
	public abstract void setPedidos(List<Pedido> pedidos);

	/* (non-Javadoc)
	 * @see br.com.classes.ClienteIF#addPedidos(br.com.classes.Pedido)
	 */
	public abstract void addPedidos(Pedido p);

}