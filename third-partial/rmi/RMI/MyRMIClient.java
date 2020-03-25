public class MyRMIClient {
    public static void main (String[] args) {
        try {
            MyRemoteInterface mRI = (MyRemoteInterface)java.rmi.Naming.lookup("//" + args[0] + ":" + args[1] + "/TestRMI");

            for (int i = 1; i < mRI.myMethod2(); i++) {
                mRI.myMethod1();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}