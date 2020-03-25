/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorescritor;

/**
 *
 * @author Andrés Ruiz dC
 */
public class Gestion {
    public Gestion() {
    }
    public boolean pausar;

    public synchronized void reanudar() {
        /*
         * Si pulsamos el botón reanudar pondremos pausar a falso y el programa
         * continuará, notificamos a todos los hilos esperando que ya pueden
         * seguir trabajando.
         */

        pausar = false;
        notifyAll();
    }

    public synchronized void detener() {

        /**
         * Si pulsamos el botón detener, pondremos pausar a true y los hilos
         * harán wait.
         */
        
        pausar = true;
    }

    public synchronized void parar() {

        /*
         * Analizamos la condicion de pausar. Si es true hacemos un wait y
         * esperamos, si es false no hacemos nada ni ponemos ningún mensaje.
         */

        if (pausar) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("" + e);
            }
        }
    }
}
