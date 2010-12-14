package model;


import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("PN")
public class Produto implements ProdutoIF {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String nomeproduto;
	private double preco;
	private int estoque;
	private String descricao;
	@OneToMany(mappedBy="produto",cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	@ManyToMany (mappedBy="produtos")
	private List<Equipamento> equipamentos;
	private Categoria categoria;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDaInclusao;
	private int numeroDeVendas;
	@ManyToOne
	private Marca marca;
 

	
	public Produto() {
		
	}

	public Produto(int idproduto, String nomeproduto) {
		super();
		this.id = idproduto;
		this.nomeproduto = nomeproduto;
	}

	/* (non-Javadoc)
	 * @see br.com.classes.ProdutoIF#setIdproduto(int)
	 */
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setIdproduto(int)
	 */
	public void setIdproduto(int idproduto) {
		this.id = idproduto;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getNomeproduto()
	 */
	public String getNomeproduto() {
		return nomeproduto;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setNomeproduto(java.lang.String)
	 */
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}
  
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getPreco()
	 */
	public double getPreco() {
		return preco;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setPreco(double)
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getEstoque()
	 */
	public int getEstoque() {
		return estoque;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setEstoque(int)
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#subEstoque(int)
	 */
	public boolean subEstoque(int quant){
		if(this.estoque - quant < 0){
			return false;
		}
		this.estoque -= quant;
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getDescricao()
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setDescricao(java.lang.String)
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getCategoria()
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setCategoria(model.Categoria)
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getId()
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getDataDaInclusao()
	 */
	public String getDataDaInclusao() {
		String date = null;
		try{
		SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy 'as' HH:mm:ss'hs'");
		date = formatador.format(this.dataDaInclusao.getTime());
		
		}catch(Exception e){
			System.out.println("Formato de data inválido!");
			return null;
		}
		return date;
	}
	
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#setDataDaInclusao(java.util.Calendar)
	 */
	public void setDataDaInclusao(Calendar dataDaInclusao) {
		this.dataDaInclusao = new GregorianCalendar();
	}
	
	

	/* (non-Javadoc)
	 * @see model.ProdutoIF#setNumeroDeVendas(int)
	 */
	public void setNumeroDeVendas(int numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}

	/* (non-Javadoc)
	 * @see model.ProdutoIF#getNumeroDeVendas()
	 */
	public int getNumeroDeVendas() {
		return numeroDeVendas;
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#addNumeroDeVendas()
	 */
	public void addNumeroDeVendas() {
		this.numeroDeVendas += 1;
	}

	/* (non-Javadoc)
	 * @see model.ProdutoIF#setProduto(model.ProdutoIF)
	 */


	/* (non-Javadoc)
	 * @see model.ProdutoIF#setComentarios(java.util.List)
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	/* (non-Javadoc)
	 * @see model.ProdutoIF#addComentario(model.Comentario)
	 */
	public void addComentario(Comentario c){
		this.comentarios.add(c);
	}
	
	/* (non-Javadoc)
	 * @see model.ProdutoIF#getComentarios()
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setId(int id) {
		this.id = id;
	}



}
