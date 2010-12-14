package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class UF {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false, length=2)
	private int ddd;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="uf")
	private List<Cidade> cidade;
	
	public UF(){
		
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

	public List<Cidade> getCidade() {
		return cidade;
	}

	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getDdd() {
		return ddd;
	}
	
	
}
