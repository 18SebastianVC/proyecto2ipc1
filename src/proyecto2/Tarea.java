package proyecto2;
import java.util.Date;

/**
 *
 * @author Marcos Sebastián
 */
public class Tarea {
    private String NombreTarea,DescTarea,EmpleadoTarea;
    private int Duracion,Porcentaje;
    private Date FechaI,FechaF;

    public Date getFechaI() {
        return FechaI;
    }

    public void setFechaI(Date FechaI) {
        this.FechaI = FechaI;
    }

    public Date getFechaF() {
        return FechaF;
    }

    public void setFechaF(Date FechaF) {
        this.FechaF = FechaF;
    }

    public String getNombreTarea() {
        return NombreTarea;
    }

    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }

    public String getDescTarea() {
        return DescTarea;
    }

    public void setDescTarea(String DescTarea) {
        this.DescTarea = DescTarea;
    }

    public String getEmpleadoTarea() {
        return EmpleadoTarea;
    }

    public void setEmpleadoTarea(String EmpleadoTarea) {
        this.EmpleadoTarea = EmpleadoTarea;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public Tarea (String NombreTarea,String DescTarea,String EmpleadoTarea,int Duracion, int Porcentaje, Date FechaI, Date FechaF)
    {
        this.NombreTarea=NombreTarea;
        this.DescTarea=DescTarea;
        this.EmpleadoTarea=EmpleadoTarea;
        this.Duracion=Duracion;
        this.Porcentaje=Porcentaje;
        this.FechaI=FechaI;
        this.FechaF=FechaF;
        
    }

    public String toString() {
        return NombreTarea;
        
    }   

    
}
