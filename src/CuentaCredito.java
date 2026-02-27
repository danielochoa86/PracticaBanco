public class CuentaCredito extends Cuenta{

    public CuentaCredito(double saldo, double tasa, int id) {
       super(0, tasa, id);
    }

    //metodos
    public void abonar(double abono){
        this.saldo = saldo + abono;
    }





}
