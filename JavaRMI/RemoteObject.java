package JavaRMI;

import java.rmi.RemoteException;

import KitchenApplication.KitchenClient;

public class RemoteObject implements RemoteInterface {
	
	private KitchenClient kc;
	
	public RemoteObject(KitchenClient kc) {
		this.kc = kc;
	}

	@Override
	public void shout() throws RemoteException {
		System.out.println("Hello World!");
		
	}

	@Override
	public void sendOrder(Order o) throws RemoteException {
		kc.addOrder(o);
		
	}


}
