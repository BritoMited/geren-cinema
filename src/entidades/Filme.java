package entidades;

public class Filme {
    private String genero;
    private String titulo;

    public Filme(String genero, String titulo) {
        this.genero = genero;
        this.titulo = titulo;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
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
