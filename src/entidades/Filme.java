package entidades;

public class Filme {
    private String genero;
    private String titulo;

    public Filme(String genero, String titulo) {
        this.genero = genero;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
