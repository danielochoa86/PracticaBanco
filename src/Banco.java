import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Cliente> clientes = new ArrayList<>();
    private int cuenta_id = 1;

    public Cliente registrarCliente(String nombre, String id, LocalDate DOB, String ocupacion,
                            String residencia, String password, String email){
        Cliente cliente = new Cliente(nombre,id,DOB,ocupacion,residencia,password,email);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> ListarClientes() {
        return List.copyOf(clientes);
    }

    public Cliente idLookup(String id){
        for (Cliente c : clientes){
            if (c.getId().equals(id)) return c;
        }
        return  null;
    }

    private void abrirCuenta(Cliente cliente, int tipoCuenta, double saldo) {
        double tasa =
                switch (tipoCuenta){
                    case 1 -> 0.1;
                    case 2 -> 0.01;
                    case 3 -> 0.02;
                    default -> throw new IllegalArgumentException("Opción inválida");
                };
        String acc_id = generarCuentaId(tipoCuenta);
        Cuenta cuenta = CuentaFactory.crearCuenta(tipoCuenta,acc_id,saldo,tasa);
        cliente.addCuentas(cuenta);
    }

    private String generarCuentaId(int tipoCuenta){
        return switch (tipoCuenta){
            case 1 -> String.format("AHO-%04d", cuenta_id++);
            case 2 -> String.format("DEB-%04d", cuenta_id++);
            case 3 -> String.format("CRE-%04d", cuenta_id++);
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


}
