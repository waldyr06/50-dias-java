package semana_3;

public class Personagem {

    private String nome;
    private String status;
    private String especie;
    private String origem;

    public Personagem(String nome, String origem){
        this.nome = nome;
        this.origem = origem;
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
    public String toString(){
        return "Nome: " + nome + "Status: " + status + "Especie: " + especie + "Origem: " + origem;
    }
}