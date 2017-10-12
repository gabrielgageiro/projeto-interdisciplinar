package projeto.escola;

import projeto.bancoDeDados.BancoDeDados;
import projeto.telas.Login;

public class Main {
  
		public static void main(String[] args) {
		
        new Login();
        System.out.println("Ola mundo");
        BancoDeDados bd = new BancoDeDados();
        bd.connect();
    }
}