package Arquivos;

import Classes.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoiRecebe {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream( new File("/home/jeffeson/Documentos/Code/java/javaFullStack/Jdev/src/Arquivos/data/teste.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

        Iterator<Row> linhaIterator = planilha.iterator();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa pessoa = new Pessoa();

        while (linhaIterator.hasNext()) {
            Row linha = (Row) linhaIterator.next();

            Iterator<Cell> celulas = linha.iterator();

            while (celulas.hasNext()) {

                Cell cell = celulas.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                    case 2:
                        pessoa.setNomePai(cell.getStringCellValue());
                        break;
                }

            }

            pessoas.add(pessoa);

        }
        entrada.close();

        for (Pessoa p: pessoas) {
            System.out.println(p);
        }

    }
}
