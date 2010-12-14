package DAOInterface;

import java.util.List;

import javax.persistence.EntityManager;

import model.Marca;

public interface DAOdefaultIF<X> {	

	public void begin();
	
    public void close();    
    
    public void commit();
    
    public void rollback();
	
	public void persist(X obj);	
	
	public void remove(X obj);
	
	public void merge(X obj);

	public List<X> findAllByQueryLimited(String query, int max);

}
