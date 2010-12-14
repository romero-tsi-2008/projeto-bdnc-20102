package DAOFactory;

import DAOInterface.*;
import model.*;
import persistence.jpa.*;
import DAOFactory.*;

public interface DAOFactoryIF {
	
	public DAOadministradorIF createAdministradorDAO();
	public DAOcategoriaIF createCategoriaDAO();
	public DAOcidadeIF createCidadeDAO();
	public DAOclienteIF createClienteDAO();
	public DAOcomentarioIF createComentarioDAO();
	public DAOenderecoIF createEnderecoDAO();
	public DAOequipamentoIF createEquipamentoDAO();
	public DAOitemIF createItemDAO();
	public DAOpedidoIF createPedidoDAO();
	public DAOprodutoIF createProdutoDAO();
	public DAOufIF createUfDAO();
	public DAOusuarioIF createUsuarioDAO();
	public DAOtelefoneIF createTelefoneDAO();
	public DAOmarcaIF createMarcaDAO();
	
}
