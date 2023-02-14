package Arquivos;

import Classes.Pessoa;
import org.junit.platform.commons.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaDados = new FileInputStream(
                new File("/home/jeffeson/Documentos/Code/java/javaFullStack/POO/PrimeiroJDev/Arquivos/arquivo.csv"));

        Scanner lerArquivo = new Scanner(entradaDados, "UTF-8");

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (lerArquivo.hasNext()) {

            String linha = lerArquivo.nextLine();

            if (StringUtils.isNotBlank(linha)) {

                String[] dados = linha.split(";");

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setIdade(Integer.parseInt(dados[1]));
                pessoa.setNomePai(dados[2]);

                pessoas.add(pessoa);

            }

            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }
}
