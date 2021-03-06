package com.treehouse.spacecraft.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.treehouse.spacecraft.core.data.entity.MoveableEntity;
import com.treehouse.spacecraft.network.InputCommand;
import com.treehouse.spacecraft.network.SpacecraftProtocol;

public class Server extends UnicastRemoteObject implements SpacecraftProtocol {

	private static final long serialVersionUID = -8368134709255563426L;
	private int port;
	private Registry registry;

	protected Server() throws RemoteException {
		super();
	}

	public void start() throws RemoteException {
		registry = LocateRegistry.createRegistry(port);
		registry.rebind("rmiServer", this);
	}
	
	public void shutDown() throws NotBoundException, RemoteException {
		registry.unbind("rmiServer");
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	@Override
	public MoveableEntity updatePosition(InputCommand ic) throws RemoteException {
		
		return null;
	}

}
