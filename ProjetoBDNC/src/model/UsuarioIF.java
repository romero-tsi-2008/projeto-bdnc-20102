package model;

import java.util.Calendar;
import java.util.List;

public interface UsuarioIF {

	public abstract int getId();

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract String getNome();

	public abstract void setNome(String nome);
	
	public abstract void setApelido(String apelido);

	public abstract List<Telefone> getTelefones();

	public abstract void setTelefones(List<Telefone> telefones);

	public abstract void addTelefones(Telefone telefone);

	public abstract void setSenha(String senha);

	public abstract String getSenha();

	public abstract void setCpf(String cpf);

	public abstract String getCpf();

	public abstract void setCidade(Cidade cidade);

	public abstract Cidade getCidade();

	public abstract boolean setDataNascimento(int ano, int mes, int dia);

	public abstract Calendar getDataNascimento();

	public abstract void setEndereco(Endereco endereco);

	public abstract Endereco getEndereco();

	void setId(int id);

}