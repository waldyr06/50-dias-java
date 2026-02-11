package semana_3;

public class Personagem {

    private String id;
    private String nome;
    private String status;
    private String especie;
    private String origem;

    public Personagem(String id, String nome, String status, String especie) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.especie = especie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "🆔 " + id + " | 👤 " + nome + " | 💓 " + status + " | 👽 " + especie;
    }
}