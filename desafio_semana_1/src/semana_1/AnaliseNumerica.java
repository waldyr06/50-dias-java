package semana_1;

import java.util.ArrayList;

public class AnaliseNumerica {

    static ArrayList<Double> listaNumeros = new ArrayList<>();

    public void visualizarLista(){
        for(Double n : listaNumeros){
            System.out.println(n);
        }
    }

    public void adicionarNumero(double numero){
        listaNumeros.add(numero);
    }

    public void calcularSoma(){

    }

    public void calcularMedia(){

    }

    public void encontrarMaior(){

    }

    public void encontrarMenor(){

    }

}