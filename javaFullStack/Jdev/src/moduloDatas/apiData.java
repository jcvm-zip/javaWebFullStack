package moduloDatas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class apiData {
    public static void main(String[] args) throws ParseException {

        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: "+dataAtual);

        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: "+horaAtual);

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("Data e hora atual: "+dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:ss")));



    }
}
