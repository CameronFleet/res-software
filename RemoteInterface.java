package JavaRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteInterface extends Remote {

	public void shout() throws RemoteException;
	
	public void sendOrder(Order o) throws RemoteException;
	
	

}
