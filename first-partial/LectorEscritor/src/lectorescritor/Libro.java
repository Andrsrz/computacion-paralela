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
public class Libro {
    private String libro;
    private LectorEscritor interfaz;
    private int lecturas;
    private boolean escritores;
    private int numPeticionesE;

    /**
     *
     * @param interfaz
     */
    public Libro(LectorEscritor interfaz) {

        /**
         * Creamos el constructor y inicializamos a lo que queremos.
         */
        this.interfaz = interfaz;
        libro = "";
        lecturas = 0;
        escritores = false;
        numPeticionesE = 0;
    }

    public synchronized void leerLibro(int identificador) {

        /**
         * Este método se encarga de leer el libro, esperaremos si los
         * escritores están funcionando o hay peticiones de esctitura. Si no se
         * da ninguna de las 2 condiciones, procedemos a introducir los datos en
         * el jTextField e incrementamos las lecturas. No devolvemos nada.
         */
        while (escritores || numPeticionesE > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        interfaz.meterDatos(1, interfaz.leerDatos(1) + "" + identificador + " ");
        lecturas++;
    }

    public synchronized boolean libroTerminado() {

        /**
         * Si el libro ha llegado a 50 habremos terminado de leer y devolvemos
         * un valor booleano.
         */
        if (libro.length() == 50) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized void terminarLeer(int identificador) {

        /**
         * Este método se encarga de terminar de leer los datos, decrementamos
         * las lecturas conforme vayamos leyendo. Introducimos los datos en el
         * jTextField de los libros leídos y si llegamos a 0 despertamos a los
         * hilos que estaban esperando. Si el libro está terminado (ha llegado a
         * 50) entonces procedemos a meter los datos en el jTextArea
         */
        lecturas--;
        interfaz.meterDatos(1, interfaz.leerDatos(1).replaceAll("" + identificador + " ", ""));
        if (lecturas == 0) {
            notifyAll();
        }
        if (libroTerminado()) {
            interfaz.meterDatos(4, interfaz.leerDatos(4) + "Leido por " + identificador + ": " + libro + "\n");

        }
    }

    public synchronized void escribirLibro(int identificador) {

        /**
         * Este método se encarga de escribir en el libro, la estructura es como
         * la de lectura, si hay escritores (otro hilo escritor) o si hay
         * lecturas por hacer, entonces esperamos.
         *
         */
        
        numPeticionesE++;
        while (escritores || (lecturas > 0)) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        escritores = true;
        libro = libro + identificador;
        interfaz.meterDatos(2, interfaz.leerDatos(2) + identificador);
        interfaz.meterDatos(3, libro);
        numPeticionesE--;
    }

    public synchronized void terminarEscribir(int identificador) {
        
        /**
         * Método que termina de escribir un libro. Cuando termina, despertamos a todos los hilos que estaban esperando.
         */
        
        escritores = false;
        interfaz.meterDatos(2, interfaz.leerDatos(2).replaceAll("" + identificador, ""));
        notifyAll();
    }
}
