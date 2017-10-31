package proyecto2;

/**
 *
 * @author Marcos Sebastián
 */
public class Nodo {

    Empleado valor;
    Nodo previous=null;
    Nodo next = null;
    
    public Nodo(Empleado valor) {
        this.valor = valor;
    }

    public Empleado getValor() {
        return valor;
    }

    public void setValor(Empleado valor) {
        this.valor = valor;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
