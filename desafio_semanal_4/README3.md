# ☀️ ClimaPE - Dashboard Meteorológico de Pernambuco

O **ClimaPE** é uma aplicação web desenvolvida em Java com Spring Boot que fornece previsões do tempo em tempo real para as principais cidades do estado de Pernambuco. O projeto consome a API pública **Open-Meteo** para buscar dados precisos de temperatura e condições climáticas.

Este projeto faz parte do meu **Desafio de 50 Dias de Código Java**, focado em praticar integração de APIs, arquitetura de serviços e desenvolvimento web moderno.

---

## 🚀 Funcionalidades

* **Monitoramento em Tempo Real:** Consumo da API Open-Meteo para dados atualizados.
* **Cobertura Regional:** Inclui algumas cidades de todas as regiões de Pernambuco (RMR, Agreste e Sertão), além de Fernando de Noronha.
* **Tradução Inteligente:** Converte códigos numéricos da API em descrições amigáveis com emojis (Ex: `61` -> `Chuva ☔`).
* **Interface Responsiva:** Visual moderno e limpo desenvolvido com **Bootstrap** e **Thymeleaf**.
* **Arquitetura Limpa:** Separação clara entre Client (API), Service (Lógica) e Controller (Rotas).

---

## 🛠️ Tecnologias Utilizadas

* **Java 25:** Versão mais recente para aproveitar as últimas melhorias da linguagem.
* **Spring Boot 4.0.2:** Framework base para a aplicação web.
* **Thymeleaf:** Motor de templates para renderização dinâmica do HTML.
* **Lombok:** Para redução de código boilerplate (Getters, Setters, etc).
* **HttpClient (Java Native):** Para requisições assíncronas à API externa.
* **Jackson:** Para conversão de JSON em objetos Java.
* **Bootstrap 5:** Para estilização e responsividade.

---

## 📐 Arquitetura do Sistema

O fluxo de dados da aplicação segue o padrão MVC (Model-View-Controller):

1.  **Client (`OpenMeteoClient`)**: Realiza a chamada HTTP para a API externa usando as coordenadas geográficas (lat/lon).
2.  **Service (`ClimaService`)**: Gerencia a lista de cidades, chama o Client e traduz os códigos meteorológicos.
3.  **Controller (`ClimaController`)**: Recebe a requisição do usuário e envia os dados processados para a View.
4.  **View (`pagina-clima.html`)**: Exibe os cards das cidades de forma dinâmica usando Thymeleaf.

---

## ⚙️ Como Rodar o Projeto

1.  **Pré-requisitos:**
    * Java JDK 25 instalado.
    * Maven instalado (ou usar o wrapper do projeto).

2.  **Clonando o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/clima-pe.git](https://github.com/seu-usuario/clima-pe.git)
    cd clima-pe
    ```

3.  **Executando a aplicação:**
    * Pelo terminal: `./mvnw spring-boot:run`
    * Pelo IntelliJ: Executar a classe `ClimaPeApplication.java`.

4.  **Acessando no navegador:**
    Abra `http://localhost:8080/climape`

---

## 📍 Cidades Monitoradas

* Recife 🌊
* Jaboatão dos Guararapes 🏠
* Olinda 🎭
* Caruaru 🏺
* Garanhuns 🌹
* Salgueiro 🌵
* Petrolina 🍇
* Fernando de Noronha 🏝️

---

## 📝 Licença
Este projeto foi desenvolvido para fins educacionais durante o desafio de 50 dias de Java. Sinta-se à vontade para usar e estudar o código!

---
Desenvolvido por Waldyr Araujo no Desafio 50 Dias de Java.