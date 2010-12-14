package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Marca {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;	
private String nome;
@OneToMany (cascade=CascadeType.ALL, mappedBy="marca")
private List<Produto> produtos;
@OneToMany (mappedBy="marca")
private List<Equipamento> equipamentos;

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
public void setProdutos(List<Produto> produtos) {
	this.produtos = produtos;
}
public List<Produto> getProdutos() {
	return produtos;
}
public void setEquipamentos(List<Equipamento> equipamentos) {
	this.equipamentos = equipamentos;
}
public List<Equipamento> getEquipamentos() {
	return equipamentos;
}



}
