package projeto.escola;

import projeto.bancoDeDados.BancoDeDados;
import projeto.telas.Login;
import projeto.telas.Principal;

public class Main {
    public static void main(String[] args) {

        Escola bucao = new Escola();

        new Login();
        //acho que agora deu!
        System.out.println("Ola mundo");
        BancoDeDados bd = new BancoDeDados();
        bd.connect();
    }
}