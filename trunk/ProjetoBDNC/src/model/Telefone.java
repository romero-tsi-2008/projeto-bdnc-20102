package model;

import javax.persistence.*;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Usuario usuario;
	@Column(length=13)
	private String numero;
	
	
	public Telefone() {
	}


	public Telefone(UsuarioIF usuario, String numero) {
		super();
		this.usuario = (Usuario) usuario;
		this.numero = numero;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}


	public UsuarioIF getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioIF usuario) {
		this.usuario = (Usuario) usuario;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return getNumero().toString();
	}
}
