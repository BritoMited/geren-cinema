package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sessao {
    private Filme filme;
    private LocalDateTime horario;
    //mudar para localdatetime
    private Double valor;
    List<Cadeira> cadeiras;
    List<Ingresso> ingressos = new ArrayList<>();

    public Sessao(Filme filme, LocalDateTime horario, Double preço) {
        this.filme = filme;
        this.horario = horario;
        this.valor = preço;
    }

    // metodos get set

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

    // funções
    public void addIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public Double vendaIngressos(){
        double sum = 0;
        for(Ingresso i: getIngressos()) {
            sum += i.getValor();
        }
        return sum;
    }

    public void addCadeira(String numero){
        cadeiras.add(new Cadeira(numero));
    }

    public List<Cadeira> gerarCadeiras(int numLinhas, int assentosPorLinha) {
        this.cadeiras = new ArrayList<>();

        for (char row = 'A'; row < 'A' + numLinhas; row++) {
            for (int num = 1; num <= assentosPorLinha; num++) {
                String nomeCadeira = String.valueOf(row) + num;
                Cadeira cadeira = new Cadeira(nomeCadeira);
                cadeiras.add(cadeira);
            }
        }

        return cadeiras;
    }

    public void listarCadeiras(){
        int i = 0;
        for(Cadeira c: getCadeiras()) {
            System.out.print(c + " ");
            i++;
            if(i % 8 == 0) System.out.println();
            i-=8;
        }
    }

    public void ocupar(Cadeira cadeira){
        for(Cadeira c: getCadeiras()) {
            if(cadeira.getNumero().equals(c.getNumero())){
                c.ocupar();
            }
        }
    }

}
