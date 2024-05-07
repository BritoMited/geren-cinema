// Importação das bibliotecas necessárias
import entidades.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;



public class Main {

    static final String caminhoIngresso = "C:\\Estudosjava\\geren-cinema\\src\\Ingressos\\IngressoCliente";

    static final String caminhoIngressoADM = "C:\\Estudosjava\\geren-cinema\\src\\Ingressos\\IngressoADM";
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in); // Inicialização do Scanner para entrada de dados
        int op; // Variável para armazenar a opção do menu
        int n = 0; // Variável para armazenar o número da sessão selecionada
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"); // Formato para data e hora
        String cc = "12/04/24 19:30"; // String representando a data e hora de uma sessão
        LocalDateTime horario = LocalDateTime.parse(cc, dtf); // Conversão da string para LocalDateTime

        // Inicialização de um array de Sessao com tamanho 13
        Sessao[] sessoes = new Sessao[13];

        // Criação de objetos Filme, Cliente e Cadeira
        Filme filme = new Filme("interestelas", "acao");
        Cliente cliente = new Cliente(18, true);
        Cliente cliente2 = new Cliente(18, false);
        Cadeira cadeira = new Cadeira("A7");
        Cadeira cadeira2 = new Cadeira("A6");

        // Criação de uma sessão e configuração das cadeiras
        sessoes[0] = new Sessao(filme, horario, 20.00);
        sessoes[0].gerarCadeiras(8, 8);

        // Criação de ingressos e ocupação de cadeiras na sessão
        Ingresso ingresso = new Ingresso(sessoes[0].getFilme(), cadeira, sessoes[0].getHorario(), sessoes[0].getValor(), cliente);
        Ingresso ingresso2 = new Ingresso(sessoes[0].getFilme(), cadeira2, sessoes[0].getHorario(), sessoes[0].getValor(), cliente2);
        sessoes[0].ocupar(ingresso.getCadeira());
        sessoes[0].ocupar(ingresso2.getCadeira());

        // Adição dos ingressos à sessão e exibição dos ingressos vendidos
        sessoes[0].addIngresso(ingresso);
        sessoes[0].addIngresso(ingresso2);

        // Menu principal
        do {
            System.out.println("[1] - CLIENTE");
            System.out.println("[2] - ADM");
            System.out.println("[4] - SAIR");
            op = sc.nextInt();
            switch (op) {
                // Opções para o cliente
                case 1:
                    do {
                        System.out.println("[0] - LISTAR SESSÕES DISPONIVEIS");
                        System.out.println("[1] - LISTAR CADEIRAS DISPONIVEIS");
                        System.out.println("[2] - COMPRAR INGRESSO");
                        System.out.println("[3] - REMBOLSAR INGRESSO");
                        System.out.println("[4] - IMPRIMIR INGRESSO");
                        System.out.println("[5] - VERIFICAR INGRESSO");
                        System.out.println("[6] - SAIR");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op) {
                            case 0:
                                //listar sessões não nulas
                                // Listar informações da sessão selecionada
                                for (int i = 0; i < sessoes.length; i++) {
                                    if(sessoes[i] != null){
                                        System.out.println("Numero da sala ["+i+"]" + sessoes[i]);
                                    }
                                }
                                System.out.println("Digite o número da sala desejada: ");
                                n = sc.nextInt();
                                break;
                            case 1:
                                // Listar cadeiras disponíveis na sessão selecionada
                                System.out.println("listando...");
                                sessoes[n].listarCadeiras();
                                break;
                            case 2:
                                // Comprar ingressos para a sessão selecionada
                                System.out.println("Quantidade de ingressos");
                                int quant = sc.nextInt();
                                for (int i = 0; i < quant; i++) {
                                    sc.nextLine();
                                    System.out.println("Qual cadeira deseja?");
                                    String numeroCadeira = sc.nextLine();
                                    numeroCadeira = numeroCadeira.toUpperCase();
                                    // Verificação da disponibilidade da cadeira
                                    while (sessoes[n].isDisponivel(numeroCadeira)) {
                                        System.out.println("Cadeira indisponivel, escolha outra:");
                                        numeroCadeira = sc.nextLine();
                                        numeroCadeira = numeroCadeira.toUpperCase();
                                    }
                                    // Informações do cliente
                                    System.out.println("Estudante: (true / false)");
                                    boolean estudante = sc.nextBoolean();
                                    System.out.println("Sua idade");
                                    int idade = sc.nextInt();
                                    // Adição do ingresso à sessão e marcação da cadeira como ocupada
                                    Ingresso ingressoVer = new Ingresso(sessoes[n].getFilme(), new Cadeira(numeroCadeira), sessoes[n].getHorario(), sessoes[n].getValor(), new Cliente(idade, estudante));
                                    sessoes[n].addIngresso(ingressoVer);
                                    sessoes[n].ocupar(numeroCadeira);

                                    sessoes[n].findIngresso(ingressoVer.getId());
                                    System.out.println(ingressoVer);
                                }
                                break;
                            case 3:
                                // Rembolsar ingresso
                                sc.nextLine();
                                sessoes[n].listarIngressos();
                                System.out.println("Digite o UUID:");
                                String uuidString = sc.nextLine();
                                UUID uuid = UUID.fromString(uuidString);
                                sessoes[n].removeIngresso(uuid);
                                sessoes[n].listarIngressos();
                                break;
                            case 4:
                                // Imprimir ingresso
                                System.out.println("imprimindo...");
                                FileManager fileManager = new FileManager();
                                File diretorio = fileManager.criarPasta(caminhoIngresso);
                                System.out.println("Digite o UUID:");
                                String uuidString_ = sc.nextLine();
                                UUID uuid_ = UUID.fromString(uuidString_);
                                sessoes[n].findIngresso(uuid_);
                                File arquivo = fileManager.criarArquivo(diretorio, sessoes[n].findIngresso(uuid_). getId().toString() + ".txt");
                                fileManager.gravarDados(arquivo,sessoes[n].findIngresso(uuid_));
                                break;

                            case 5:
                                //procurar ingresso pelo ID
                                System.out.println("Digite o UUID:");
                                String uuidString__ = sc.nextLine();
                                UUID uuid__ = UUID.fromString(uuidString__);
                                System.out.println(sessoes[n].findIngresso(uuid__));

                                break;
                            case 6:
                                // Sair do menu de cliente
                                System.out.println("saindo...");
                                break;
                            default:
                                System.out.println("funcao invalida");
                                break;
                        }
                    } while (op != 6);
                    break;
                case 2:
                    // Opções para o administrador
                    System.out.println("ADM");
                    do {
                        System.out.println("[1] - CRIAR SESSAO");
                        System.out.println("[2] - LISTAR INGRESSOS E TOTAL VENDIDO");
                        System.out.println("[3] - IMPRIMIR INGRESSOS");
                        System.out.println("[5] - SAIR");
                        op = sc.nextInt();
                        switch (op) {
                            case 1:
                                // Criar nova sessão
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
                                // Adicionar nova sessão ao array de sessões
                                sessoes[n] = new Sessao(new Filme(nomeFilme, generoFilme), horarioSessao, precoSessao);
                                sessoes[n].gerarCadeiras(8, 8);
                                break;
                            case 2:
                                // Listar ingressos vendidos e total vendido
                                System.out.println("[2] - LISTAR INGRESSOS E TOTAL VENDIDO");
                                sessoes[n].listarIngressos();
                                System.out.println();
                                System.out.println("Total de vendas: R$" + sessoes[n].vendaIngressos());
                                break;
                            case 3:
                                //imprimindo todos os ingressos vendidos
                                System.out.println("[2] - IMPRIMINDO TODOS OS INGRESSOS VENDIDOS");
                                FileManager fileManager = new FileManager();
                                File diretorio = fileManager.criarPasta(caminhoIngressoADM);
                                File arquivo = fileManager.criarArquivo(diretorio,  "IngressosADM.txt");
                                arquivo.delete();
                                for(Ingresso i : sessoes[n].getIngressos()){
                                    fileManager.gravarDados(arquivo, i);
                                }
                                break;
                            case 5 :
                                System.out.println("Saindo...");
                                break;
                            default:
                                System.out.println("Numero Invalido");
                                break;
                        }
                    } while (op != 5);
                    break;
                case 4:
                    // Sair do programa
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("valor invalido");
                    break;
            }
        } while (op != 4);
    }
}