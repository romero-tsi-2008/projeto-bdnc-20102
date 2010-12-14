package model;

import javax.persistence.*;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50, nullable=false)
	private String rua;
	@Column(length=30, nullable=false)
	private String bairro;
	@Column(nullable=false)
	private int numero;
	@Column(length=40, nullable=true)
	private String complemento;
	@OneToOne (mappedBy="endereco")
	private Usuario usuario;
	
	public Endereco() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
