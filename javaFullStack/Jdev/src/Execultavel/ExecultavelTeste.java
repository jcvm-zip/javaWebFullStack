package Execultavel;

import Classes.Aluno;
import Classes.Disciplina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExecultavelTeste {
    public static void main(String[] args) {

        // CADASTRO DO ALUNO
        List<Aluno> alunos = new ArrayList<Aluno>();

        HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Jefferson");

        // CADASTRO DAS DISCIPLINAS DO ALUNO
        Disciplina disciplina1 = new Disciplina();
        double[] notas = {6, 9};

        disciplina1.setNomeDisciplina("Java");
        disciplina1.setNotasDisciplinas(notas);

        Disciplina disciplina2 = new Disciplina();
        double[] notas2 = {10, 5};

        disciplina2.setNomeDisciplina("Html");
        disciplina2.setNotasDisciplinas(notas2);

        Disciplina disciplina3 = new Disciplina();
        double[] nota3 = {3, 1};

        disciplina3.setNomeDisciplina("CSS");
        disciplina3.setNotasDisciplinas(nota3);

        aluno1.getDisciplinas().add(disciplina1);
        aluno1.getDisciplinas().add(disciplina2);
        aluno1.getDisciplinas().add(disciplina3);

        /*
        // Maior valor do array
        for (Disciplina d : aluno1.getDisciplinas()) {

            double maiorNota = 0.0;

            for (int i = 0; i< d.getNotasDisciplinas().length; i++) {

                if (i == 0) {
                    maiorNota = d.getNotasDisciplinas()[i];
                } else {
                    if (d.getNotasDisciplinas()[i] > maiorNota) {
                        maiorNota = d.getNotasDisciplinas()[i];
                    }
                }
            }
            System.out.println("A maior nota da disciplina "+d.getNomeDisciplina()+" é: "+maiorNota);
        }

        // Menor valor do array
        for (Disciplina d : aluno1.getDisciplinas()) {
            double menorNota = 10.0;
            for (int i = 0; i < d.getNotasDisciplinas().length; i++) {
                if (i == 10) {
                    menorNota = d.getNotasDisciplinas()[i];
                } else {
                    if (d.getNotasDisciplinas()[i] < menorNota) {
                        menorNota = d.getNotasDisciplinas()[i];
                    }
                }
            }
            System.out.println("A menor nota da disciplina "+d.getNomeDisciplina()+" é: "+menorNota);
        }
         */

        Aluno[] arrayAlunos = new Aluno[1];
        arrayAlunos[0] = aluno1;

        for (int i = 0; i < arrayAlunos.length; i++) {
            System.out.println("Nome do aluno: "+arrayAlunos[i].getNome());

            for (Disciplina d: arrayAlunos[0].getDisciplinas()) {
                System.out.println("Disciplina: "+d.getNomeDisciplina());

                for (int i2=0; i2<d.getNotasDisciplinas().length; i2++) {
                    System.out.println("notas: "+d.getNotasDisciplinas()[i2]);
                }
            }
        }

    }
}
