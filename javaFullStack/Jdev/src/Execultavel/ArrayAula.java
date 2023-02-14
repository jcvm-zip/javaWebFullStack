package Execultavel;
import javax.swing.*;

public class ArrayAula {
    public static void main(String[] args) {

        int quantNotas = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas deseja cadastrar? "));

        double[] notas = new double[quantNotas];

        for (int i=0; i < notas.length; i++){
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog("DIgite o valor da posição "+(i+1)));
        }
        for (int i=0 ; i<  notas.length; i++) {
            System.out.println("O valor da posição " + i + " é " + notas[i]);
        }



    }
}
