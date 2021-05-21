package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by project on 26/04/2021
 */

public interface RMIInterface extends Remote{
    public String helloTo(String name) throws RemoteException;
    public ArrayList<String> obtenerArchivos(String ruta) throws RemoteException;
}
