package semana_3;

import java.util.ArrayList;
import java.util.List;

public class ManualParser {

    public List<String> pegarDados(String json, String campo) {
        List<String> listaEncontrada = new ArrayList<>();

        String chave = "\"" + campo + "\":\"";
        int cursor = 0;

        while (true) {
            int indiceChave = json.indexOf(chave, cursor);

            if (indiceChave == -1) {
                break;
            }

            int inicioValor = indiceChave + chave.length();
            int fimValor = json.indexOf("\"", inicioValor);

            String valor = json.substring(inicioValor, fimValor);
            listaEncontrada.add(valor);

            cursor = fimValor;
        }

        return listaEncontrada;
    }

    public String pegarLocalizacao(String json) {
        String chaveLoc = "\"location\":";
        int posLocation = json.indexOf(chaveLoc);

        if (posLocation == -1) {
            return "Desconhecida";
        }

        String jsonCortado = json.substring(posLocation);

        List<String> resultados = pegarDados(jsonCortado, "name");

        if (resultados.isEmpty()) {
            return "Desconhecida";
        }

        return resultados.get(0);
    }
}