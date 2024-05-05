package entidades;

public class Cadeira {
    private String numero;
    private Boolean ocupado;

    public Cadeira(String numero) {
        this.numero = numero;
        this.ocupado = false;
    }

    // get set
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getOcupado() {
        return ocupado;
    }
    // metodos

    public void ocupar() {
        this.ocupado = true;
    }

    @Override
    public String toString() {
        return numero + " " +  ocupado;
    }
    
}
