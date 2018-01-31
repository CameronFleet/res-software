package JavaRMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import KitchenApplication.KitchenClient;

public class Server {
	private KitchenClient kc;
	
	public Server(KitchenClient kc) {
		this.kc = kc;
	}

	public void start() {
		try {
			Registry reg = LocateRegistry.getRegistry();
			RemoteObject ro = new RemoteObject(kc);
			
			RemoteInterface ri = (RemoteInterface) UnicastRemoteObject.exportObject(ro,0);
			reg.rebind("SASA", ri);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}
}
