package entidades;

public class Cadeiras {
    private String cadeira;

    public Cadeiras(String cadeira, Boolean ocupado) {
        this.cadeira = cadeira;
    }

    public String getCadeira() {
        return cadeira;
    }

    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
    }

    @Override
    public String toString() {
        return "Cadeiras{" +
                "cadeira='" + cadeira + '\'' +
                '}';
    }
}
