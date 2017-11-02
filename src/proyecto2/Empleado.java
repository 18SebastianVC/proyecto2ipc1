package proyecto2;

/**
 *
 * @author Marcos Sebastián
 */
public class Empleado {
    
    private int Id;
    private String nombre,apellido,puesto;
    private int tipousuario,d,l,m,mi,j,v,s;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getMi() {
        return mi;
    }

    public void setMi(int mi) {
        this.mi = mi;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
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

    public Empleado (int Id,String nombre, String apellido, String puesto, int tipousuario,int d, int l, int m, int mi, int j, int v, int s, String nick, String password)
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
