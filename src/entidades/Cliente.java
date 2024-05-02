package entidades;

public class Cliente {
    private Integer idade;
    private Boolean estudante;

    public Cliente(Integer idade, Boolean estudante) {
        this.idade = idade;
        this.estudante = estudante;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Boolean getEstudante() {
        return estudante;
    }

    public void setEstudante(Boolean estudante) {
        this.estudante = estudante;
    }
}
