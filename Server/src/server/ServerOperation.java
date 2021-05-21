package server;
import rmiinterface.RMIInterface;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by project on 26/04/2021
 */
public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    protected ServerOperation() throws RemoteException {

        super();

    }

    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;

    }

    @Override
    public ArrayList<String> obtenerArchivos(String ruta) throws RemoteException {
        //Carpeta del usuario
        String sCarpAct = ruta;
        //String sCarpAct = System.getProperty("user.dir");
        System.err.println("Carpeta del usuario = " + sCarpAct);

        ArrayList<String> directorios  = new ArrayList<String>();

        File carpeta = new File(sCarpAct);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            directorios.add("No hay elementos dentro de la carpeta actual");
        }
        else {
            for (int i=0; i< listado.length; i++) {
                directorios.add(listado[i]);
            }
        }
        return directorios;
    }

    public static void main(String[] args){

        try {

            Naming.rebind("//localhost/MyServer", new ServerOperation());
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}
