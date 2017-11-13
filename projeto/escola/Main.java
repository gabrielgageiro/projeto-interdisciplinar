package projeto.escola;

import projeto.telas.Login;
import projeto.telas.RelatorioMateriais;
import projeto.telas.TelaPrincipal;

import projeto.bancoDeDados.*;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class Main {

    public static void main(String[] args) throws ParseException {

        Calendar c = Calendar.getInstance();

       // new Login();
        SimpleDateFormat ha = new SimpleDateFormat("dd/MM/yyyy");

        try {
            String t = new BancoDeDados().getData();
            Date data = ha.parse(t);
            c.setTime(data);

            JOptionPane.showMessageDialog(null, "Dias para o fim do prazo: "+
                    (c.get(Calendar.DAY_OF_YEAR) - Calendar.getInstance().get(Calendar.DAY_OF_YEAR)));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        new TelaPrincipal();

    }
}