package productorconsumidor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class Buffer extends ModeloListaPropio{
    
    private int limite;
    public Buffer(int l, JLabel etiqueta)
    {
        super(etiqueta);
        this.limite=l;
        
    }
    public boolean estaLleno()
    {
        if(this.getSize()>=limite)
        {
            return true;
        }
        else
        {
            return false;
        }   
    }
    
    public void agregar(Object o)
    {
        this.addElement(o);
    }
    
    public Object quitar()//extraer el ultimo elemento del buffer y lo regresa
    {
        return this.remove(0);
    }
}
