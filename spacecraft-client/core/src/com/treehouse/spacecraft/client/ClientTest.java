package com.treehouse.spacecraft.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;

import com.treehouse.spacecraft.core.data.entity.DefaultEntity;
import com.treehouse.spacecraft.network.ReceiveMessageInterface;

public class ClientTest {
	
	    static public void main(String args[]) throws ServerNotActiveException
	    {
	       ReceiveMessageInterface rmiServer;
	       Registry registry;
	       String serverAddress=args[0];
	       String serverPort=args[1];
	       String text=args[2];
	       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
	       try{
	           registry=LocateRegistry.getRegistry(
	               serverAddress,
	               (new Integer(serverPort)).intValue()
	           );
//	           registry =  LocateRegistry.getRegistry(serverAddress, (new Integer(serverPort)).intValue(), new SslRMIClientSocketFactory());
	           // look up the remote object
	           rmiServer=
	              (ReceiveMessageInterface)(registry.lookup("rmiServer"));
	           // call the remote method
	           rmiServer.receiveMessage(text);
	           rmiServer.sendInt(10);
	           rmiServer.sendEntity(new DefaultEntity(10,15,100,200));
	           long begin = System.currentTimeMillis();
	           for(int i = 0; i < 60; i++){
	           rmiServer.updatePositionData(3);
	           }
	           long end = System.currentTimeMillis();
	           long delta = end - begin;
	           System.out.println("60 Iterationen haben " + delta + " Millisekunden gedauert.");
	       }
	       catch(RemoteException e){
	           e.printStackTrace();
	       }
	       catch(NotBoundException e){
	           e.printStackTrace();
	       }
	    }
	}

