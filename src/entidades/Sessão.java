package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sessão {

    private Filme filme;
    LinkedHashMap<Cadeiras, Ingresso> ingressoList = new LinkedHashMap<>();

    public Sessão(Filme filme) {
        this.filme = filme;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void addIngresso (Cadeiras cadeiras, Ingresso ingresso){
        ingressoList.put(cadeiras,ingresso);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sessão{");
        sb.append("filme=").append(filme);
        sb.append(", ingressoList={");
        sb.append("\n");
        for (Map.Entry<Cadeiras, Ingresso> entry : ingressoList.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
            sb.append("\n");
        }
        if (!ingressoList.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove a vírgula extra e o espaço após o último item
        }
        sb.append("}}");
        sb.append("\n");
        return sb.toString();
    }
}
