package ie.gmit.sw.RESTful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarBooking {

	public String name;
	public int id;
	public String car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	
}
