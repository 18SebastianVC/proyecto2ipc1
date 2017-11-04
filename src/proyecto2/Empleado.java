package proyecto2;

/**
 *
 * @author Marcos Sebastián
 */
public class Empleado {
    
    private int Id;
    private String nombre,apellido,puesto;
    private int tipousuario;
    private boolean d,l,m,mi,j,v,s;

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public boolean isL() {
        return l;
    }

    public void setL(boolean l) {
        this.l = l;
    }

    public boolean isM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }

    public boolean isMi() {
        return mi;
    }

    public void setMi(boolean mi) {
        this.mi = mi;
    }

    public boolean isJ() {
        return j;
    }

    public void setJ(boolean j) {
        this.j = j;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }
    private String nick,password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado (int Id,String nombre, String apellido, String puesto, int tipousuario,boolean d, boolean l, boolean m, boolean mi, boolean j, boolean v, boolean s, String nick, String password)
    {
        this.Id =Id;  
        this.nombre =nombre;  
        this.apellido =apellido;  
        this.puesto =puesto;  
        this.tipousuario =tipousuario;  
        this.d =d;  
        this.l =l;  
        this.m =m;  
        this.mi =mi;  
        this.j =j;  
        this.v =v;  
        this.s =s;  
        this.nick=nick;
        this.password=password;
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String toString() {
        return nombre+" "+apellido;
        
    }   

    
}
