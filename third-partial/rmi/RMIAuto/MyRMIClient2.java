import java.net.InetAddress;
import java.rmi.Naming;

public class MyRMIClient2 {
    public static void main (String[] args) {
        try {
            MyRemoteInterface2 mRI = (MyRemoteInterface2)Naming.lookup("rmi://" 
                + "192.168.0.12" 
                + ":" 
                + args[0] 
                + "/TestRMI");

            for (int i = 1; i < mRI.myMethod2(); i++) {
                mRI.myMethod1();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}