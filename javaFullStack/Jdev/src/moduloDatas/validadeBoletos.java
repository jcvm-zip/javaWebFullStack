package moduloDatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class validadeBoletos {
    public static void main(String[] args)throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataVencimentoBoleto = simpleDateFormat.parse("10/04/2021");
        Date dataAtualHoje = simpleDateFormat.parse("07/02/2024");



        if (dataVencimentoBoleto.after(dataAtualHoje)) {
            System.out.println("Boleto Valido");
        } else {
            System.out.println("Boleto invalido. Deseja Gerar um novo boleto?");
        }
    }
}
