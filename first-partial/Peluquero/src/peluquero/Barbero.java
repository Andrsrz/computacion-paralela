package peluquero;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Barbero implements Runnable {
    boolean duerme;
    Random r;
    Monitor m;
    JLabel stateBarBer;
    JLabel chairStatus;
    JProgressBar progress;
            
    public Barbero(Monitor m, JLabel stateBarber, JLabel chairStatus, JProgressBar progress){
        duerme = false;
        r = new Random();
        this.m = m;
        this.stateBarBer = stateBarber;
        this.chairStatus = chairStatus;
        this.progress = progress;
    }
    
    public void dormir(){
        try{                
            Log("Barbero se pone a dormir");
            stateBarBer.setText("Barbero se pone a dormir");
            duerme = true;
            m.masterChair = true;
            progress.setValue(0);
            chairStatus.setText("Barbero durmiendo en la silla");
            synchronized(this){
                wait();
            }
            Log("Desperto el barbero");
            stateBarBer.setText("Desperto el barbero");
            chairStatus.setText("Desocupado");
            duerme = false;
            m.masterChair = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            if(!m.masterChair && m.getCuantosClientes()==0 && !duerme){
                dormir();
            }
            Log("Barbero Dormido?: "+duerme);
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
