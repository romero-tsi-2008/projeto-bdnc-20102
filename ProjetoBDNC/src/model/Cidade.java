package model;

import javax.persistence.*;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nome;
	@ManyToOne
	private UF uf;
	
	public Cidade(){
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public UF getUf() {
		return uf;
	}

}
