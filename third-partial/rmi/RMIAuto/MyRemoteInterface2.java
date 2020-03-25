import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteInterface2 extends Remote {
    public void myMethod1() throws RemoteException;
    public int myMethod2() throws RemoteException;
}