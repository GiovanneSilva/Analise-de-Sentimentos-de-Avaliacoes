package br.com.alura.ecommerce;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

// SOLID: Classe principal mais coesa
public class AnaliseDeSentimentos {

    public static void main(String[] args) {
        var diretorioAvaliacoes = Path.of("src/main/resources/avaliacoes");
        try {
            // Responsabilidade única de carregamento das avaliações
            var carregador = new CarregadorDeArquivos();
            List<Path> arquivosAvaliacoes = carregador.carregarArquivos(diretorioAvaliacoes, ".txt");

            // Para cada arquivo, realizar a análise
            var analisador = new AnalisadorDeSentimentos();
            for (Path arquivo : arquivosAvaliacoes) {
                System.out.println("Analisando arquivo: " + arquivo.getFileName());
                
                var texto = carregador.carregarConteudo(arquivo);
                String resposta = analisador.analisarSentimentos(texto);

                // Salvando resultado
                var salvador = new SalvadorDeArquivos(); 
                salvador.salvarAnalise(arquivo.getFileName().toString().replace(".txt", ""), resposta);

                System.out.println("Análise finalizada para: " + arquivo.getFileName());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a análise de sentimento: " + e.getMessage());
        }
    }
}