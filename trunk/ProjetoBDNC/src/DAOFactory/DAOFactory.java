package DAOFactory;

public abstract class DAOFactory implements DAOFactoryIF{
	
	public static DAOFactoryIF getInstance(String tipo) {
		if (tipo == "jpa") {
			return new DAOFactoryJPA();
		}
		else if (tipo == "db4o") {
			return new DAOFactoryDB4O();
		}
		else 
			return null;
	}
}
