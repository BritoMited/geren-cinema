import entidades.*;

public class Main {
    public static void main(String[] args) {

        Ingresso ingresso = new Ingresso(20.00, new Cadeiras("A2", true), new Cliente(18, true));
        Ingresso ingresso3 = new Ingresso(20.00, new Cadeiras("A3", true), new Cliente(17, true));
        Ingresso ingresso4 = new Ingresso(20.00, new Cadeiras("A4", true), new Cliente(18, false));
        Ingresso ingresso5 = new Ingresso(20.00, new Cadeiras("A5", true), new Cliente(28, false));
        Ingresso ingresso6 = new Ingresso(20.00, new Cadeiras("A6", true), new Cliente(18, true));


        Sessão sessão = new Sessão(new Filme("Ficção","Interestelar"));

        sessão.addIngresso(ingresso.getCadeira(), ingresso);
        sessão.addIngresso(ingresso3.getCadeira(), ingresso3);
        sessão.addIngresso(ingresso4.getCadeira(), ingresso4);
        sessão.addIngresso(ingresso5.getCadeira(), ingresso5);
        sessão.addIngresso(ingresso6.getCadeira(), ingresso6);


        System.out.println(sessão);
    }
}