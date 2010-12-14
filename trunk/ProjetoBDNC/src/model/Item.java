package model;

	import javax.persistence.*;

	@Entity
	public class Item {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private int quantidade;
		@ManyToOne
		private Produto produto;
		private double precoParcial;
		
		public Item() {
			super();
		}		
		
		public int getId() {
			return id;
		}

		public int getQuantidade() {
			return quantidade;
		}
		
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		public ProdutoIF getProduto() {
			return produto;
		}
		
		public void setProduto(ProdutoIF prod1) {
			this.produto = (Produto) prod1;
		}
		
		public double getPrecoparcial() {
			return produto.getPreco()*quantidade;
		}
		
		public void setPrecoParcial() {
			this.setPrecoParcial(this.getQuantidade()*(this.getProduto().getPreco()));
		}
		
	    public boolean equals(Object o) {
	        Item item = (Item) o;
	        if (item.getProduto().equals(this.produto))
	            return true;
	        return false;
	    }

		public void setPrecoParcial(double precoParcial) {
			this.precoParcial = precoParcial;
		}

		public double getPrecoParcial() {
			return precoParcial;
		}
}

	

