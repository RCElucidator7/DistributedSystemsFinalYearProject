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
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			o.setCarModel(CarModel);
			
			carList.add(o);
			
			
		}
		return carList;
	}
	
	@Override
	public List<Order> write(String orderDetails) throws RemoteException, SQLException {
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
				
		//Replace the id= with a blank space as all we need are the values
		orderDetails = orderDetails.replace("firstName=", "");
		orderDetails = orderDetails.replace("lastName=", "");
		orderDetails = orderDetails.replace("customerId=", "");
		orderDetails = orderDetails.replace("startDate=", "");
		orderDetails = orderDetails.replace("endDate=", "");
		orderDetails = orderDetails.replace("carReg=", "");
		orderDetails = orderDetails.replace("carModel=", "");
		//Replace & with a comma and a space to fit the query values into the single variable
		orderDetails = orderDetails.replace("&", "', '");
		
		//Add the closing ' to the end of the query
		orderDetails = orderDetails + "'";
				
		String insertQuery = "INSERT INTO Orders (OrderID, FirstName, LastName, CustomerID, StartDate, EndDate, CarReg, CarModel) VALUES " + 
		"(NULL, '" + orderDetails + ");";
		
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
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			o.setCarModel(CarModel);
			
			carList.add(o);
			
			
		}
		return carList;
	}
	
	@Override
	public List<Order> delete(String deleteID) throws SQLException, RemoteException {
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String insertQuery = "DELETE FROM orders WHERE " + deleteID + ";";
				
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
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			o.setCarModel(CarModel);
			
			carList.add(o);
			
			
		}
		return carList;
	}

	@Override
	public List<Order> update(String orderDetails) throws RemoteException, SQLException {
		stat = con.createStatement();

		List<Order> carList = new ArrayList<Order>();
		
		String orderID;			
		//Split the String into an Array to get the OrderID value at the first index
		String inputArray[] = orderDetails.split("&");
		
		//Assign to a variable, looks cleaner than plugging the Array into the SQL query
		orderID = inputArray[0];
		
		//Replace the & with a comma and a space for the update query
		orderDetails = orderDetails.replace("&", "', ");
		//Replace the orderID at the start of the string as its not needed in the update query
		orderDetails = orderDetails.replace(orderID +"', ", "");
		orderDetails = orderDetails.replace("firstName=", "firstName='");
		orderDetails = orderDetails.replace("lastName=", "lastName='");
		orderDetails = orderDetails.replace("customerId=", "customerId='");
		orderDetails = orderDetails.replace("startDate=", "startDate='");
		orderDetails = orderDetails.replace("endDate=", "endDate='");
		orderDetails = orderDetails.replace("carReg=", "carReg='");
		orderDetails = orderDetails.replace("carModel=", "carReg='");
		
		//Add a ' for closing the carReg value
		orderDetails = orderDetails + "'";
		
		//If any of the values are null, replace them with an empty space
		orderDetails = orderDetails.replace("firstName=''", "");
		orderDetails = orderDetails.replace("lastName=''", "");
		orderDetails = orderDetails.replace("customerId=''", "");
		orderDetails = orderDetails.replace("startDate=''", "");
		orderDetails = orderDetails.replace("endDate=''", "");
		orderDetails = orderDetails.replace("carReg=''", "");
		orderDetails = orderDetails.replace("carModel=''", "");
				
		String insertQuery = "UPDATE Orders SET " + orderDetails + " WHERE " + orderID + ";";
		
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
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setStartDate(startDate);
			o.setEndDate(endDate);
			o.setCarReg(CarReg);
			o.setCarModel(CarModel);
			
			carList.add(o);
			
			
		}
		return carList;
		
	}
}