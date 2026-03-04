public class Main {

    public void main (String[] args){

        Banco banco = new Banco();
        Menu menu = new Menu(banco);
        menu.ejecutar();

    }

}
