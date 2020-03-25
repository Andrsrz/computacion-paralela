package practica_pc;

public class Consumidor extends Thread
    {
        private Contenedor contenedor;
        public Consumidor(Contenedor c)
        {
            contenedor= c; 
        }
        public void run()
        { 
            for(int i = 0; i < 10; i++)
            { 
                  
                System.out.println("Consumidor. get: " + contenedor.get()  );     
                try
                {
                    sleep((int)(Math.random() * 100));
                }
                catch(InterruptedException e)
                { } 
            }
        } 
    }
