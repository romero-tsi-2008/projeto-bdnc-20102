package DAOFactory;


import DAOInterface.*;
import persistence.db4o.*;

public class DAOFactoryDB4O extends DAOFactory{
	public DAOadministradorIF createAdministradorDAO() {
		return new DAOadministradorDB4O();
	}
	
	public DAOcategoriaIF createCategoriaDAO() {
		return new DAOcategoriaDB4O();
	}
	
	public DAOcidadeIF createCidadeDAO() {
		return new DAOcidadeDB4O();
	}
	
	public DAOclienteIF createClienteDAO() {
		return new DAOclienteDB4O();
	}
	
	public DAOcomentarioIF createComentarioDAO() {
		return new DAOcomentarioDB4O();
	}
	
	public DAOenderecoIF createEnderecoDAO() {
		return new DAOenderecoDB4O();
	}
	
	public DAOequipamentoIF createEquipamentoDAO() {
		return new DAOequipamentoDB4O();
	}
	
	public DAOitemIF createItemDAO() {
		return new DAOitemDB4O();
	}
	
	public DAOpedidoIF createPedidoDAO() {
		return new DAOpedidoDB4O();
	}
	
	public DAOprodutoIF createProdutoDAO() {
		return new DAOprodutoDB4O();
	}
	
	public DAOufIF createUfDAO() {
		return new DAOufDB4O();
	}
	
	public DAOusuarioIF createUsuarioDAO() {
		return new DAOusuarioDB4O();
	}
	
	public DAOtelefoneIF createTelefoneDAO() {
		return new DAOtelefoneDB4O();
	}

	public DAOmarcaIF createMarcaDAO() {
		return new DAOmarcaDB4O();
	}

}
