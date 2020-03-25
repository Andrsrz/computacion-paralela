package comparador;

public class Comparador {
    Secuencial sec;
    Concurrente con;
    
    public Comparador ()
    {
        
        
    }
    public static void main(String[] args) {
        Secuencial sec;
        Concurrente con ;
        
        sec = new Secuencial();
        con = new Concurrente();
        int tamaño = Integer.parseInt(args[0]);
        int [] randoms = new int[tamaño];
        double tm1, tm2, fin1, fin2, inicio1, inicio2;
        
        for (int t = 0; t < tamaño; t++)
        {
            randoms[t] = (int) (Math.random()*200000) -100000;
        }
        for (int t = 0; t < tamaño; t++)
        {
            inicio1 = System.currentTimeMillis();
            sec.mergeSort(randoms);
            fin1 = System.currentTimeMillis();
            tm1 = fin1 - inicio1;
            
            
            inicio2 = System.currentTimeMillis();
            con.sort(randoms);
            fin2 = System.currentTimeMillis();
            tm2 = fin2 - inicio2;

        
        System.out.println("Tiempo secuencial: " + tm1);
        System.out.println("Tiempo paralelo: " + tm2);
        }
        
        
    }
    
}
