package Execultavel;

import java.util.Arrays;
import java.util.List;

public class matriz {

    public static void main(String[] args) {

        int notas[][] = new int[4][4];
        notas[0][0] = 10;
        notas[0][1] = 20;
        notas[0][2] = 30;
        notas[0][3] = 40;

        notas[1][0] = 11;
        notas[1][1] = 21;
        notas[1][2] = 31;
        notas[1][3] = 41;

        notas[2][0] = 12;
        notas[2][1] = 22;
        notas[2][2] = 32;
        notas[2][3] = 42;

        notas[3][0] = 12;
        notas[3][1] = 22;
        notas[3][2] = 32;
        notas[3][3] = 42;

        for (int iLinha=0; iLinha< notas.length; iLinha++) {

            System.out.println("==========================================");

            for (int iColuna = 0; iColuna < notas[iLinha].length; iColuna++) {
                System.out.println("O valor da matriz: "+ notas[iColuna][iLinha]);
            }

        }

        String texto = "Alex, curso Java, 8, 9";

        String[] valoresArray = texto.split(",");
        System.out.println("==========================================");
        System.out.println(""+valoresArray);
        System.out.println("nome: "+valoresArray[0]);
        System.out.println("Disciplina: "+valoresArray[1]);
        System.out.println("nota 1: "+valoresArray[2]);
        System.out.println("nota 2: "+valoresArray[3]);


        //CONVERTENDO ARRAY EM LISTA
        List<String> listConvertido = Arrays.asList(valoresArray);
        System.out.println("IMPRIMINDO A LISTA CONVERTIDA");
        for (String valor: listConvertido) {
            System.out.println(valor);
        }


        // CONVERTENDO LISTA EM ARRAY
        String[] ArrayConvertido = listConvertido.toArray(new String[4]);
        System.out.println("IMPRIMINDO O ARRAY CONVERTIDO");

        for (int i=0; i < ArrayConvertido.length; i++) {
            System.out.println(ArrayConvertido[i]);
        }

    }

}
