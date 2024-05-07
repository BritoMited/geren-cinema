package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sessao {
    private Filme filme; // Filme da sessão
    private LocalDateTime horario; // Horário da sessão
    private Double valor; // Valor do ingresso para a sessão
    private List<Cadeira> cadeiras; // Lista de cadeiras na sessão
    private List<Ingresso> ingressos = new ArrayList<>(); // Lista de ingressos vendidos para a sessão
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

    // Construtor
    public Sessao(Filme filme, LocalDateTime horario, Double preço) {
        this.filme = filme;
        this.horario = horario;
        this.valor = preço;
    }

    // Métodos getters e setters
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Cadeira> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(List<Cadeira> cadeiras) {
        this.cadeiras = cadeiras;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    // Adiciona um ingresso à lista de ingressos vendidos para a sessão
    public void addIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    // Remove um ingresso da lista de ingressos vendidos para a sessão com base no UUID
    public void removeIngresso(UUID id){
        for(Ingresso i: ingressos){
            if(i.getId().equals(id)){
                ingressos.remove(i);
                return;
            }
        }
        System.out.println("Não encontrado");

    }
    //Procurar Ingresso pelo ID
    public Ingresso findIngresso(UUID id){
        Ingresso u = null;
        for(Ingresso i: ingressos){
            if(i.getId().equals(id)){
               u = i;
            }
        }
        return u;
    }

    // Calcula e retorna o total vendido em ingressos para a sessão
    public Double vendaIngressos(){
        double sum = 0;
        for(Ingresso i: getIngressos()) {
            sum += i.getValor();
        }
        return sum;
    }

    // Adiciona uma cadeira à lista de cadeiras na sessão
    public void addCadeira(String numero){
        cadeiras.add(new Cadeira(numero));
    }

    // Gera e retorna uma lista de cadeiras para a sessão com base no número de linhas e assentos por linha
    public List<Cadeira> gerarCadeiras(int numLinhas, int assentosPorLinha) {
        this.cadeiras = new ArrayList<>();

        for (char row = 'A'; row < 'A' + numLinhas; row++) {
            for (int num = 1; num <= assentosPorLinha; num++) {
                cadeiras.add(new Cadeira(String.valueOf(row) + num));
            }
        }

        return cadeiras;
    }

    // Lista as cadeiras na sessão
    public void listarCadeiras(){
        int i = 0;
        System.out.println("--------------------------------------");
        for(Cadeira c: getCadeiras()) {
            System.out.print(c + " ");
            i++;
            if(i % 8 == 0) System.out.println();
            i-=8;
        }
        System.out.println("--------------------------------------");
    }

    // Lista os ingressos vendidos para a sessão
    public void listarIngressos(){
        for(Ingresso i: getIngressos()) {
            System.out.print(i);
            System.out.println();
        }
    }

    // Verifica se uma cadeira está disponível
    public Boolean isDisponivel(String cadeira){
        for(Cadeira c: getCadeiras()) {
            if(cadeira.equals(c.getNumero()) && c.getOcupado()){
                return true;
            }
        }
        return false;
    }

    // Ocupa uma cadeira na sessão
    public void ocupar(String cadeira){
        for(Cadeira c: getCadeiras()) {
            if(cadeira.equals(c.getNumero())){
                c.ocupar();
            }
        }
    }

    // Sobrescrita do método toString para representação textual da sessão
    @Override
    public String toString() {
        return
                 filme +
                ", horario:" + horario.format(dtf) +
                ", valor: " + valor;
    }
}
