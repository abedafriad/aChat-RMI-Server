/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
public class StartServer extends Thread {

    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            LocateRegistry.createRegistry(1099);

            ChatServerInt csi = new ChatServer();
            Naming.rebind("rmi://localhost:1099/acg", csi);
            System.out.println("Server is Running");
            System.out.println("Details: " + csi);
        } catch (Exception e) {
            System.out.println("Chat Server failed: " + e);
        }
    }
}
