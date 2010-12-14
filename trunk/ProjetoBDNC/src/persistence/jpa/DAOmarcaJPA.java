package persistence.jpa;

import java.util.List;

import model.Marca;
import DAOInterface.DAOmarcaIF;

public class DAOmarcaJPA extends DAOdefaultJPA implements DAOmarcaIF{

	@Override
	public List<Marca> listarMarcas() {
		return (List<Marca>) findAllByQueryLimited("select m from Marca m", 20);
	}

	@Override
	public Marca findById(int id) {
		return (Marca) findByQuery("select m from Marca m where m.id = "+id);
	}

	@Override
	public Marca findByName(String nome) {
		return (Marca) findByQuery("select m from Marca m where m.nome = "+nome);

	}
}
