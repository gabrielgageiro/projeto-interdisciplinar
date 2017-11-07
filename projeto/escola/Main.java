package projeto.escola;

import projeto.telas.Login;
import projeto.telas.TelaPrincipal;

import projeto.bancoDeDados.*;

import javax.swing.*;
import java.util.Calendar;


public class Main {
  
    public static void main(String[] args) {
        //new Login();
        Calendar calendar = Calendar.getInstance();
        int diaAno = calendar.get(Calendar.DAY_OF_YEAR);
        int diaFinalPrazo = 317;//334 é dia 30/11

        System.out.println(new BancoDeDados().getData());
        //JOptionPane.showMessageDialog(null, "Dias para o fim do prazo: "+ (diaFinalPrazo - diaAno));

        new TelaPrincipal();

    }
}