package semana_2;

import java.util.ArrayList;

public class GerenciadorTarefas {

    private ArrayList<Tarefa> listaTarefa = new ArrayList<>();

    public void adicionarTarefa(String titulo){
        if (titulo.isEmpty() || titulo.isBlank()){
            System.out.println("TÍTULO INVÁLIDO, DIGITE UM TÍTULO!!!");
            return;
        }
        Tarefa novaTarefa = new Tarefa(titulo);
        listaTarefa.add(novaTarefa);
    }


    public void listarTarefas(){
        if(listaTarefa.isEmpty()){
            System.out.println("NÃO É POSSÍVEL ACESSAR UMA LISTA VAZIA :/");
        }
        listaTarefa.forEach(Tarefa ->{
            System.out.println(Tarefa.toString());
        });
    }

    public Tarefa buscarTarefas(int id){
        for(Tarefa tarefa : listaTarefa){
            if (tarefa.getId() == id){
                //System.out.println(tarefa.toString());
                return tarefa;
            }
        }
        System.out.println("ERRO: Esse ID não existe.");
        return null;
    }

    public void removerTarefa(int id){
        Tarefa tarefa = buscarTarefas(id);
        if (tarefa == null){
            //System.out.println("ERRO: Esse ID não existe");
            return;
        }
        if (tarefa != null){
            listaTarefa.remove(tarefa);
            System.out.println("Removido com sucesso!!!");
        }
        else{
            System.out.println("Tarefa inexistente. Você digitou um id que não existe :/.");
        }
    }

    public void atualizarTarefa(int id){
        Tarefa tarefa = buscarTarefas(id);
        if (tarefa == null){
            //System.out.println("ERRO: Esse ID não existe");
            return;
        }
        if (tarefa != null){
            tarefa.setStatus("Concluido");
            System.out.println("Atualizado com sucesso!!!");
        }
        else{
            System.out.println("Tarefa inexistente. Você digitou um id que não existe :/.");
        }
    }
    public void atualizarTitulo(int id, String novoTitulo){
        Tarefa tarefa = buscarTarefas(id);
        if (tarefa == null){
            return;
        }
        if (tarefa != null){
            tarefa.setTitulo(novoTitulo);
            System.out.println("Atualizado o título com sucesso.");
        }
        else{
            System.out.println("Tarefa inexistente. Você digitou um id que não existe :/.");
        }
    }
}