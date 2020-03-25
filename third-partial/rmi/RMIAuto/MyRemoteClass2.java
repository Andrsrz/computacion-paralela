import java.rmi.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.activation.*;
import java.rmi.activation.Activatable;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import java.net.InetAddress;

public class MyRemoteClass2 extends Activatable implements MyRemoteInterface2 {

    public MyRemoteClass2 (ActivationID a, MarshalledObject m) throws RemoteException {
        // Construct code
        super(a, 0);
    }

    public void myMethod1 () throws RemoteException {
        // Put any code
        System.out.println("I'm in method number 1!");
    }

    public int myMethod2 () throws RemoteException {
        // Put any code
        int x = 5;
        int y = 5;
        int sum = x + y;
        return sum;
    }

    public static void main (String[] args) throws Exception {
        try {
            // Security policy file.
            Properties prop = new Properties();
            prop.put("java.security.policy", "./policy");

            /* 
            * We need an activation group to active the remote objects
            * and the clients can access them.
            */
            ActivationGroupDesc.CommandEnvironment ace = null;
            ActivationGroupDesc example = new ActivationGroupDesc(prop, ace);

            /*
            * We register the created group with the ActivationGroupDesc
            * and we get the register ID.
            */
            ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(example);

            // Object to the initial data if required.
            MarshalledObject m = null;

            // Object description and register in the demonio rmid.
            ActivationDesc desc = new ActivationDesc(agi, "MyRemoteClass2", "file:///home/andrsrz/Documents/Projects/JavaProjects/RMI_Repo/RMIAuto", m);
            MyRemoteInterface2 mRI = (MyRemoteInterface2)Activatable.register(desc);

            Naming.rebind("rmi://" + "192.168.0.12" + ":" + args[0] + "/TestRMI", mRI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}