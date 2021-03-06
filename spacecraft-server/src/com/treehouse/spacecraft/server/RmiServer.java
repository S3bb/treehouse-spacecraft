package com.treehouse.spacecraft.server;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;

import com.treehouse.spacecraft.core.data.entity.Entity;
import com.treehouse.spacecraft.network.ReceiveMessageInterface;

public class RmiServer  extends java.rmi.server.UnicastRemoteObject
implements ReceiveMessageInterface{

	private static final long serialVersionUID = 8583211231847298573L;
	int      thisPort;
	    String   thisAddress;
	    Registry registry;    // rmi registry for lookup the remote objects.
	 
	    // This method is called from the remote client by the RMI.
	    // This is the implementation of the �gReceiveMessageInterface�h.
	    public void receiveMessage(String x) throws RemoteException
	    {
	        System.out.println(x);
	    }
	 
	    public RmiServer() throws RemoteException
	    {
	        try{
	            // get the address of this host.
	            thisAddress= (InetAddress.getLocalHost()).toString();
	            
	        }
	        catch(Exception e){
	            throw new RemoteException("can't get inet address.");
	        }
	thisPort=4711; 
	        System.out.println("this address="+thisAddress+",port="+thisPort);
	        try{
	        // create the registry and bind the name and object.
	        registry = LocateRegistry.createRegistry( thisPort );
	            registry.rebind("rmiServer", this);
	        }
	        catch(RemoteException e){
	        throw e;
	        }
	    }
	   
	    static public void main(String args[])
	    {
	        try{
	        RmiServer s =new RmiServer();
	    }
	    catch (Exception e) {
	           e.printStackTrace();
	           System.exit(1);
	    }
	     }

		@Override
		public void sendInt(int i) throws RemoteException, ServerNotActiveException {
			 System.out.println(i);
			 System.out.println("Clientname: " + getClientHost());
		}

		@Override
		public void sendEntity(Entity e) throws RemoteException {
			 System.out.println(e.getX());
			 System.out.println(e.getWidth());
		}

		@Override
		public String updatePositionData(int x) throws RemoteException {
			return ("Dies ist ein Teststring " + x );
		}
	}
