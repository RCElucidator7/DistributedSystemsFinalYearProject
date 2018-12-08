package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stat;
	

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIREDATA?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String selectQuery = "select * from Orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			int CustomerID = rs.getInt("CustomerID");
			String startDate = rs.getString("StartDate");
			String endDate = rs.getString("EndDate");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			
			carList.add(o);
			
			
		}
		return carList;
	}
	
	@Override
	public List<Order> write() throws RemoteException, SQLException {
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String insertQuery = "INSERT INTO Orders (OrderID, FirstName, LastName, CustomerID, StartDate, EndDate, CarReg) VALUES " + 
		"(4, 'Garry', 'Gott', 41, '13/04/18', '18/04/18', '02-G-631');";
		
		stat.executeUpdate(insertQuery);
		
		String selectQuery = "select * from Orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			int CustomerID = rs.getInt("CustomerID");
			String startDate = rs.getString("StartDate");
			String endDate = rs.getString("EndDate");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			
			carList.add(o);
			
			
		}
		return carList;
	}
	
	@Override
	public List<Order> delete(int deleteID) throws SQLException, RemoteException {
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String insertQuery = "DELETE FROM orders WHERE OrderID = " + deleteID + ";";
				
		stat.executeUpdate(insertQuery);
		
		String selectQuery = "select * from Orders ORDER BY OrderID";

		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			int CustomerID = rs.getInt("CustomerID");
			String startDate = rs.getString("StartDate");
			String endDate = rs.getString("EndDate");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			
			carList.add(o);
			
			
		}
		return carList;
	}

}
