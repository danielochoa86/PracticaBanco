import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String id;
    private LocalDate DOB;
    private String ocupacion;
    private String residencia;
    private String password;
    private String email;
    private List<Cuenta> Cuentas = new ArrayList<Cuenta>();

    public Cliente(String nombre, String id, LocalDate DOB, String ocupacion,
                   String residencia, String password, String email) {
        this.nombre = nombre;
        this.id = id;
        this.DOB = DOB;
        this.ocupacion = ocupacion;
        this.residencia = residencia;
        this.password = password;
        this.email = email;
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }
    public LocalDate getDOB() {
        return DOB;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public String getResidencia() {
        return residencia;
    }
    public List<Cuenta> getCuentas() {return List.copyOf(Cuentas); }
    public String getPassword() {
        return password;
    }
    public String getEmail() {return email; }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {this.email = email; }
    public void addCuentas(Cuenta cuenta) {
        Cuentas.add(cuenta);
    }

    public String toString(){
        return "Cliente: " + nombre +
                "\nId: " + id +
                "\ne-mail: " + email;
    }


}
