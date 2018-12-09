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
		
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/read")
    public List<Order> readOrders() throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.read();
    }
    
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
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/update")
    public List<Order> updateOrder(String orderId) throws MalformedURLException, RemoteException, Exception{
    	
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	    	
        return ds.update(orderId);
        
    }
    
}