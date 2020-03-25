package productorconsumidor;

public class Consumidor implements Runnable {
    private Pantalla miPantalla;
    private Buffer miBuffer;
    private long tiempoaDormir;
    
    public Consumidor(Pantalla miPantalla, Buffer miBuffer)
    {
        this.miBuffer= miBuffer;
        this.miPantalla= miPantalla;
    }
    
    public Consumidor(Pantalla miPantalla, Buffer miBuffer , long t)
    {
        this(miPantalla, miBuffer);
        this.tiempoaDormir = t;
    }
    public void run()
    {
        //mientras exista algun elemento en el buffer
        while(miBuffer.getSize()>0)
        {
            //lo paso a la lista del cossumidor
            synchronized(miBuffer)
            {
                if(miBuffer.isEmpty())
                    try {
                        miBuffer.wait(); // monitor le notifica que hay alguien esperando
                } catch (InterruptedException ex) {
                   
                }
                //si el buffer no esta vacio
               
                   miPantalla.modeloDeConsumidor.addElement(miBuffer.quitar());
                
            }
            try {
                Thread.sleep(tiempoaDormir);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
    
}
