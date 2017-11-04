package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Sebastián
 */
public class Lista {

    Nodo Inicial = null;
    Nodo Final = null;
    Nodo Actual=null;
    
    int count = 0;

    public void Avanzar()
    {
        Actual=Actual.getNext();
    }
    
    public void Retroceder()
    {
        Actual=Actual.getPrevious();
    }
    
    public void Eliminar()
    {
        if (count==0)
        {
            JOptionPane.showMessageDialog(null, "Lista Vacía", "Error", JOptionPane.DEFAULT_OPTION);                        
        }
        
        if (Actual==Inicial)
        {
            Inicial=Inicial.getNext();
        }
        if (Actual==Final)
        {
            Final=Final.getPrevious();
        }
        Actual.getPrevious().setNext(Actual.getNext());
        Actual.getNext().setPrevious(Actual.getPrevious());
        Actual=null;        
    }
    
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void Agregar(Empleado valor) {
        Nodo nuevo = new Nodo(valor);
        if (this.getCount() > 0) {
            nuevo.setPrevious(this.getFinal());
            nuevo.getPrevious().setNext(nuevo);
            this.setFinal(nuevo);
            this.getFinal().setNext(this.getInicial());
            this.getInicial().setPrevious(this.getFinal());
        } else {
            this.setInicial(nuevo);
            this.setFinal(nuevo);
            this.getFinal().setNext(this.getInicial());
            this.getInicial().setPrevious(this.getFinal());
            this.setActual(nuevo);
        }
        this.count++;
    }

    public Nodo getActual() {
        return Actual;
    }

    public void setActual(Nodo Actual) {
        this.Actual = Actual;
    }

    public Nodo getInicial() {
        return Inicial;
    }

    public void setInicial(Nodo Inicial) {
        this.Inicial = Inicial;
    }

    public Nodo getFinal() {
        return Final;
    }

    public void setFinal(Nodo Final) {
        this.Final = Final;
    }
}
