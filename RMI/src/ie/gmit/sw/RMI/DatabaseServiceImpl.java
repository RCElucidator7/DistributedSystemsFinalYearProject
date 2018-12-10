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
		//Gets the connection to the database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIREDATA?useSSL=false", "root", "");
	}

	//Read method that returns a List of all the Orders in the database
	@Override
	public List<Order> read() throws RemoteException, SQLException {
		//Creates a Statement object for sending SQL statements to the database
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		//Assign the query to a string
		String selectQuery = "select * from Orders ORDER BY OrderID";
		
		//Execute using the string from above
		ResultSet rs = stat.executeQuery(selectQuery);
		
		//Search through the result set and get each value in the database
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
			
			//Set the read in values to the Order object and add it to the List of object we return
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
	
	//Reads in information only viewable by the customer so long as they have their Customer ID
	@Override
	public List<Order> readCustByID(String id) throws RemoteException, SQLException {
		//Creates a Statement object for sending SQL statements to the database
		stat = con.createStatement();
				
		List<Order> carList = new ArrayList<Order>();
		
		//Assign the query to a String
		String selectQuery = "select * from Orders WHERE CustomerID = '" + id + "';";
		
		//Execute the query with the above string
		ResultSet rs = stat.executeQuery(selectQuery);
				
		//Search through the result set and get each value in the database
		if(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			int CustomerID = rs.getInt("CustomerID");
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			//Set the read in values to the Order object and add it to the List of object we return
			o.setOrderID(OrderID);
			o.setFirstName(firstName);
			o.setLastName(lastName);
			o.setCustomerID(CustomerID);
			o.setCarModel(CarModel);
			
			carList.add(o);
		}
			
			
		return carList;
	}
	
	//Reads in all information on a certain customer using the Order ID
	@Override
	public List<Order> readCust(String id) throws RemoteException, SQLException {
		//Creates a Statement object for sending SQL statements to the database
		stat = con.createStatement();
		
		System.out.println(id);
		
		List<Order> carList = new ArrayList<Order>();
		
		String selectQuery = "select * from Orders WHERE OrderID = '" + id + "';";
		
		System.out.println(selectQuery);
		
		ResultSet rs = stat.executeQuery(selectQuery);
				
		//Search through the result set and get each value in the database
		if(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			int CustomerID = rs.getInt("CustomerID");
			String startDate = rs.getString("StartDate");
			String endDate = rs.getString("EndDate");
			String CarReg = rs.getString("CarReg");
			String CarModel = rs.getString("CarModel");
			
			Order o = new Order();
			
			//Set the read in values to the Order object and add it to the List of object we return
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
	
	//Method that takes in the users values and writes them to the database
	@Override
	public List<Order> write(String orderDetails) throws RemoteException, SQLException {
		//Creates a Statement object for sending SQL statements to the database
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
				
		//Add the query to a string to get ready to execute
		String insertQuery = "INSERT INTO Orders (OrderID, FirstName, LastName, CustomerID, StartDate, EndDate, CarReg, CarModel) VALUES " + 
		"(NULL, '" + orderDetails + ");";
		
		//Execute the query
		stat.executeUpdate(insertQuery);
		
		//Use the Select query to return the list of data to the user after adding
		String selectQuery = "select * from Orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		//Search through the result set and get each value in the database
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
			
			//Set the read in values to the Order object and add it to the List of object we return
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
		//Creates a Statement object for sending SQL statements to the database
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		//Add the query to a string using the orderID passed in by the user
		String insertQuery = "DELETE FROM orders WHERE " + deleteID + ";";
				
		//Execute the statement
		stat.executeUpdate(insertQuery);
		
		String selectQuery = "select * from Orders ORDER BY OrderID";

		ResultSet rs = stat.executeQuery(selectQuery);
		
		//Search through the result set and get each value in the database
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
			
			//Set the read in values to the Order object and add it to the List of object we return
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
		//Creates a Statement object for sending SQL statements to the database
		stat = con.createStatement();

		List<Order> carList = new ArrayList<Order>();
		
		String orderID;			
		//Split the String into an Array to get the OrderID value at the first index
		String inputArray[] = orderDetails.split("&");
		
		System.out.println(orderDetails);
		
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
		orderDetails = orderDetails.replace("carModel=", "carModel='");
		
		//Add a ' for closing the carReg value
		orderDetails = orderDetails + "'";
		
		//If any of the values are null, replace them with an empty space
		orderDetails = orderDetails.replace("firstName='',", "");
		orderDetails = orderDetails.replace("lastName='',", "");
		orderDetails = orderDetails.replace("customerId='',", "");
		orderDetails = orderDetails.replace("startDate='',", "");
		orderDetails = orderDetails.replace("endDate='',", "");
		orderDetails = orderDetails.replace("carReg='',", "");
		orderDetails = orderDetails.replace("carModel=''", "");
		
		//Replace all the blank spaces so the If can check the end of the string
		orderDetails = orderDetails.replaceAll(" ", "");
		//Check if the string ends with a comma (it will only do so if 1 field is updates)
		if(orderDetails.endsWith(",")){
			//If it does remove the last character in the string
			orderDetails = orderDetails.substring(0, orderDetails.length()-1);
		}
						
		String insertQuery = "UPDATE Orders SET " + orderDetails + " WHERE " + orderID + ";";
		
		stat.executeUpdate(insertQuery);
		
		String selectQuery = "select * from Orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		//Search through the result set and get each value in the database
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
			
			//Set the read in values to the Order object and add it to the List of object we return
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