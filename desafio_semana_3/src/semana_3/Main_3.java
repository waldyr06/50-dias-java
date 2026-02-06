package semana_3;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.List; // Não esqueça deste import!

public class Main_3 {
    public static void main (String[] args) throws IOException, InterruptedException {

        Buscador buscando = new Buscador();
        ManualParser filtro = new ManualParser();
        Scanner teclado = new Scanner(System.in);
        Random sorteador =  new Random();

        System.out.println("Bem vindo a API Rick an Morty...");

        boolean rodando = true;
        int paginaAtual = 1;

        while (rodando){

            System.out.println("\nO que voce deseja na API Rick And Morty?.");
            System.out.println("1 - Pesquisa por Nome.");
            System.out.println("2 - Pesquisa po ID.");
            System.out.println("3 - Pesquisa aleatória 🎲.");
            System.out.println("4 - Pesquisa por campos (Origem/Status).");
            System.out.println("5 - Paginação.");
            System.out.println("0 - Sair.");

            System.out.print("Digite a opção desejada: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.print("Digite o nome que você quer procurar: ");
                    String entrada = teclado.nextLine();
                    String json = buscando.buscarPorNome(entrada);

                    List<String> nomes = filtro.pegarDados(json, "name");

                    System.out.println("--- ENCONTRADOS (" + nomes.size() + ") ---");
                    for (String n : nomes) {
                        System.out.println("- " + n);
                    }
                }

                case 2 -> {
                    System.out.print("Digite o id que você quer procurar: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    String json = buscando.buscarPorId(id);

                    List<String> nomes = filtro.pegarDados(json, "name");
                    if (!nomes.isEmpty()) {
                        System.out.println("Encontrado: " + nomes.get(0));
                    } else {
                        System.out.println("ID não encontrado.");
                    }
                }

                case 3 -> {
                    System.out.println("Sorteando um personagem aleatório...");

                    int idAleatorio = sorteador.nextInt(826) + 1;
                    System.out.println("Id sorteado: " + idAleatorio);

                    String json = buscando.buscarPorId(idAleatorio);

                    List<String> nomes = filtro.pegarDados(json, "name");
                    List<String> statusLista = filtro.pegarDados(json, "status");
                    List<String> especies = filtro.pegarDados(json, "species");

                    if (!nomes.isEmpty()) {
                        System.out.println("--- PERSONAGEM SORTEADO ---");
                        System.out.println("Nome: " + nomes.get(0));
                        System.out.println("Status: " + statusLista.get(0));
                        System.out.println("Espécie: " + especies.get(0));
                    }
                }

                case 4 -> {
                    System.out.println("Digite 9 - Origem | 8 - Status");
                    int escolha = teclado.nextInt();

                    String json = buscando.buscarPorId(1);

                    if (escolha == 9){
                        List<String> nomes = filtro.pegarDados(json, "name");
                        String origem = filtro.pegarLocalizacao(json);

                        System.out.println("Resultado do Campo Origem: ");
                        if(!nomes.isEmpty()) System.out.println("Nome: " + nomes.get(0));
                        System.out.println("Origem: " + origem);
                    }

                    if (escolha == 8){
                        List<String> nomes = filtro.pegarDados(json, "name");
                        List<String> statusLista = filtro.pegarDados(json, "status");

                        System.out.println("Resultado do Campo Status: ");
                        if(!nomes.isEmpty()) {
                            System.out.println("Nome: " + nomes.get(0));
                            System.out.println("Status: " + statusLista.get(0));
                        }
                    }
                }

                case 5 -> {
                    System.out.println("Buscando página " + paginaAtual + "...");
                    String json = buscando.buscarPagina(paginaAtual);
                    List<String> nomesDaPagina = filtro.pegarDados(json, "name");

                    System.out.println("--- PÁGINA " + paginaAtual + " ---");
                    for (String nome : nomesDaPagina) {
                        System.out.println(nome);
                    }

                    System.out.println("\nDeseja ver a próxima página? s - Próxima | n - Voltar");
                    String escolha2 = teclado.next();

                    if (escolha2.equalsIgnoreCase("s")) {
                        paginaAtual++;
                    }
                }
                case 0 -> rodando = false;
            }
        }
    }
}