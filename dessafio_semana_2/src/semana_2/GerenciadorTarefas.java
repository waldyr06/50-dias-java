package semana_2;

import java.util.ArrayList;

public class GerenciadorTarefas {

    private ArrayList<Tarefa> listaTarefa = new ArrayList<>();

    public void adicionarTarefa(String titulo){
        Tarefa novaTarefa = new Tarefa(titulo);
        listaTarefa.add(novaTarefa);
    }


    public void listarTarefas(){
        if(listaTarefa.isEmpty()){
            System.out.println("Lista vazia :/");
        }
        listaTarefa.forEach(Tarefa ->{
            toString();
        });
    }

    public void buscarTarefas(){

    }

    public void removerTarefa(){

    }

    public void atualizarTarefa(){

    }
}
