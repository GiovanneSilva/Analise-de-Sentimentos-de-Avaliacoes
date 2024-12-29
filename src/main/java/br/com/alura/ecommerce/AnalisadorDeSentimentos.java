package br.com.alura.ecommerce;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;
import io.github.sashirestela.openai.exception.OpenAIException;
import io.github.sashirestela.openai.exception.OpenAIExceptionConverter;

public class AnalisadorDeSentimentos {

    private final SimpleOpenAI openAI;

    public AnalisadorDeSentimentos() {
        this.openAI = SimpleOpenAI.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .build();
    }

    // Análise de sentimentos com integração à API
    public String analisarSentimentos(String texto) {
        var tentativas = 0;
        while (tentativas++ != 3) {
            try {
                String promptSistema = """
                        Você é um analisador de sentimentos de avaliações de produtos.
                        Escreva um parágrafo com até 50 palavras resumindo as avaliações e depois atribua qual o sentimento geral para o produto.
                        Identifique também 3 pontos fortes e 3 pontos fracos identificados a partir das avaliações.
                        
                        #### Formato de saída
                        Nome do produto:
                        Resumo das avaliações: [resuma em até 50 palavras]
                        Sentimento geral: [deve ser: POSITIVO, NEUTRO ou NEGATIVO]
                        Pontos fortes: [3 bullets points]
                        Pontos fracos: [3 bullets points]
                        """;

                var chatRequest = ChatRequest.builder()
                        .model("gpt-4o")
                        .message(ChatMessage.SystemMessage.of(promptSistema))
                        .message(ChatMessage.UserMessage.of(texto))
                        .temperature(1.0)
                        .maxCompletionTokens(300)
                        .build();

                var futureChat = openAI.chatCompletions().create(chatRequest);
                return futureChat.join().firstContent();
            } catch (Exception e) {
                try {
                    OpenAIExceptionConverter.rethrow(e);
                } catch (OpenAIException.AuthenticationException ae) {
                    System.out.println("Error: Authentication error: " + ae.getResponseInfo().getErrorResponse().getError().getCode());
                } catch (OpenAIException.NotFoundException ne) {
                    System.out.println("Error: Not found " +  ne.getResponseInfo().getErrorResponse().getError().getCode());
                } catch (OpenAIException.RateLimitException re) {
                    System.out.println("Error: Rate limit exceeded " + re.getResponseInfo().getErrorResponse().getError().getCode());
                }
                catch (RuntimeException re) {
                    System.out.println("Error: " + re.getMessage() + "Não foi possível analisar o texto");
                }

            }
        }
        return "Erro ao analisar os sentimentos.";
    }
}