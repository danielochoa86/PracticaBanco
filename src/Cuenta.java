public abstract class Cuenta {

    protected double saldo;
    protected double tasa;
    public int id;

    public Cuenta(double saldo, double tasa, int id) {
        this.saldo = saldo;
        this.tasa = tasa;
        this.id = id;
    }

    //getters
    public double getSaldo() {
        return saldo;
    }

    public double getTasa(){
        return tasa;
    }

    public int getId(){
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
