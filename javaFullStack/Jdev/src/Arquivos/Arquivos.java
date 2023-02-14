package Arquivos;

import Classes.Pessoa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Jefferson");
        pessoa1.setIdade(21);
        pessoa1.setNomePai("Pedrito");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Emilly");
        pessoa2.setIdade(20);
        pessoa2.setNomePai("Corno");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Rafael");
        pessoa3.setIdade(12);
        pessoa3.setNomePai("Pedrito");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);


        File file = new File("/home/jeffeson/Documentos/Code/java/javaFullStack/POO/PrimeiroJDev/Arquivos/arquivo.csv");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(file);

        for (Pessoa p: pessoas) {
            escreverNoArquivo.write(p.getNome()+";"+p.getIdade()+";"+ p.getNomePai()+";\n");
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close();


    }
}
