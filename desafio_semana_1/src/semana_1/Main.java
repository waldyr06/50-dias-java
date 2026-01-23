package semana_1;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        AnaliseNumerica analise = new AnaliseNumerica();

        System.out.println("------------------------------------------------------------------");
        System.out.println("Olá, você agora tem um programa para analisar uma lista de números");

        Scanner teclado  = new Scanner(System.in);

        boolean rodando = true;

        while (rodando == true){
            System.out.println("------------------------------------------------------------------");
            System.out.println("Você tem duas opções para analisar uma lista de números");
            System.out.println("------------------------------------------------------------------");
            System.out.println("1 - Crie uma lista ou acesse a lista atual");
            System.out.println("2 - Mande um arquivo .txt");
            System.out.println("------------------------------------------------------------------");
            System.out.println("0 - Encerrar o programa");
            System.out.println("------------------------------------------------------------------");

            int escolha = teclado.nextInt();
            if (escolha == 1){
                System.out.println("Escolhas: 1 - ADICIONAR NúMERO / 2 - VISUALIZAR LISTA / " +
                        "3 - CALCULAR SOMAR / 4 - CALCULAR MÉDIA / 5 - MAIOR NUMERO / 6 - MENOR NUMERO");
                System.out.println("------------------------------------------------------------------");
                int escolha2 = teclado.nextInt();
                //Fazer um switch case aqui
                if (escolha2 == 1){
                    System.out.print("Adicionando o número:  ");
                    double numero = teclado.nextDouble();
                    analise.adicionarNumero(numero);
                }
                if (escolha2 == 2){
                    System.out.println("Lista: ");
                    analise.visualizarLista();
                }
                if (escolha2 == 3){
                    System.out.println("A soma de todos os número é: ");
                    analise.calcularSoma();
                }
                if (escolha2 == 4){
                    System.out.println("Média dos números: ");
                    analise.calcularMedia();
                }
                if (escolha2 == 5){
                    System.out.println("Maior número encontrado: ");
                    analise.encontrarMaior();
                }
                if (escolha2 == 6){
                    System.out.println("Menor número encontrado ");
                    analise.encontrarMenor();
                }
            }
        }
    }
}