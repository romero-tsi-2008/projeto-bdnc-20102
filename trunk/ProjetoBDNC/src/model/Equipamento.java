package model;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("EQ")
public class Equipamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String nome;
	private double preco;
	private String descricao;	
	@ManyToMany(cascade={CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH})
	private List<Produto> produtos;
	private Categoria categoria;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDaInclusao;
	private int numeroDeVendas;
	@ManyToOne
	private Marca marca;
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Calendar getDataDaInclusao() {
		return dataDaInclusao;
	}
	public void setDataDaInclusao(Calendar dataDaInclusao) {
		this.dataDaInclusao = dataDaInclusao;
	}
	public int getNumeroDeVendas() {
		return numeroDeVendas;
	}
	public void setNumeroDeVendas(int numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public void addProduto(Produto p){
		produtos.add(p);
	}
	public boolean removeProduto(ProdutoIF p){
		return produtos.remove(p);
	}

	public int quantDeProdutos(){
		return produtos.size();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void attPreco() {
		Iterator it = produtos.iterator();
		double preco = 0;
		while (it.hasNext()) {
			Produto p = (Produto) it.next();			
			preco += p.getPreco();
		}
		this.setPreco(preco);
	}
}
