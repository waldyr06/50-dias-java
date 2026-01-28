package semana_2;

public class Tarefa {

    private static int contador = 0;

    private int id;
    private String titulo;
    private String status;

    public Tarefa(String titulo) {
        this.id = ++contador;
        this.titulo = titulo;
        this.status = "Pendente";
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString(){
        return id + " - " + titulo + " - " + status;
    }
}
