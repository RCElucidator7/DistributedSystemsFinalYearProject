package ie.gmit.sw.REST_Web_Service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.catalina.connector.Request;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.RMI.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     * @throws SQLException 
     */
	
	//All below @GET Request works with postman
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/read")
    public List<Order> readOrders() throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.read();
    }
    
    @SuppressWarnings("unchecked")
	@GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/read/{value}")
    public List<Order> readCustomer(@PathParam("value") String value) throws MalformedURLException, RemoteException, Exception{
    	
    	if(value == "0"){
    		String msg = "The order number " + value + " is not in the database!";
    		return (List<Order>) Response.status(200).entity(msg).build();
    	}
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
 		return ds.readCust(value);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/readCust/{value}")
    public List<Order> readByCustID(@PathParam("value") String value) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
 		return ds.readCustByID(value);
    }
    
    //Below Methods for creating, Deleting and updating were done using the @POST method as with my form submission in the .jsp HTML only supports GET and POST requests
    //I am aware this is the incorrect way to do this but at the time I was unable to do it correctly.
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/create")
    public List<Order> createOrder(String orderDetails) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.write(orderDetails);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/delete")
    public List<Order> deleteOrder(String orderId) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.delete(orderId);
        
    }
    
    //Attempted to use @DELETE to work with postman but unable to complete
    /*@DELETE
    @Produces(MediaType.APPLICATION_XML)
    @Path("/delete")
    public List<Order> deleteOrderPostman(String orderId) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.delete(orderId);
        
    }*/
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/update")
    public List<Order> updateOrder(String orderId) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.update(orderId);
        
    }
    
    //Attempted to use @PUT to work with postman but unable to complete
    /*@PUT
    @Produces(MediaType.APPLICATION_XML)
    @Path("/update")
    public List<Order> updateOrderPostman(String orderId) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.update(orderId);
        
    }*/
    
}