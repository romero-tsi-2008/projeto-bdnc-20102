package model;

import java.util.Calendar;
import java.util.List;

public interface PedidoIF {

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getCliente()
	 */
	public abstract ClienteIF getCliente();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setCliente(br.com.classes.Cliente)
	 */
	public abstract void setCliente(Cliente cliente);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getId()
	 */
	public abstract int getId();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getItens()
	 */
	public abstract List<Item> getItens();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setItens(java.util.List)
	 */
	public abstract void setItens(List<Item> itens);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#addItem(br.com.classes.Item)
	 */
	public abstract void addItem(Item it);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#removeItem(br.com.classes.Item)
	 */
	public abstract void removeItem(Item item);

	public abstract void removeItemPorIdProduto(int idProduto);

	public abstract void subtraiProduto(int idProduto);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getValortotal()
	 */
	public abstract double getValortotal();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setValortotal(double)
	 */
	public abstract void setValortotal(double valortotal);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#CalculoValortotal()
	 */
	public abstract void CalculoValortotal();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDoPedido()
	 */
	public abstract Calendar getDataDoPedido();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDoPedido2()
	 */
	public abstract String getDataDoPedido2();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDoPedido()
	 */
	public abstract void setDataDoPedido();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDaConclusao2()
	 */
	public abstract String getDataDaConclusao2();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDaConclusao()
	 */
	public abstract void setDataDaConclusao();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getQuantItens()
	 */
	public abstract int getQuantItens();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getAtivo()
	 */
	public abstract int getAtivo();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDaConclusao(java.util.Calendar)
	 */
	public abstract void setDataDaConclusao(Calendar dataDaConclusao);

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDaConclusao()
	 */
	public abstract Calendar getDataDaConclusao();

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDoPedido(java.util.Calendar)
	 */
	public abstract void setDataDoPedido(Calendar dataDoPedido);

	public abstract void removeItem(int codProd);

}