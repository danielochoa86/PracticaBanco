import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Menu_Cliente {

    private Scanner sc = new Scanner(System.in);
    private int cuenta_id;
    private Set<String> opciones = new LinkedHashSet<>();
    private Cliente active;

    public Menu_Cliente(){
        this.sc = new Scanner(System.in);
    }

    public void ejecutar(){
        cuenta_id = 1;

        while (true){
            active = crearUsuario();
            mostrarOpciones();
            String seleccion = sc.nextLine();

            switch (seleccion){
                case "z": System.out.println("Saliendo"); return;
                case "a":
                        abrirCuenta(active,new CuentaAhorros(100,0.05,cuenta_id));
                        cuenta_id++;
                        break;
                case "b":
                        abrirCuenta(active,new CuentaCredito(0,-0.05,cuenta_id));
                        cuenta_id++;
                        break;
                case "c":
                        abrirCuenta(active,new CuentaDebito(0,0.01,cuenta_id));
                        cuenta_id++;
                        break;
                default: System.out.println("Opción inválida");

            }
        }
    }

    private String textInput(String p){
        while(true){
            System.out.println(p);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Por favor ingrese un valor.");
        }
    }

    private Cliente crearUsuario(){
        System.out.println("Creemos un Usuario para usted:");
        String userName = textInput("Nombre:");
        String userId = textInput("Identificación:");
        String userOcc = textInput("Ocupación:");
        String userAdd = textInput("Dirección:");
        String userEmail = textInput("E-mail:");
        String userPw = textInput("Contraseña:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String rawDOB = textInput("Fecha de nacimiento (dd/MM/yyyy");
        LocalDate DOB = LocalDate.parse(rawDOB, formatter);
        Cliente cliente = new Cliente(userName,userId,DOB,userOcc,userAdd,userPw,userEmail);
        return cliente;
    }

    //metodo para desplegar las opciones dinámicamente
    //se alía al metodo add para desplegar las opciones que el usuario deberá elegir
    private void mostrarOpciones(){
        opciones.clear();
        add("z","Salir");
        add("a", "Cuenta de ahorros");
        add("b", "Cuenta de crédito");
        add("c", "Cuenta de débito");
        }

    //print el número de opción + el texto que le acompaña
    private void add(String abc, String t){
        opciones.add(abc);
        System.out.println("["+abc+"]"+t);
    }

    private void abrirCuenta(Cliente cliente, Cuenta cuenta) {
        cliente.addCuentas(cuenta);
    }

}
