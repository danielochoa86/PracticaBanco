import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String id;
    private LocalDate DOB;
    private String ocupacion;
    private String residencia;

    public Cliente(String nombre, String id, LocalDate DOB, String ocupacion, String residencia) {
        this.nombre = nombre;
        this.id = id;
        this.DOB = DOB;
        this.ocupacion = ocupacion;
        this.residencia = residencia;
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

    public String toString(){
        return System.out.println("El cliente: " + nombre + "creado.");
    }



}
