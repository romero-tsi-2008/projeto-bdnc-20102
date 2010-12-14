package model;

import java.util.Calendar;

public interface ProdutoIF {

	public abstract void setIdproduto(int idproduto);

	public abstract String getNomeproduto();

	public abstract void setNomeproduto(String nomeproduto);

	public abstract double getPreco();

	public abstract void setPreco(double preco);

	public abstract int getEstoque();

	public abstract void setEstoque(int estoque);

	public abstract String getDescricao();

	public abstract void setDescricao(String descricao);

	public abstract Categoria getCategoria();

	public abstract void setCategoria(Categoria categoria);

	public abstract int getId();

	public abstract String getDataDaInclusao();

	public abstract void setDataDaInclusao(Calendar dataDaInclusao);

	public abstract void setNumeroDeVendas(int numeroDeVendas);

	public abstract int getNumeroDeVendas();

	public abstract void addNumeroDeVendas();

	public abstract boolean subEstoque(int quantidade);

	
	
	

}