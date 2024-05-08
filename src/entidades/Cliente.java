package entidades;

public class Cliente {
    private Integer idade; // Idade do cliente
    private Boolean estudante; // Indica se o cliente é estudante ou não

    // Construtor
    public Cliente(Integer idade, Boolean estudante) {
        this.idade = idade;
        this.estudante = estudante;
    }

    // Métodos getters e setters
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

    // Sobrescrita do método toString para representação textual do cliente
    @Override
    public String toString() {
        return "idade: " + idade +
                ", estudante: " + estudante;
    }
}
