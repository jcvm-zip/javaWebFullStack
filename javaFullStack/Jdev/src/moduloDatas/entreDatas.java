package moduloDatas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class entreDatas {
    public static void main(String[] args) throws ParseException {


        long diasEntre = ChronoUnit.DAYS.between(LocalDate.parse("2023-02-01"), LocalDate.now());


        System.out.println("Os dias entre 01/02/2023 e hoje é "+diasEntre);

    }
}
