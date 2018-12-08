package ie.gmit.sw.RESTful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarBooking {

	private String firstName;
	private String lastName;
	private double orderCost;
	private int id;
	private String carName;
	private String carReg;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public String getCarReg() {
		return carReg;
	}
	
	public void setCarReg(String carReg) {
		this.carReg = carReg;
	}
	
	@Override
	public String toString() {
		return "CarBooking [firstName=" + firstName + ", lastName=" + lastName + ", orderCost=" + orderCost + ", id="
				+ id + ", carName=" + carName + ", carReg=" + carReg + "]";
	}
	
	
}
