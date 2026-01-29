package semana_2;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        boolean rodando = true;

        while (rodando == true){
            System.out.println("___---___To-Do___---___");
            System.out.println("1 - Adicionar tarefa.");
            System.out.println("2 - Listar tarefas.");
            System.out.println("3 - Atualizar tarefas.");
            System.out.println("4 - Remover tarefa.");
            System.out.println("5 - Encerrar programa.");

            int escolha;
            System.out.println("Escolha sua opção: ");
            escolha = teclado.nextInt();
            teclado.nextLine();

            switch (escolha){
                case 1 -> {
                    System.out.println("Digite o titulo da tarefa: ");
                    String titulo = teclado.nextLine();

                    gerenciador.adicionarTarefa(titulo);

                }

                case 2 -> {
                    gerenciador.listarTarefas();
                }

                case 3 -> {
                    System.out.println("Digite  o ID da tarefa: ");
                    int codigo = teclado.nextInt();

                    gerenciador.atualizarTarefa(codigo);
                }

                case 4 -> {
                    System.out.println("Digite o ID da tarefa: ");
                    int codigo =  teclado.nextInt();

                    gerenciador.removerTarefa(codigo);
                }

                case 5 -> {
                    System.out.println("Encerrando...");
                    rodando = false;
                }
                default -> {
                    System.out.println("Opção errada padrão, essa dai não existe viu");
                }
            }
        }
    }
}