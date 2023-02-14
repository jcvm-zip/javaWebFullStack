package Arquivos;

import Classes.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {
    public static void main(String[] args) throws IOException {

        File file = new File("/home/jeffeson/Documentos/Code/java/javaFullStack/Jdev/src/Arquivos/data/arquivo.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Jefferson");
        pessoa4.setIdade(21);
        pessoa4.setNomePai("Pedrito");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Emilly");
        pessoa2.setIdade(20);
        pessoa2.setNomePai("Corno");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Rafael");
        pessoa3.setIdade(12);
        pessoa3.setNomePai("Pedrito");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa4);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);


        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFWorkbook linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas").getWorkbook();

        int numeroLinha = 0;
        for (Pessoa p : pessoas) {

            Row linha = linhasPessoa.createSheet().createRow(numeroLinha ++);

            int celula = 0;

            Cell celnome = linha.createCell(celula ++);
            celnome.setCellValue(p.getNome());

            Cell celIdade = linha.createCell(celula ++);
            celIdade.setCellValue(p.getIdade());

            Cell celNomePai = linha.createCell(celula ++);
            celNomePai.setCellValue(p.getNomePai());

        }

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("A planilha foi criada");

    }
}
