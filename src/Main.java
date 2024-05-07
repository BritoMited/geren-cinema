import entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        int n = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        String cc = "12/04/24 19:30";
        LocalDateTime horario = LocalDateTime.parse(cc, dtf);


        Sessao[] sessoes = new Sessao[13];

        Filme filme = new Filme("interestelas", "acao");
        Cliente cliente = new Cliente(18, true);
        Cliente cliente2 = new Cliente(18, false);
        Cadeira cadeira = new Cadeira("A7");
        Cadeira cadeira2 = new Cadeira("A6");


        sessoes[0] = new Sessao(filme, horario, 20.00);
        sessoes[0].gerarCadeiras(8, 8);
        sessoes[0].listarCadeiras();

        Ingresso ingresso = new Ingresso(sessoes[0].getFilme(),cadeira, sessoes[0].getHorario(), sessoes[0].getValor(), cliente);
        Ingresso ingresso2 = new Ingresso(sessoes[0].getFilme(),cadeira2, sessoes[0].getHorario(), sessoes[0].getValor(), cliente2);

        sessoes[0].ocupar(ingresso.getCadeira());
        sessoes[0].ocupar(ingresso2.getCadeira());

        System.out.println();
        sessoes[0].listarCadeiras();

        sessoes[0].addIngresso(ingresso);
        sessoes[0].addIngresso(ingresso2);

        System.out.println(ingresso);
        System.out.println(ingresso2);

        System.out.println(sessoes[0].vendaIngressos());

        sessoes[0].listarIngressos();


        do{
            System.out.println("[1] - CLIENTE");
            System.out.println("[2] - ADM");
            System.out.println("[4] - SAIR");
            op = sc.nextInt();
            switch (op){
                //Cliente
                case 1:
                    do{
                        System.out.println("[0] - LISTAR SESSÕES" );
                        System.out.println("[1] - LISTAR CADEIRAS DISPONIVEIS");
                        System.out.println("[2] - COMPRAR INGRESSO");
                        System.out.println("[3] - REMBOLSAR INGRESSO");
                        System.out.println("[4] - IMPRIMIR INGRESSO");
                        System.out.println("[6] - SAIR");
                        op = sc.nextInt();
                            switch (op){
                                case 0:
                                    System.out.println("Digite o número da sessão");
                                    n = sc.nextInt();
                                    System.out.println(sessoes[n]);
                                    break;
                                case 1:
                                    System.out.println("listando...");
                                    sessoes[n].listarCadeiras();
                                    break;
                                case 2:
                                    System.out.println("Quantidade de ingressos");
                                    int quant = sc.nextInt();

                                    for (int i = 0; i < quant; i++) {
                                        sc.nextLine();
                                        System.out.println("Qual cadeira deseja?");
                                        String numeroCadeira = sc.nextLine();

                                       while(sessoes[n].isDisponivel(numeroCadeira)){

                                           System.out.println("Cadeira indisponivel, escolha outra:");
                                           numeroCadeira = sc.nextLine();
                                        }
                                        System.out.println("Estudante: (true / false)");
                                        boolean estudante = false;
                                        String input = sc.nextLine().toLowerCase();
                                        if (input.equals("true")) {
                                            estudante = true;
                                        } else if (input.equals("false")) {
                                            estudante = false;
                                        }
                                        System.out.println("Sua idade");
                                        int idade = sc.nextInt();
                                        sessoes[n].addIngresso(new Ingresso(sessoes[n].getFilme(),new Cadeira(numeroCadeira), sessoes[n].getHorario(), sessoes[n].getValor(), new Cliente(idade,estudante)));
                                        sessoes[n].ocupar(numeroCadeira);
                                    }
                                    break;
                                case 3:
                                    sc.nextLine();
                                    sessoes[n].listarIngressos();
                                    System.out.println("Digite o UUID:");
                                    String uuidString = sc.nextLine();
                                    UUID uuid = UUID.fromString(uuidString);
                                    sessoes[n].removeIngresso(uuid);
                                    sessoes[n].listarIngressos();
                                    break;
                                case 4:
                                    System.out.println("imprimindo...");
                                    break;
                                case 6:
                                    System.out.println("saindo...");
                                    break;
                                default:
                                    System.out.println("funcao invalida");
                                    break;
                            }

                    }while(op != 5);
                    break;
                case 2:
                    System.out.println("ADM");
                    do{
                        System.out.println("[1] - CRIAR SESSAO");
                        System.out.println("[2] - LISTAR INGRESSOS E TOTAL VENDIDO");
                        System.out.println("[5] - SAIR");
                        op = sc.nextInt();
                            switch (op){
                                case 1:
                                    sc.nextLine();
                                    System.out.println("Digite o nome do filme");
                                    String nomeFilme = sc.nextLine();

                                    System.out.println("Digite o genero");
                                    String generoFilme = sc.nextLine();

                                    System.out.println("Digite o Horario da sessão, dd/MM/yy HH:mm");
                                    LocalDateTime horarioSessao = LocalDateTime.parse(sc.nextLine(), dtf);

                                    System.out.println("Digite o preço da sessão");
                                    Double precoSessao = sc.nextDouble();


                                    System.out.println("Digite o numero da sessão");
                                    n = sc.nextInt();

                                    sessoes[n] = new Sessao(new Filme(nomeFilme,generoFilme), horarioSessao,precoSessao);
                                    sessoes[n].gerarCadeiras(8,8);
                                    break;
                                case 2:
                                    System.out.println("comprando...");
                                    sessoes[n].listarIngressos();
                                    break;
                                default:
                                    System.out.println("funcao invalida");
                                    break;
                            }

                    }while(op != 5);
                    break;
                case 4:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("valor invalido");
                    break;
            }

        }while(op != 4);



    }
}