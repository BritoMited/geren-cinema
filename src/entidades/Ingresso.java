package entidades;

public class Ingresso {
    private Double preco;
    private Cadeiras cadeira;
    private Cliente cliente;

    public Ingresso(Double preco, Cadeiras cadeira, Cliente cliente) {
        if(cliente.getIdade() < 18 || cliente.getEstudante() == true){
            this.preco = preco/2;
        }else{
            this.preco = preco;
        }

        this.cadeira = cadeira;
        this.cliente = cliente;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Cadeiras getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeiras cadeira) {
        this.cadeira = cadeira;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "preco=" + preco +
                '}';
    }
    // preco vai receber um metodo que calcula preço
}
