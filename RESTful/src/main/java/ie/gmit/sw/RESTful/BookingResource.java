package ie.gmit.sw.RESTful;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("booking")
public class BookingResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCar() {
		
		System.out.println("CarBooking called");
		CarBooking car1 = new CarBooking();
		car1.setName("Larry");
		car1.setId(1);
		car1.setCar("Civic");
		System.out.println("Finish");
		
		return car1.getCar() + " " + car1.getId() + " " + car1.getName();
    }
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public CarBooking setCar(){
		
		
		
		return null;
	}
	
}
