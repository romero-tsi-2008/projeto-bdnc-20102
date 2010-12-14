package model;

import javax.persistence.*;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@Entity
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usuario implements UsuarioIF {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true, length=50)
	private String email;
	@Column(nullable=false, length=20)
	private String apelido;
	@Column(length=10, nullable=false)
	private String senha;
	@Column(length=50, nullable=false)
	private String nome;
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	@Column(length=11, nullable=false)
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@OneToOne
	private Cidade cidade;
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Telefone> telefones;
	
		
	
	public Usuario() {
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getId()
	 */
	@Override
	public int getId(){
		return this.id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getTelefones()
	 */
	@Override
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setTelefones(java.util.List)
	 */
	@Override
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#addTelefones(br.com.classes.Telefone)
	 */
	@Override
	public void addTelefones(Telefone telefone){
		if (this.telefones == null){
			this.telefones = new ArrayList<Telefone>();
		}
		this.telefones.add(telefone);
	}

	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setSenha(java.lang.String)
	 */
	@Override
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getSenha()
	 */
	@Override
	public String getSenha() {
		return senha;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setCpf(java.lang.String)
	 */
	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getCpf()
	 */
	@Override
	public String getCpf() {
		return cpf;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setCidade(br.com.classes.Cidade)
	 */
	@Override
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getCidade()
	 */
	@Override
	public Cidade getCidade() {
		return cidade;
	}




	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setDataNascimento(int, int, int)
	 */
	@Override
	public boolean setDataNascimento(int ano, int mes, int dia) {
			
		try{
			this.dataNascimento = new GregorianCalendar(ano, mes - 1, dia);
		}catch(Exception e){
			return false;
		}
	
			return true;
	}

	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getDataNascimento()
	 */
	@Override
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimento2(){
		
		String date = null;
		try{
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		date = formatador.format(this.dataNascimento.getTime());
		
		}catch(Exception e){
			System.out.println("Formato de data inválido!");
			return null;
		}
		return date;
		
	}

	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#setEndereco(br.com.classes.Endereco)
	 */
	@Override
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/* (non-Javadoc)
	 * @see br.com.classes.UsuarioIF#getEndereco()
	 */
	@Override
	public Endereco getEndereco() {
		return endereco;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getApelido() {
		return apelido;
	}
}
