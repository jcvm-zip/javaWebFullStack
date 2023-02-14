package Classes;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
    private double notasDisciplinas[] = new double[2];
    private String NomeDisciplina;

    public String getNomeDisciplina() {
        return NomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.NomeDisciplina = nomeDisciplina;
    }

    public double[] getNotasDisciplinas() {
        return notasDisciplinas;
    }

    public void setNotasDisciplinas(double[] notasDisciplinas) {
        this.notasDisciplinas = notasDisciplinas;
    }

    public double getMediaNotas() {
        double somaNotas = 0;

        for (int i = 0; i< notasDisciplinas.length; i++) {
            somaNotas += notasDisciplinas[i];
        }
        return somaNotas / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Arrays.equals(notasDisciplinas, that.notasDisciplinas) && Objects.equals(NomeDisciplina, that.NomeDisciplina);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(NomeDisciplina);
        result = 31 * result + Arrays.hashCode(notasDisciplinas);
        return result;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "notasDisciplinas=" + Arrays.toString(notasDisciplinas) +
                ", NomeDisciplina='" + NomeDisciplina + '\'' +
                '}';
    }
}
