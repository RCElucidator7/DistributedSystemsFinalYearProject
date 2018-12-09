package ie.gmit.sw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {
	
	public List<Order> update(String orderDetails) throws RemoteException, SQLException;

	public List<Order> write(String orderDetails) throws SQLException, RemoteException;

	public List<Order> delete(String deleteID) throws SQLException, RemoteException;

	public List<Order> read() throws RemoteException, SQLException;

}
