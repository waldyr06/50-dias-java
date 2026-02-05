package semana_3;

public class ManualParser {

    public String pegarDados(String json, String campo){
        String chave = "\"" + campo + "\":\"";

        int indiceInicial = json.indexOf(chave);

        int inicioDoNome = indiceInicial + chave.length();

        int fimDoNome = json.indexOf("\"", inicioDoNome);

        return json.substring(inicioDoNome, fimDoNome);
    }
}