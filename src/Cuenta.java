public abstract class Cuenta {

    protected double saldo;
    protected double tasa;
    protected String id;

    public Cuenta(double saldo, double tasa, String id) {
        this.saldo = saldo;
        this.tasa = tasa;
    }

    //getters
    public double getSaldo() {
        return saldo;
    }

    public double getTasa(){
        return tasa;
    }

    public String getId(){
        return id;
    }

    //setters
    public void setTasa(double tasa){
        this.tasa = tasa;
    }

    //metodos
    public void retirar(double retiro){
        this.saldo = saldo - retiro;
    }

    public void generarIntereses() {
        this.saldo = saldo + saldo * tasa;
    }

}
