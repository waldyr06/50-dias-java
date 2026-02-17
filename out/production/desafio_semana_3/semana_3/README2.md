# 🧪 Rick & Morty API Client - Java "Raiz"

> Um cliente de API via terminal desenvolvido em Java puro, implementando um parser JSON manual sem uso de bibliotecas externas.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Rick and Morty](https://img.shields.io/badge/API-Rick%20and%20Morty-blue?style=for-the-badge)

## 🎯 Sobre o Projeto

Este projeto é uma aplicação **Console (CLI)** que consome a API pública do [Rick and Morty](https://rickandmortyapi.com/).

O principal desafio técnico deste projeto foi **não utilizar bibliotecas de terceiros** (como Gson ou Jackson) para tratar os dados. Todo o processamento do JSON (Parsing) foi construído do zero utilizando lógica de manipulação de Strings (`String`, `indexOf`, `substring`) e coleções (`ArrayList`).

## 🚀 Funcionalidades

O sistema permite navegar pelo universo da série através das seguintes opções:

- [x] **Busca por Nome:** Pesquisa personagens e lista todos os resultados encontrados (tratando nomes repetidos).
- [x] **Busca por ID:** Exibe detalhes de um personagem específico pelo seu identificador.
- [x] **Sorteio Aleatório (Random):** Traz um personagem surpresa entre os mais de 800 disponíveis.
- [x] **Paginação:** Navegação entre as páginas da API (Próxima/Anterior) listando 20 personagens por vez.
- [x] **Filtro de Campos:** Exibição específica de dados como Status, Espécie e Origem.
- [x] **Tratamento de Erros:** Lida com códigos HTTP 404 (Não encontrado) e erros de servidor.

## 🛠️ Tecnologias Utilizadas

- **Java JDK** (versão 25)
- **java.net.http.HttpClient**: Para realizar as requisições GET.
- **Lógica de String Manipulation**: Para o parser JSON manual.

## 📂 Estrutura do Projeto

O projeto segue o padrão de responsabilidade única:

| Classe | Responsabilidade |
|Listagem|------------------|
| **Main** | Gerencia o menu, interação com o usuário e fluxo da aplicação. |
| **Buscador** | Responsável pela conexão HTTP e requisição à API (O "Carteiro"). |
| **ManualParser** | Responsável por fatiar o JSON bruto e transformar em listas de dados (O "Tradutor"). |
| **Personagem** | Classe DTO para estruturar os dados do objeto. |

## 🧠 Desafio Técnico: O Parser Manual

Um dos trechos mais interessantes do código é a lógica para extrair múltiplos dados de uma lista JSON sem usar Regex ou Libs:

```java
// Exemplo da lógica utilizada no ManualParser
public List<String> pegarDados(String json, String campo) {
    List<String> lista = new ArrayList<>();
    String chave = "\"" + campo + "\":\"";
    int cursor = 0;
    
    while (true) {
        int indice = json.indexOf(chave, cursor);
        if (indice == -1) break;
        
        // Lógica de substring para extrair o valor exato
        // ...
        lista.add(valor);
        cursor = fimDoValor;
    }
    return lista;
}