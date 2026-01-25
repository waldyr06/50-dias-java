package semana_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        AnaliseNumerica analise = new AnaliseNumerica();
        Scanner teclado = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------");
        System.out.println("Olá, você agora tem um programa para analisar uma lista de números!");

        boolean rodando = true;

        while (rodando == true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Você tem duas opções para analisar uma lista de números");
            System.out.println("------------------------------------------------------------------");
            System.out.println("1 - Crie uma lista ou acesse a lista atual");
            System.out.println("2 - Mande um arquivo .txt");
            System.out.println("------------------------------------------------------------------");
            System.out.println("0 - Encerrar o programa");
            System.out.println("------------------------------------------------------------------");

            int escolha = -1;
            try {
                escolha = teclado.nextInt();
                teclado.nextLine();

                if (escolha == 1) {
                    System.out.println("Escolhas: 1 - ADICIONAR NÚMERO / 2 - VISUALIZAR LISTA / " +
                            "3 - CALCULAR O TOTAL / 4 - CALCULAR A MÉDIA / 5 - ENCONTRE O MAIOR NUMERO / 6 - ENCONTRE O MENOR NUMERO");
                    System.out.println("------------------------------------------------------------------");

                    int escolha2 = teclado.nextInt();
                    switch (escolha2) {
                        case 1 -> {
                            System.out.print("Adicionando o número:  ");
                            double numero = teclado.nextDouble();
                            analise.adicionarNumero(numero);
                        }
                        case 2 -> {
                            System.out.println("Lista: ");
                            analise.visualizarLista();
                        }
                        case 3 -> {
                            System.out.println("A soma de todos os número é: ");
                            analise.calcularSoma();
                        }
                        case 4 -> {
                            System.out.println("Média dos números: ");
                            analise.calcularMedia();
                        }
                        case 5 -> {
                            System.out.println("Maior número encontrado: ");
                            analise.encontrarMaior();
                        }
                        case 6 -> {
                            System.out.println("Menor número encontrado ");
                            analise.encontrarMenor();
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Você digitou letras ou símbolos");
                System.out.println("Digite apenas números!");
                teclado.nextLine();
            }


            if (escolha == 2) {

                System.out.print("Digite o caminho do arquivo .txt: ");
                String caminho = teclado.nextLine();

                File arquivo = new File(caminho);

                try {
                    Scanner leitor = new Scanner(arquivo);

                    int contador = 0;
                    while (leitor.hasNext()) {
                        try {
                            String linha = leitor.next();
                            double valorConvertido = Double.parseDouble(linha);
                            analise.adicionarNumero(valorConvertido);
                        } catch (NumberFormatException e) {
                            contador++;
                        }
                    }

                    System.out.println("---------------------------");
                    System.out.println("Arquivo lido com sucesso!");
                    System.out.println("Essa foi a quantidade de palavras que detectamos no seu .txt");
                    System.out.printf(String.valueOf(contador));
                    System.out.println("");
                    System.out.println("---------------------------");
                    System.out.println("Aqui tá os números contidos nesse  .txt: ");
                    analise.visualizarLista();

                    System.out.println("Escolhas: 1 - ADICIONAR NúMERO / 2 - VISUALIZAR LISTA / " +
                            "3 - CALCULAR SOMAR / 4 - CALCULAR MÉDIA / 5 - MAIOR NUMERO / 6 - MENOR NUMERO");
                    System.out.println("------------------------------------------------------------------");

                    int escolha3 = teclado.nextInt();
                    switch (escolha3) {
                        case 1 -> {
                            System.out.print("Adicionando o número:  ");
                            double numero = teclado.nextDouble();
                            analise.adicionarNumero(numero);
                        }
                        case 2 -> {
                            System.out.println("Lista: ");
                            analise.visualizarLista();
                        }
                        case 3 -> {
                            System.out.println("A soma de todos os número é: ");
                            analise.calcularSoma();
                        }
                        case 4 -> {
                            System.out.println("Média dos números: ");
                            analise.calcularMedia();
                        }
                        case 5 -> {
                            System.out.println("Maior número encontrado: ");
                            analise.encontrarMaior();
                        }
                        case 6 -> {
                            System.out.println("Menor número encontrado ");
                            analise.encontrarMenor();
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("ERRO: Arquivo não encontrado!!!");
                }
            }
            if (escolha == 0) {
                rodando = false;
            }
        }
    }
}