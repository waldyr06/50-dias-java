package semana_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        boolean rodando = true;

        while (rodando == true){
            System.out.println("=======================");
            System.out.println("___---___To-Do___---___");
            System.out.println("=======================");
            System.out.println("1 - Adicionar tarefa.");
            System.out.println("2 - Listar tarefas.");
            System.out.println("3 - Atualizar tarefas.");
            System.out.println("4 - Busque uma tarefa.");
            System.out.println("5 - Remover tarefa.");
            System.out.println("6 - Encerrar programa.");
            System.out.println("=======================");
            System.out.println("");

            int escolha = 0;
            System.out.print("Escolha sua opção: ");
            try {
                escolha = teclado.nextInt();
            }catch (InputMismatchException e){
                System.out.println("ERRO de entrada. Digite apenas números aqui!!!");
                teclado.nextLine();
            }
            teclado.nextLine();

            switch (escolha){
                case 1 -> {
                    String titulo;
                    while (true) {
                        System.out.print("Digite o título da tarefa: ");
                        titulo = teclado.nextLine().trim();
                        if (titulo.isEmpty()) {
                            System.out.println("ERRO: Não deixe em branco!");
                            continue;
                        }
                        break;
                    }
                    gerenciador.adicionarTarefa(titulo);
                    System.out.println("");
                }

                case 2 -> {
                    gerenciador.listarTarefas();
                    System.out.println("");
                }

                case 3 -> {
                    int codigo = 0;
                    while (true){
                        try {
                            System.out.print("Digite  o ID da tarefa: ");
                            codigo = teclado.nextInt();
                            teclado.nextLine();
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("ERRO de entrada. Digite apenas números aqui!!!");
                            teclado.nextLine();
                        }
                    }
                    gerenciador.atualizarTarefa(codigo);
                }

                case 4 -> {
                    int codigo = 0;
                    System.out.print("Digite o ID da tarefa: ");
                    while (true){
                        try {
                            codigo = teclado.nextInt();
                            teclado.nextLine();
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("ERRO de entrada. Digite apenas números aqui!!!");
                            teclado.nextLine();
                        }
                    }
                    gerenciador.buscarTarefas(codigo);
                }

                case 5 -> {
                    int codigo = 0;
                    System.out.print("Digite o ID da tarefa: ");
                    while (true){
                        try {
                            codigo =  teclado.nextInt();
                            teclado.nextLine();
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("ERRO de entrada. Digite apenas números aqui!!!");
                            teclado.nextLine();
                        }
                    }
                    gerenciador.removerTarefa(codigo);
                }

                case 6 -> {
                    System.out.println("Encerrando...");
                    rodando = false;
                }
            }
        }
    }
}