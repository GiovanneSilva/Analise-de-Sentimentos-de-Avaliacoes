package br.com.alura.ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CarregadorDeArquivos {

    // Responsável por carregar arquivos de um diretório com base na extensão
    public List<Path> carregarArquivos(Path diretorio, String extensao) {
        try {
            return Files.walk(diretorio, 1)
                    .filter(path -> path.toString().endsWith(extensao))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar arquivos do diretório: " + diretorio, e);
        }
    }

    // Responsável por carregar o conteúdo de um arquivo específico
    public String carregarConteudo(Path arquivo) {
        try {
            return Files.readAllLines(arquivo).toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar o conteúdo do arquivo: " + arquivo, e);
        }
    }
}