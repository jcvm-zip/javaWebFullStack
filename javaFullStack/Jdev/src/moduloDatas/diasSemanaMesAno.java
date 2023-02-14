package moduloDatas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class diasSemanaMesAno {
    public static void main(String[] args) throws ParseException {
        LocalDate localDate = LocalDate.now();
        System.out.println("Data: "+localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Dia do mês: "+localDate.getDayOfMonth());
        System.out.println("mês: "+localDate.getMonth());
        System.out.println("ano: "+localDate.getYear());
        System.out.println("Dia da semana: "+localDate.getDayOfWeek());
        System.out.println("Dia do ano: "+localDate.getDayOfYear());






    }
}
