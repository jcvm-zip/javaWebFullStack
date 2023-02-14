package moduloDatas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {

    public static void main(String[] args) {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();



        System.out.println("Data de hoje em milisegundos: "+date.getTime());
        System.out.println("Calendar em milissegundos: "+ calendar.getTimeInMillis());

        System.out.println("Date Segundos: "+date.getSeconds());
        System.out.println("Calendar Segundos: "+calendar);

        System.out.println("Minutos: "+date.getMinutes());
        System.out.println("Minutos: "+calendar.get(Calendar.MINUTE));


        System.out.println("Horas: "+date.getHours());
        System.out.println("Horas: "+calendar.get(Calendar.HOUR_OF_DAY));


        System.out.println("Dia da semana: "+date.getDay());
        System.out.println("Dia da semana: "+calendar.get(Calendar.DAY_OF_WEEK));


        System.out.println("Mês: "+(date.getMonth()+1));
        System.out.println("Mês: "+(calendar.get(calendar.DAY_OF_MONTH)- 1));


        System.out.println("Ano: "+(date.getYear()+1900));
        System.out.println("Ano: "+calendar.get(Calendar.YEAR));


        // Simple Date Format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data atual em formato padrão: "+simpleDateFormat.format(date));
        System.out.println("Data atual em formato padrão: "+simpleDateFormat.format(calendar.getInstance().getTime()));


        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Data atual em formato BD: "+ simpleDateFormat.format(date));
        System.out.println("Data atual em formato BD: "+simpleDateFormat.format(calendar.getTime()));



    }
}
