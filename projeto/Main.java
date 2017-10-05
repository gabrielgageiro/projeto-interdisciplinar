package projeto;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Escola bucao = new Escola();

        System.out.println("Ola mundo");
        BancoDeDados bd = new BancoDeDados();
        bd.connect();
    }
}