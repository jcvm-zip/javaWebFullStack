package moduloDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class manipulandoDatas {
    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("06-02-2023"));

        //calendar.setTime(new Date(2023,02,6));


        //Add mais 5 dias na data
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        System.out.println("Dia "+ new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));

    }
}
