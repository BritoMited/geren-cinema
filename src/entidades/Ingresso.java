package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Ingresso {

    private UUID id;
    private Filme filme;
    private Cadeira cadeira;
    private LocalDateTime horario;
    private Double valor;
    private Cliente cliente;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

    public Ingresso(Filme filme, Cadeira cadeira, LocalDateTime horario, Double valor, Cliente cliente) {
        this.id = UUID.randomUUID();
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

    public UUID getId() {
        return id;

    }
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getCadeira() {
        return cadeira.getNumero();
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


    @Override
    public String toString() {
        return "Ingresso" +
                " id: " + id +
                "| Filme: " + filme +
                "| Horário: " + horario.format(dtf) +
                "| Valor: R$ " + valor +
                  " " +  cliente;
    }
}
