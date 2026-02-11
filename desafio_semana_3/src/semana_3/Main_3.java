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

        System.out.println("================================");
        System.out.println("Bem vindo a API Rick an Morty...");

        boolean rodando = true;
        int paginaAtual = 1;

        while (rodando){

            System.out.println("================================");
            System.out.println("O que voce deseja na API Rick And Morty?.");
            System.out.println("================================");
            System.out.println("1 - Pesquisa por Nome.");
            System.out.println("2 - Pesquisa po ID.");
            System.out.println("3 - Pesquisa aleatória 🎲.");
            System.out.println("4 - Paginação.");
            System.out.println("0 - Sair.");
            System.out.println("================================");

            System.out.print("Digite a opção desejada: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.print("Digite o nome que você quer procurar: ");
                    String entrada = teclado.nextLine();
                    String json = buscando.buscarPorNome(entrada);

                    if (json == null){
                        System.out.println("❌ ERRO: Personagem não encontrado ou falha na conexão.");
                        System.out.println("Tente digitar o nome corretamente (ex: Rick).");
                        break;
                    }

                    System.out.println("================================");

                    List<String> nomes = filtro.pegarDados(json, "name");
                    List<String> status = filtro.pegarDados(json, "status");
                    List<String> ids = filtro.pegarIds(json);
                    List<String> species = filtro.pegarDados(json, "species");

                    System.out.println("--- ENCONTRADOS (" + (nomes.size() / 3) + ") ---");
                    for (int i = 0; i < nomes.size(); i += 3) {
                        int indiceDoId = i / 3;

                        if (indiceDoId < ids.size()) {
                            Personagem p = new Personagem(
                                    ids.get(indiceDoId),
                                    nomes.get(i),
                                    status.get(indiceDoId),
                                    species.get(indiceDoId)
                            );
                            System.out.println(p);
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Digite o id que você quer procurar: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    String json = buscando.buscarPorId(id);

                    if (json == null){
                        System.out.println("❌ ERRO: Personagem não encontrado ou falha na conexão.");
                        System.out.println("Tente digitar o nome corretamente (ex: Rick).");
                        break;
                    }
                    System.out.println("================================");

                    List<String> nome = filtro.pegarDados(json, "name");
                    List<String> status = filtro.pegarDados(json, "status");
                    List<String> ids = filtro.pegarIds(json);

                    String nomeAtual = nome.get(0);
                    String statusAtual = status.get(0);
                    String idAtual = ids.get(0);

                    if (!nomeAtual.isEmpty()) {
                        System.out.println("Encontrado!!!");
                        System.out.println("ID: " + idAtual + " | Nome: " + nomeAtual + " | Status: " + statusAtual);
                    } else {
                        System.out.println("ID não encontrado.");
                    }
                }

                case 3 -> {
                    System.out.println("Sorteando um personagem aleatório...");

                    int idAleatorio = sorteador.nextInt(826) + 1;
                    System.out.println("Id sorteado: " + idAleatorio);
                    System.out.println("================================");

                    String json = buscando.buscarPorId(idAleatorio);

                    if (json == null){
                        System.out.println("❌ ERRO: Personagem não encontrado ou falha na conexão.");
                        System.out.println("Tente digitar o nome corretamente (ex: Rick).");
                        break;
                    }

                    List<String> nomes = filtro.pegarDados(json, "name");
                    List<String> statusLista = filtro.pegarDados(json, "status");
                    List<String> especies = filtro.pegarDados(json, "species");
                    List<String> idAtual = filtro.pegarIds(json);

                    if (!nomes.isEmpty()) {
                        System.out.println("--- PERSONAGEM SORTEADO ---");
                        System.out.println("Id: " + idAtual.get(0));
                        System.out.println("Nome: " + nomes.get(0));
                        System.out.println("Status: " + statusLista.get(0));
                        System.out.println("Espécie: " + especies.get(0));
                    }
                }

                case 4 -> {
                    System.out.println("Buscando página " + paginaAtual + "...");
                    String json = buscando.buscarPagina(paginaAtual);

                    if (json == null){
                        System.out.println("❌ ERRO: Personagem não encontrado ou falha na conexão.");
                        System.out.println("Tente digitar o nome corretamente (ex: Rick).");
                        break;
                    }

                    List<String> nomes = filtro.pegarDados(json, "name");
                    List<String> status = filtro.pegarDados(json, "status");
                    List<String> ids = filtro.pegarIds(json);
                    List<String> species = filtro.pegarDados(json, "species");
                    System.out.println("================================");

                    System.out.println("--- PÁGINA " + paginaAtual + " ---");
                    for (int i = 0; i < nomes.size(); i += 3) {
                        int indiceDoId = i / 3;

                        if (indiceDoId < ids.size()) {
                            Personagem p = new Personagem(
                                    ids.get(indiceDoId),
                                    nomes.get(i),
                                    status.get(indiceDoId),
                                    species.get(indiceDoId)
                            );
                            System.out.println(p);
                        }
                    }
                    System.out.println("================================");

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