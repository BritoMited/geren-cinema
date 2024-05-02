package entidades;

public class Cadeiras {
    private String cadeira;

    public Cadeiras(String cadeira, Boolean ocupado) {
        this.cadeira = cadeira;
    }

    @Override
    public String toString() {
        return "Cadeiras{" +
                "cadeira='" + cadeira + '\'' +
                '}';
    }
}
