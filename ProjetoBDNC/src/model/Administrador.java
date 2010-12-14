package model;
import javax.persistence.*;

@Entity
@DiscriminatorValue("AD")

public class Administrador extends Usuario implements AdministradorIF{
	
	private int permissao;

	public int getNivelPermissao() {
		return permissao;
	}

	public void setNivelPermissao(int nivelPermissao) {
		this.permissao = nivelPermissao;
	}

}
