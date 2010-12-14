package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable=false)
	private int id;
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;
	@Column(length=50, unique=true)
	private String nome;
		
	

	public Categoria() {
		super();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProdutos(Produto p){
		this.produtos.add(p);
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
}
