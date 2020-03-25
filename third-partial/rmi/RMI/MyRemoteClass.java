import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClass extends java.rmi.server.UnicastRemoteObject implements MyRemoteInterface {

    public MyRemoteClass () throws java.rmi.RemoteException {
        // Construct code
    }

    public void myMethod1 () throws java.rmi.RemoteException {
        // Put any code
        System.out.println("I'm in method number 1!");
    }

    public int myMethod2 () throws java.rmi.RemoteException {
        // Put any code
        int x = 5;
        int y = 5;
        int sum = x + y;
        return sum;
    }

    public static void main (String[] args) {
        try {
            MyRemoteInterface mRI = new MyRemoteClass();
            LocateRegistry.createRegistry(1234);
            
            java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress() + ":" + args[0] + "/TestRMI", mRI);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}