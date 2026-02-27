import java.util.ArrayList;

public class Banco {

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Banco(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }


}
