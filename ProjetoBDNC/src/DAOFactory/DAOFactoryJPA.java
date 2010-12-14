package DAOFactory;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public class DAOFactoryJPA extends DAOFactory{
	
	public DAOadministradorIF createAdministradorDAO() {
		return new DAOadministradorJPA();
	}
	
	public DAOcategoriaIF createCategoriaDAO() {
		return new DAOcategoriaJPA();
	}
	
	public DAOcidadeIF createCidadeDAO() {
		return new DAOcidadeJPA();
	}
	
	public DAOclienteIF createClienteDAO() {
		return new DAOclienteJPA();
	}
	
	public DAOcomentarioIF createComentarioDAO() {
		return new DAOcomentarioJPA();
	}
	
	public DAOenderecoIF createEnderecoDAO() {
		return new DAOenderecoJPA();
	}
	
	public DAOequipamentoIF createEquipamentoDAO() {
		return new DAOequipamentoJPA();
	}
	
	public DAOitemIF createItemDAO() {
		return new DAOitemJPA();
	}
	
	public DAOpedidoIF createPedidoDAO() {
		return new DAOpedidoJPA();
	}
	
	public DAOprodutoIF createProdutoDAO() {
		return new DAOprodutoJPA();
	}
	
	public DAOufIF createUfDAO() {
		return new DAOufJPA();
	}
	
	public DAOusuarioIF createUsuarioDAO() {
		return new DAOusuarioJPA();
	}
	
	public DAOtelefoneIF createTelefoneDAO() {
		return new DAOtelefoneJPA();
	}
	
	public DAOmarcaIF createMarcaDAO() {
		return new DAOmarcaJPA();
	}
}
