package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {

	public static void main(String[] args) throws Exception{
		
		//Database instance
		DatabaseService ds = new DatabaseServiceImpl();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("database", ds);
		
		System.out.println("RMI Server: Ready");
		
	}
}
