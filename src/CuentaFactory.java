public class CuentaFactory {

    public static Cuenta crearCuenta(int tipo, String id, double saldo, double tasa){
        return switch (tipo){
            case 1 -> new CuentaAhorros(saldo,tasa,id);
            case 2 -> new CuentaDebito(saldo,tasa,id);
            case 3 -> new CuentaCredito(saldo,tasa,id);
            default -> throw new IllegalArgumentException("Tipo de cuenta inválido");
        };
    }
}
