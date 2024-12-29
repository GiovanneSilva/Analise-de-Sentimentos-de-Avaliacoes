package br.com.alura.ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SalvadorDeArquivos {
    
    public void salvarAnalise(String nomeArquivo, String resultado) {
        try {
            var path = Path.of("src/main/resources/analises/analise-sentimentos-" + nomeArquivo + ".txt");
            Files.writeString(path, resultado, StandardOpenOption.CREATE_NEW);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a análise no arquivo: " + nomeArquivo, e);
        }
    }
}