/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ui.UI;

/**
 *
 * @author andrsrz
 */

public class Client extends UnicastRemoteObject implements ClientInterface {
    
    private String userName;
    private UI ui;

    public Client (String userName) throws RemoteException {
        this.userName = userName;
    }
    
    @Override
    public void message(String message) throws RemoteException {
        System.out.println(message);
        ui.writeMessage(message);
    }

    @Override
    public String getUserName() throws RemoteException {
        return userName;
    }
    
    public void setUI (UI ui) {
        this.ui = ui;
    }
}
