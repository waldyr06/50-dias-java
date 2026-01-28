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
            System.out.println(Tarefa.toString());
        });
    }

    public Tarefa buscarTarefas(int id){
        for(Tarefa tarefa : listaTarefa){
            if (tarefa.getId() == id){
                return tarefa;
            }
        }
        return null;
    }

    public void removerTarefa(int id){
        Tarefa tarefa = buscarTarefas(id);
        if (tarefa != null){
            listaTarefa.remove(tarefa);
        }
        else{
            System.out.println("Tarefa inexistente. Você digitou um id que não temos na memória.");
        }
    }

    public void atualizarTarefa(int id){
        Tarefa tarefa = buscarTarefas(id);
        if (tarefa != null){
            System.out.println("Tarefa inexistente. Você digitou um id que não temos na memória.");
        }
        else{
            tarefa.setStatus("Concluido");
        }
    }
}
