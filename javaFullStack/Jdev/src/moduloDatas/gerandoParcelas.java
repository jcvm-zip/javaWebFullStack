package moduloDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class gerandoParcelas {

    public static void main(String[] args) throws ParseException {

        Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2023");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicio);

        for (int parc=1; parc<12 ; parc++) {
            calendar.add(Calendar.MONTH,1);
            System.out.println("-------------------------------");
            System.out.println("Parcela número: "+parc+" \nVencimento: "+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

        }
    }

}
