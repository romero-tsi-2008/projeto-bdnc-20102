package model;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false)
	private int id;
	@Column(nullable=false)
	private String comentario;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Produto produto;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataPostagem;
	public Comentario() {
		super();
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setDataPostagem(Calendar dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	
	public void setDataPostagem(){
		this.dataPostagem = new GregorianCalendar();
	}

	
	public String getDataPostagem(){
		String date = null;
		try{
		SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy 'as' HH:mm:ss'hs'");
		date = formatador.format(this.dataPostagem.getTime());
		
		}catch(Exception e){
			System.out.println("Formato de data inválido!");
			return null;
		}
		return date;
	}

}
