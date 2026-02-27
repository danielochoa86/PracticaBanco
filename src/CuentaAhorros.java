public class CuentaAhorros extends Cuenta{

    public CuentaAhorros(double saldo, double tasa, int id) {
        super(saldo, tasa, id);
    }

    //metodo
    public void depositar(double deposito){
        this.saldo = saldo + deposito;
    }

    public void retirar(double retiro){
        double newsaldo =this.saldo - retiro;
        if ( newsaldo< 100){
            System.out.println("No puede retirar porque su saldo bajaría de $100");
            }else {
            this.saldo = newsaldo;
        }
    }
}
