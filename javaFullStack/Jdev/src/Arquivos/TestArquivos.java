package Arquivos;

import Classes.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestArquivos {
    public static void main(String[] args) {
        try {

            // Criar pessoas para adicionar no arquivo

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

            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            pessoas.add(pessoa1);
            pessoas.add(pessoa2);
            pessoas.add(pessoa3);



            // Cria um nome de arquivo com a data e hora atual
            Calendar calendar = Calendar.getInstance();
            String nomeArquivo = "\"/home/jeffeson/Documentos/Code/java/javaFullStack/POO/PrimeiroJDev/Arquivos/arquivo_" +
                    calendar.get(Calendar.YEAR) + "_" +
                    (calendar.get(Calendar.MONTH) + 1) + "_" +
                    calendar.get(Calendar.DAY_OF_MONTH) + "_" +
                    calendar.get(Calendar.HOUR_OF_DAY) + "_" +
                    calendar.get(Calendar.MINUTE) + "_" +
                    calendar.get(Calendar.SECOND) + ".txt";

            // Cria um novo arquivo
            File arquivo = new File(nomeArquivo);
            arquivo.createNewFile();

            // Escreve algum conteúdo no arquivo
            FileWriter escreverNoArquivo = new FileWriter(arquivo);

            for (Pessoa p: pessoas) {
                escreverNoArquivo.write(p.getNome()+";"+p.getIdade()+";"+ p.getNomePai()+";");
            }

            // Lê o conteúdo do arquivo
            FileReader leitor = new FileReader(arquivo);
            BufferedReader lerArquivo = new BufferedReader(leitor);
            String linha = lerArquivo.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = lerArquivo.readLine();
            }
            leitor.close();
        } catch (IOException e) {
            System.err.printf("Erro na manipulação do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
