package JavaRMI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private RemoteInterface stub;
	
	public Client() {
		
		Registry reg;
		
		try {
			
			reg = LocateRegistry.getRegistry("localhost");
			stub = (RemoteInterface) reg.lookup("SASA");
			
		} catch (RemoteException | NotBoundException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void sendOrder(Order o) {
		try {
			
			stub.sendOrder(o);
			//stub.shout();
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}
	
	

	

}
