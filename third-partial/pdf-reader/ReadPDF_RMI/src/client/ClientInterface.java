/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author andrsrz
 */

public interface ClientInterface extends Remote {
    public void message (String message) throws RemoteException;
    public String getUserName() throws RemoteException;
}
