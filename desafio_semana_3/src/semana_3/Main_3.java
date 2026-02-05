package semana_3;

import java.io.IOException;
import java.util.Scanner;

public class Main_3 {
    public static void main (String[] args) throws IOException, InterruptedException {

        Buscador buscando = new Buscador();
        ManualParser filtro = new ManualParser();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem vindo a API Rick an Morty...");

        boolean rodando = true;

        while (rodando == true){
            System.out.println("O que voce deseja na API Rick And Morty?.");
            System.out.println("1 - Pesquisa por Nome.");
            System.out.println("2 - Pesquisa po ID.");
            System.out.println("3 - Pesquisa por campos. Exemplo: Origem | Status |.");
            System.out.println("4 - Pesquisa aleatória 🎲.");
            System.out.println("5 - Paginação.");

            System.out.print("Digite a opção desejada: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao){
                case 1 ->{
                    System.out.print("Digite o nome que você quer procurar: ");
                    String nome = teclado.nextLine();
                    String json = buscando.buscarPorNome(nome);

                    String nomeEncontrado = filtro.pegarDados(json, "name");
                    System.out.println("Encontrado: "  + nomeEncontrado);
                }
            }
        }
    }
}