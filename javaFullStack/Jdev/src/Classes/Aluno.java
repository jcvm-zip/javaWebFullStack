package Classes;


import Constantes.StatusAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno extends Pessoa {

    private int numeroMatricula;
    private String dataMatricula;
    private String serieMatriculado;

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();


    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatriculo) {
        this.dataMatricula = dataMatriculo;
    }

    public String getSerieMatriculado() {
        return serieMatriculado;
    }

    public void setSerieMatriculado(String serieMatriculado) {
        this.serieMatriculado = serieMatriculado;
    }

    public Double getMediaNotas() {

        double somaNotas = 0;

        for (Disciplina notasDisciplinas : disciplinas) {
            somaNotas += notasDisciplinas.getMediaNotas();
        }
        return somaNotas / disciplinas.size();
    }
    public String getResultado() {
        double media = getMediaNotas();
        if (media >= 5) {
            if (media < 7) {
                return StatusAluno.RECUPERACAO;
            } else {
                return StatusAluno.APROVADO;
            }
        } else {
            return StatusAluno.REPROVADO  ;
        }
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return numeroMatricula == aluno.numeroMatricula && Objects.equals(dataMatricula, aluno.dataMatricula) && Objects.equals(serieMatriculado, aluno.serieMatriculado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroMatricula, dataMatricula, serieMatriculado);
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "numeroMatricula=" + numeroMatricula +
                ", dataMatricula='" + dataMatricula + '\'' +
                ", serieMatriculado='" + serieMatriculado + '\'' +
                '}';
    }
}

