package model;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;


@Entity
public class Pedido implements PedidoIF{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> itens;
	
	private double valortotal;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar DataDoPedido;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar DataDaConclusao;
	
	@Column(nullable = false, columnDefinition = "int default 1")
	private int ativo = 1;
	
	public Pedido() {		
		this.itens = new ArrayList<Item>();
	}
		
		
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getCliente()
	 */
	
	@Override
	public ClienteIF getCliente() {
		return cliente;
	}
	

	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setCliente(br.com.classes.Cliente)
	 */
	
	@Override
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
		
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getId()
	 */

	@Override
	public int getId() {
		return id;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getItens()
	 */
	
	@Override
	public List<Item> getItens() {
		return itens;
	}
	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setItens(java.util.List)
	 */
	
	@Override
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#addItem(br.com.classes.Item)
	 */
	
	@Override
	public void addItem(Item it) {
		Iterator ite = this.itens.iterator();
		Item item = new Item();
		while(ite.hasNext()){
			item = (Item) ite.next();
			if(item.getProduto().getId() == it.getProduto().getId()){
				item.setQuantidade(item.getQuantidade() + 1);
				item.setPrecoParcial();
				this.CalculoValortotal();
				return;
			
			}
			
		}
		it.setPrecoParcial();
		this.itens.add(it);
		this.CalculoValortotal();
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#removeItem(br.com.classes.Item)
	 */
	
	@Override
	public void removeItem(Item item) {		
		this.itens.remove(item);
		//setValortotal(getValortotal() - item.getPrecoparcial());
		this.CalculoValortotal();
	}	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#removeItemPorIdProduto(int)
	 */
	@Override
	public void removeItemPorIdProduto(int idProduto){
		Iterator it = this.itens.iterator();
			Item item;
			while(it.hasNext()){
				item = (Item) it.next();
				if(item.getProduto().getId() == idProduto){
					itens.remove(item);
					this.CalculoValortotal();
					break;
				}
			}
		
	}
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#subtraiProduto(int)
	 */
	@Override
	public void subtraiProduto(int idProduto){
		Iterator it = this.itens.iterator();
		Item item;
		while(it.hasNext()){
			item = (Item) it.next();
			if(item.getProduto().getId() == idProduto){
				if(item.getQuantidade() == 0)
					return;
				
				item.setQuantidade(item.getQuantidade()-1);
				if(item.getQuantidade() == 0){
					this.removeItemPorIdProduto(idProduto);
					return;
				}
				item.setPrecoParcial();
				this.CalculoValortotal();
				break;
			}
		}
	}
	
	public boolean subtrairEstoque(){
		Iterator it = this.itens.iterator();
			Item item;
			while(it.hasNext()){
				item = (Item) it.next();
				if (!item.getProduto().subEstoque(item.getQuantidade())){
					return false;
				}
			}
			return true;
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getValortotal()
	 */
	
	@Override
	public double getValortotal() {
		return valortotal;
	}
		
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setValortotal(double)
	 */
	
	@Override
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#CalculoValortotal()
	 */
	
	@Override
	public void CalculoValortotal(){
		double preco = 0;
		Iterator<Item> it = itens.iterator();
		
		while(it.hasNext()){
			Item item = (Item) it.next();
			preco += item.getPrecoparcial();			
		}
		this.setValortotal(preco);	
	}

	
		/* (non-Javadoc)
		 * @see br.com.classes.PedidoIF#getDataDoPedido()
		 */
		
		@Override
		public Calendar getDataDoPedido() {
			return DataDoPedido;
		}
	
	
		/* (non-Javadoc)
		 * @see br.com.classes.PedidoIF#getDataDoPedido2()
		 */
		
		@Override
		public String getDataDoPedido2() {
			
			String date = null;
			try{
			SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy 'as' HH:mm:ss'hs'");
			date = formatador.format(this.DataDoPedido.getTime());
			
			}catch(Exception e){
				System.out.println("Formato de data inválido!");
				return null;
			}
			return date;
		}

	
		/* (non-Javadoc)
		 * @see br.com.classes.PedidoIF#setDataDoPedido()
		 */
		
		@Override
		public void setDataDoPedido() {
		DataDoPedido = new GregorianCalendar();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDaConclusao2()
	 */
	
	@Override
	public String getDataDaConclusao2() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy 'às' HH:mm:ss'hs'");
		String date = formatador.format(this.DataDaConclusao.getTime());
		return date;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDaConclusao()
	 */
	
	@Override
	public void setDataDaConclusao() {
		DataDaConclusao = new GregorianCalendar();
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getQuantItens()
	 */
	
	@Override
	public int getQuantItens() {
		return itens.size();
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getAtivo()
	 */
	
	@Override
	public int getAtivo() {
		return ativo;
	}

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDaConclusao(java.util.Calendar)
	 */
	
	@Override
	public void setDataDaConclusao(Calendar dataDaConclusao) {
		DataDaConclusao = dataDaConclusao;
	}

	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#getDataDaConclusao()
	 */
	
	@Override
	public Calendar getDataDaConclusao() {
		return DataDaConclusao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.PedidoIF#setDataDoPedido(java.util.Calendar)
	 */
	
	@Override
	public void setDataDoPedido(Calendar dataDoPedido) {
		DataDoPedido = new GregorianCalendar();
	}	

	
	@Override
	public void removeItem(int codProd) {
		// TODO Auto-generated method stub
		
	}

}
