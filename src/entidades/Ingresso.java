package entidades;

import java.time.LocalDateTime;

public class Ingresso {
    private Filme filme;
    private Cadeira cadeira;
    private LocalDateTime horario;
    private Double valor;
    private Cliente cliente;

    public Ingresso(Filme filme, Cadeira cadeira, LocalDateTime horario, Double valor, Cliente cliente) {
        this.filme = filme;
        this.cadeira = cadeira;
        this.horario = horario;
        this.cliente = cliente;
        if(cliente.getIdade() < 18 || cliente.getEstudante()){
            this.valor = valor/2;
        }else{
            this.valor = valor;
        }

    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
