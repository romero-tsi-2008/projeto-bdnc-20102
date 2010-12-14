package DAOInterface;

import java.util.List;
import model.Equipamento;

public interface DAOequipamentoIF extends DAOdefaultIF{

	public Equipamento findById(int id);
	
	public List<Equipamento> listarEquipamentos();
	
}
