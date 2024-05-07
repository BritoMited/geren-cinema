package entidades;

public class Cadeira {
    private String numero; // Número da cadeira
    private Boolean ocupado; // Indica se a cadeira está ocupada ou não

    // Construtor
    public Cadeira(String numero) {
        this.numero = numero;
        this.ocupado = false; // Inicialmente, a cadeira está desocupada
    }

    // Métodos getters e setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    // Método para ocupar a cadeira
    public void ocupar() {
        this.ocupado = true;
    }

    // Sobrescrita do método toString para representação textual da cadeira
    @Override
    public String toString() {
        return numero + " [" + ocupado + "]"; // Retorna o número da cadeira seguido de sua condição de ocupação
    }
}
