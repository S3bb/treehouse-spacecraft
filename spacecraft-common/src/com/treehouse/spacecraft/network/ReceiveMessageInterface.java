package com.treehouse.spacecraft.network;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

import com.treehouse.spacecraft.core.data.entity.Entity;

public interface ReceiveMessageInterface extends Remote{
	
	public void receiveMessage(String x) throws RemoteException;
	
	public void sendInt(int i) throws RemoteException, ServerNotActiveException;
	
	public void sendEntity(Entity e) throws RemoteException;
	
	public String updatePositionData(int x) throws RemoteException;

}
