/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.*;

/**
 *
 * @author andrsrz
 */

public class ServerLauncher {
    public static void main(String[] args) {
        try{
            // rmiregistry
            LocateRegistry.createRegistry(1234);

            // New server object
            ServerInterface server = new Server();
            Naming.rebind("/Chat", server);
            System.out.println("Server Ready...");
        } catch (Exception e){
            System.err.println("Server Failed... " + e);
        }
    }
}
