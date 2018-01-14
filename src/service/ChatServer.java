/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInt {

    private Vector v = new Vector();

    public ChatServer() throws RemoteException {
    }

    @Override
    public boolean login(ChatClientInt a) throws RemoteException {
        System.out.println(a.getName() + "  got connected....");
        a.tell("You have Connected successfully.");
        publish(a.getName() + " has just connected.","");
        v.add(a);
        return true;
    }

    public void publish(String s,String name) throws RemoteException {
        System.out.println(s);
        for (int i = 0; i < v.size(); i++) {
            try {
                
                ChatClientInt tmp = (ChatClientInt) v.get(i);
                if(!tmp.getName().equals(name))
                tmp.tell(s);
            } catch (Exception e) {
                //problem with the client not connected.
                //Better to remove it
            }
        }
    }

    public Vector getConnected() throws RemoteException {
        return v;
    }
}
