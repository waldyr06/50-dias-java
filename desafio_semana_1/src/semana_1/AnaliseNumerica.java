package semana_1;

import java.util.ArrayList;

public class AnaliseNumerica {

    static ArrayList<Double> listaNumeros = new ArrayList<>();

    public void visualizarLista() {
        for (Double n : listaNumeros) {
            System.out.println(n);
        }
    }

    public void adicionarNumero(double numero) {
        listaNumeros.add(numero);
    }

    public void calcularSoma() {
        double resultado = 0;
        for (Double n : listaNumeros) {
            resultado += n;
        }
        System.out.printf("Soma total: %.2f", resultado);
    }

    public void calcularMedia() {
        double media = 0;
        for (Double n : listaNumeros) {
            media += n;
        }
        double mediaFinal = media / listaNumeros.size();
        System.out.printf(String.valueOf(mediaFinal));
    }

    public void encontrarMaior() {
        double maior = listaNumeros.get(0);
        for (Double n : listaNumeros) {
            if (n > maior) {
                maior = n;
            }
        }
        System.out.printf(String.valueOf(maior));
    }

    public void encontrarMenor(){
        double menor = listaNumeros.get(0);
        for (Double n : listaNumeros){
            if (n < menor){
                menor = n;
            }
        }
        System.out.printf(String.valueOf(menor));
    }
}