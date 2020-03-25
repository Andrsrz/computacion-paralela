package productorconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor implements Runnable{
    
    private Pantalla mipantalla;
    private Buffer mibuffer;
    private long tiempoADormir;
    public Productor(Pantalla mipantalla, Buffer mibuffer)
    {
        this.mibuffer= mibuffer;
        this.mipantalla= mipantalla;
    }
    
     public     Productor(Pantalla miPantalla, Buffer miBuffer , long tiempo)
    {
        this(miPantalla, miBuffer);
        this.tiempoADormir = tiempo;
    }

    public void run()
    {
        //mientras haya algun elemento en la lista de productor
        while(mipantalla.modeloDeProductor.getSize()> 0)
        {
            try {
                //pasarlo a el buffer
                synchronized(mibuffer)
                {
                    if(!mibuffer.estaLleno())
                    {    
                        mibuffer.agregar(mipantalla.modeloDeProductor.remove(mipantalla.modeloDeProductor.getSize()-1));

                        mibuffer.notify(); 
                    }
                }
                
                Thread.sleep(this.tiempoADormir);
            } catch (InterruptedException ex) {
                
            }
            
            
        }
        
    }
}
