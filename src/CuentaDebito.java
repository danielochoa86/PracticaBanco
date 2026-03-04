public class CuentaDebito extends Cuenta{

    public CuentaDebito(double saldo, double tasa, String id) {
        super(saldo, tasa, id);
    }

    //metodos
    public void depositar(double deposito){
        this.saldo = saldo + deposito;
    }

    public void retirar(double retiro){
        double newsaldo =this.saldo - retiro;
        if ( newsaldo >= 0){
            System.out.println("No puede retirar porque su saldo quedaría en negativos.");
        }else {
            this.saldo = newsaldo;
        }
    }
}
