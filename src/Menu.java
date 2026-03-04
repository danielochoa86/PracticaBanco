import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Set<String> opciones = new LinkedHashSet<>();
    private Cliente active;
    private Banco banco;

    public Menu(Banco banco) {
        this.banco = banco;
        this.sc = new Scanner(System.in);
    }

    public void ejecutar() {
        boolean salir = false;

        while (salir) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1) Registrar un cliente nuevo");
            System.out.println("2) Listar clientes");
            System.out.println("3) Ver cliente");
            System.out.println("4) Salir");
            System.out.println("Seleccione:");

            int seleccion = leerEntero();

            switch (seleccion) {
                case 1 -> registrarClienteUI();
                case 2 -> listarClientesUI();
                case 3 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> opcionInvalida();
            }
        }
    }

    private void registrarClienteUI() {
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
        Cliente cliente = banco.registrarCliente(userName, userId, DOB, userOcc, userAdd, userPw, userEmail);
        System.out.println("Usuario registrado: " + cliente);
    }

    private void listarClientesUI() {
        List<Cliente> clientes = banco.ListarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c.getId() + " - " + c.getNombre());
        }
    }

    private void verClienteUI() {
        String id = textInput("Ingrese el Id del cliente:");
        Cliente c = banco.idLookup(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        //El programa entra en un proceso de autenticación
        //Si se excedieron la cantidad de intentos y no se ingresó el pw correct
        //se devuelve al menú principal
        if (!autenticacarCliente(c)) {
            System.out.println("Máximo de intentos alcanzado. Regresando al menú.");
            return;
        }

        boolean volver = false;
        while (!volver) {
            List<Cuenta> cuentas = c.getCuentas();
            boolean tieneCuentas = !cuentas.isEmpty();
            System.out.println("\n====Bienvenido " + c.getNombre() + " ====");
            System.out.println("1) Abrir Cuenta");
            if (tieneCuentas) {
                System.out.println("2) Ver cuentas");
                System.out.println("3) Realizar una transacción");
            }
            System.out.println("0) Volver");
            System.out.println("Seleccione:");
            int op = leerEntero();

            switch (op) {
                case 1 -> {abrirCuentaUI();
                }
                case 2 -> {
                    if (tieneCuentas) {
                        mostrarCuentas(cuentas);
                    } else {
                        opcionInvalida();
                    }
                }
                case 3 -> {
                    if (tieneCuentas) {
                        //transacciones
                    } else {
                        opcionInvalida();
                    }
                }
                case 0 -> {
                    volver = true;
                    System.out.println("Regresando a menú.");
                }
                default -> opcionInvalida();
            }
        }
    }

    private void abrirCuentaUI(){
        //hay que pedirle al cliente: int tipoCuenta, double saldo

    }

    private void mostrarCuentas(List<Cuenta> cuentas) {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    private void opcionInvalida() {
        System.out.println("Opción inválida.");
    }

    public boolean autenticacarCliente(Cliente c) {
        int attempts = 0;
        boolean pwMatch = false;

        while (attempts < 3) {
            String pwAttempt = textInput("Ingrese contraseña:");
            if (c.getPassword().equals(pwAttempt)) {
                pwMatch = true;
                break;
            }
            attempts++;
            System.out.println("Contraseña incorrecto. Intentos restantes: " +
                    (3 - attempts));
        }
        return pwMatch;
    }


    //lectores
    private String textInput(String p) {
        while (true) {
            System.out.println(p);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Por favor ingrese un valor.");
        }
    }

    private int userInputINT(String p) {
        while (true) {
            System.out.print(p);

            try {
                String input = sc.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private int leerEntero() {
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

}

