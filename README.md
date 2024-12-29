# **Análise de Sentimentos de Avaliações**
Este projeto realiza a análise de sentimento de avaliações de produto utilizando um modelo de inteligência artificial via integração com a API OpenAI. O objetivo principal é processar arquivos de texto contendo avaliações, gerar um resumo, identificar pontos fortes e fracos e classificar o sentimento geral como **positivo**, **neutro** ou **negativo**.
## 📋 **Sumário**
- [Pré-requisitos]()
- [Instalação e Configuração]()
- [Execução]()
- [Estrutura do Projeto]()
- [Tecnologias Utilizadas]()
- [Autor]()

## ✨ **Pré-requisitos**
Para executar o projeto, você precisará de:
- **Java 17** ou superior instalado
- **Maven** (para gerenciamento de dependências)
- Uma **chave de API da OpenAI** (salva em uma variável de ambiente chamada `OPENAI_API_KEY`)
- IntelliJ IDEA (opcional, mas recomendado para desenvolvimento)
- Git (opcional, para versionamento)

## ⚙️ **Instalação e Configuração**
Siga os passos abaixo para configurar o projeto em sua máquina:
### 1. Clone o repositório
Use o comando abaixo para copiar o projeto para sua máquina local:
``` bash
git clone https://github.com/seuusuario/seurepositorio.git
```
### 2. Configure a variável de ambiente
Adicione sua chave de API da OpenAI na variável de ambiente `OPENAI_API_KEY`.

### 3. Instale as dependências do projeto
Navegue até o diretório do projeto e execute o Maven para baixar as dependências:
``` bash
mvn clean install
```
## ▶️ **Execução**
Após configurar o ambiente, você pode executar o projeto seguindo os passos:
1. Certifique-se de que os arquivos de texto das avaliações estão no diretório:
``` 
   src/main/resources/avaliacoes
```
Exemplo de arquivos de avaliação:
``` 
   avaliacao1.txt
   avaliacao2.txt
   ...
```
1. Execute a classe `AnaliseDeSentimentos`.

1. Os resultados serão salvos em:
``` 
   src/main/resources/analises/
```
## 🗂️ **Estrutura do Projeto**
A estrutura principal do projeto está organizada da seguinte forma:
``` 
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── br.com.alura.ecommerce/
│   │   │   │   ├── AnaliseDeSentimentos.java            # Classe principal
│   │   │   │   ├── CarregadorDeArquivos.java            # Lida com arquivos
│   │   │   │   ├── AnalisadorDeSentimentos.java         # Integração com OpenAI API
│   │   │   │   ├── SalvadorDeArquivos.java              # Lida com a saída das análises
│   │   ├── resources/
│   │   │   ├── avaliacoes/                              # Diretório para os arquivos de input
│   │   │   ├── analises/                                # Diretório para salvar os resultados
├── .gitignore                                            # Ignora arquivos sensíveis/irrelevantes
├── pom.xml                                               # Gerenciador de dependências Maven
└── README.md                                             # Documentação do projeto
```
## 🛠️ **Tecnologias Utilizadas**
O projeto foi realizado utilizando as seguintes tecnologias e ferramentas:
- **Java 17:** Linguagem de programação para desenvolver a aplicação.
- **Maven:** Gerenciamento de dependências.
- **OpenAI API:** Modelo de IA para processamento de linguagem natural.
- **IntelliJ IDEA:** IDE para desenvolvimento.
- **Git:** Controle de versão.

## 📌 **Principais Funcionalidades**
1. **Processamento de Avaliações em Arquivos de Texto:**
    - Os arquivos `.txt` colocados no diretório `src/main/resources/avaliacoes` são processados linha a linha.

2. **Análise de Sentimentos via OpenAI:**
    - Integração com a API GPT-4 para detectar sentimento geral (**positivo**, **neutro** ou **negativo**).
    - Indicação de **pontos fortes** e **pontos fracos** nas avaliações.

3. **Geração de Relatórios de Análise:**
    - Os resultados são armazenados no diretório `src/main/resources/analises` em arquivos `.txt`.

## ⚠️ **Boas Práticas de Segurança**
- **Não expor a API Key:** Certifique-se de que o arquivo contendo sua chave da OpenAI (`.env` ou configuração no sistema) seja listado no `.gitignore` e nunca versionado.
- **Revisar commits:** Faça revisões no histórico de commits (`git log`) antes de realizar pushs para garantir que não incluiu dados sensíveis no código versionado.


## 📖 **Licença**
Este projeto é desenvolvido para fins educacionais e não possui uma licença específica.
