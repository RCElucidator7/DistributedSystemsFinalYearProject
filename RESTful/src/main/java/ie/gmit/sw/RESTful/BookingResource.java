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
		CarBooking car2 = new CarBooking();
		CarBooking car3 = new CarBooking();
		car1.setFirstName("Larry");
		car1.setId(1);
		car1.setCarName("Civic");
		car2.setFirstName("Bean");
		car2.setId(2);
		car2.setCarName("Civic");
		car3.setFirstName("Jamsey");
		car3.setId(3);
		car3.setCarName("Civic");
		System.out.println("Finish");
		
		return car1.toString() + "\n" + car2.toString() + "\n" + car3.toString();
    }
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public CarBooking setCar(){
		
		
		
		return null;
	}
	
}
