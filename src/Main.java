import entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        String cc = "12/04/24 19:30";
        LocalDateTime horario = LocalDateTime.parse(cc, dtf);



        Filme filme = new Filme("interestelas", "acao");
        Cliente cliente = new Cliente(18, true);
        Cliente cliente2 = new Cliente(18, false);
        Cadeira cadeira = new Cadeira("A7");
        Cadeira cadeira2 = new Cadeira("A6");


        Sessao sessao = new Sessao(filme, horario, 20.00);
        sessao.gerarCadeiras(8, 8);
        sessao.listarCadeiras();

        Ingresso ingresso = new Ingresso(sessao.getFilme(),cadeira, sessao.getHorario(), sessao.getValor(), cliente);
        Ingresso ingresso2 = new Ingresso(sessao.getFilme(),cadeira2, sessao.getHorario(), sessao.getValor(), cliente2);

        sessao.ocupar(ingresso.getCadeira());
        sessao.ocupar(ingresso2.getCadeira());

        System.out.println();
        sessao.listarCadeiras();

        sessao.addIngresso(ingresso);
        sessao.addIngresso(ingresso2);

        System.out.println(ingresso);
        System.out.println(ingresso2);

        System.out.println(sessao.vendaIngressos());

        sessao.listarIngressos();


//        do{
//            System.out.println("[1] - CLIENTE");
//            System.out.println("[2] - ADM");
//            System.out.println("[4] - SAIR");
//            op = sc.nextInt();
//            switch (op){
//                case 1:
//                    do{
//                        System.out.println("[1] - LISTAR CADEIRAS DISPONIVEIS");
//                        System.out.println("[2] - COMPRAR INGRESSO");
//                        System.out.println("[3] - IMPRIMIR INGRESSO");
//                        System.out.println("[5] - SAIR");
//                        op = sc.nextInt();
//                            switch (op){
//                                case 1:
//                                    System.out.println("listando...");
//                                    break;
//                                case 2:
//                                    System.out.println("comprando...");
//                                    break;
//                                case 3:
//                                    System.out.println("imprimindo...");
//                                    break;
//                                case 4:
//                                    System.out.println("saindo...");
//                                    break;
//                                default:
//                                    System.out.println("funcao invalida");
//                                    break;
//                            }
//
//                    }while(op != 5);
//                    break;
//                case 2:
//                    System.out.println("ADM");
//                    do{
//                        System.out.println("[1] - CRIAR SESSAO");
//                        System.out.println("[2] - LISTAR INGRESSOS E TOTAL VENDIDO");
//                        System.out.println("[5] - SAIR");
//                        op = sc.nextInt();
//                            switch (op){
//                                case 1:
//                                    System.out.println("listando...");
//                                    break;
//                                case 2:
//                                    System.out.println("comprando...");
//                                    break;
//                                default:
//                                    System.out.println("funcao invalida");
//                                    break;
//                            }
//
//                    }while(op != 5);
//                    break;
//                case 4:
//                    System.out.println("saindo...");
//                    break;
//                default:
//                    System.out.println("valor invalido");
//                    break;
//            }
//
//        }while(op != 4);



    }
}