/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author andrsrz
 */

public class Server extends UnicastRemoteObject implements ServerInterface {

    private ArrayList<ClientInterface> clients;
    
    public Server () throws RemoteException {
        // Construct code
        clients = new ArrayList<>();
    }
    
    public String getOnlineUsers() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Users online: \n");
        for (ClientInterface client : clients) {
            sb.append(client.getUserName()).append("\n");
        }
        if (clients.isEmpty()) {
            sb.append("No Users.\n");
        }
        return sb.toString();
    }

    @Override
    public boolean login(ClientInterface client) throws RemoteException {
        System.out.println(client.getUserName() + " is online...");
        client.message("You're online now.\n" + getOnlineUsers());
        publish(client.getUserName() + " is online.", client);
        clients.add(client);
        return true;
    }

    @Override
    public boolean logout(ClientInterface client) throws RemoteException {
        System.out.println(client.getUserName() + " is offline...");
        client.message("You're offline now.");
        publish(client.getUserName() + " is offline.", client);
        clients.remove(client);
        return true;
    }

    @Override
    public void publish(String message, ClientInterface client) throws RemoteException {
        System.out.println(message);
        for (ClientInterface client1 : clients) {
            try {
                client1.message(message);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public ArrayList<ClientInterface> getConnected() throws RemoteException {
        return clients;
    }
}