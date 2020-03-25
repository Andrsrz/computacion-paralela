/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.ClientInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author andrsrz
 */

public interface ServerInterface extends Remote {
    public boolean login (ClientInterface client) throws RemoteException;
    // Mandar mensaje a todos los clientes
    public boolean logout (ClientInterface client) throws RemoteException;
    public void publish (String message, ClientInterface client) throws RemoteException;
    // Obtener lista de clientes conectados
    public ArrayList<ClientInterface> getConnected() throws RemoteException;
}
