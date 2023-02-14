package moduloDatas;

import java.time.LocalDate;
import java.time.Period;

public class objPeriodoEntreDatas {
    public static void main(String[] args) {
        LocalDate dataAntiga = LocalDate.of(2020, 6, 13);
        LocalDate agora = LocalDate.now();

        System.out.println("Data antiga é maior que data nova? "+dataAntiga.isAfter(agora));

        Period periodo = Period.between(dataAntiga, agora);

        System.out.println("A quantos anos: "+periodo.getYears());
        System.out.println("A quantos meses: "+periodo.getMonths());
        System.out.println("A quantos dias: "+periodo.getDays());

        System.out.println("Namoramos a "+periodo.getYears()+ ", "+periodo.getMonths()+" meses e "+periodo.getDays()+"Dias");

    }

}
