package semana_1;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        AnaliseNumerica analise = new AnaliseNumerica();

        System.out.println("Olá, você agora tem um programa para analisar uma lista de números");
        System.out.println("");

        Scanner teclado  = new Scanner(System.in);

        boolean rodando = true;

        while (rodando == true){
            System.out.println("MENU PRINCIPAL");
            System.out.println("Escolha você quer por um arquivo que tem uma lista ou fazer sua lista aqui?");
            System.out.println("");
            System.out.println("Lista autoral - 1");
            System.out.println("Arquivo com lista - 2");
            System.out.println("Encerrar programa - 0");
            System.out.println("");

            int escolha = teclado.nextInt();
            if (escolha == 1){
                System.out.println("Aqui você pode: ADICIONAR NUMERO / VISUALIZAR LISTA / " +
                        "CALCULAR SOMAR / CALCULAR MÉDIA / MAIOR NUMERO / MENOR NUMERO");
                int escolha2 = teclado.nextInt();
                if (escolha2 == 1){
                    System.out.println("Digite o número: ");
                    double numero = teclado.nextDouble();
                    AnaliseNumerica add = new AnaliseNumerica();
                    add.adicionarNumero(numero);
                }
                if (escolha2 == 2){
                    System.out.println("Segue a lista: ");
                    AnaliseNumerica visu = new AnaliseNumerica();
                    visu.visualizarLista();
                }
                if (escolha2 == 3){
                    System.out.println("Soma de todos os numeros: ");
                    AnaliseNumerica somando = new AnaliseNumerica();
                    somando.calcularSoma();
                }
                if (escolha2 == 4){
                    System.out.println("Segue a média: ");
                    AnaliseNumerica tirandoMedia = new AnaliseNumerica();
                    tirandoMedia.calcularMedia();
                }
                if (escolha2 == 5){
                    System.out.println("Segue o maior número da lista: ");
                    AnaliseNumerica maiorNumero = new AnaliseNumerica();
                    maiorNumero.encontrarMaior();
                }
                if (escolha2 == 6){
                    System.out.println("Segue o menor número da lista: ");
                    AnaliseNumerica menorNumero = new AnaliseNumerica();
                    menorNumero.encontrarMenor();
                }
            }
        }
    }
}