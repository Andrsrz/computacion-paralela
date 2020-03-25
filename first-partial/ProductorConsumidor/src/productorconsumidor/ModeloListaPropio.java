package productorconsumidor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class ModeloListaPropio extends DefaultListModel {
    
    private JLabel etiqueta;
    public ModeloListaPropio(JLabel e)
    {
        this.etiqueta = e;
    }
    @Override
    public Object remove(int indice)
    {
        Object o = super.remove(indice);
        this.actualizarEtiqueta();
        return o;
    }
    
    @Override
    public void addElement(Object o)
    {
        super.addElement(o);
        this.actualizarEtiqueta();
        
    }
    
    private void actualizarEtiqueta()
    {
        this.etiqueta.setText(String.valueOf( this.getSize()));
    }
}
