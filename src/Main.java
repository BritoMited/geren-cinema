import entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        String cc = "12/04/24 19:30";
        LocalDateTime horario = LocalDateTime.parse(cc, dtf);



        Filme filme = new Filme("interestelas", "acao");
        Cliente cliente = new Cliente(18, true);
        Cadeira cadeira = new Cadeira("A7");



        Sessao sessao = new Sessao(filme, horario, 20.00);
        sessao.gerarCadeiras(8, 8);
        sessao.listarCadeiras();

        Ingresso ingresso = new Ingresso(sessao.getFilme(),cadeira, sessao.getHorario(), sessao.getValor(), cliente);

        sessao.ocupar(ingresso.getCadeira());
        System.out.println();
        sessao.listarCadeiras();

    }
}