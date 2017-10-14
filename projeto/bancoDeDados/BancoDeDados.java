package projeto.bancoDeDados;

import java.sql.*;

public class BancoDeDados {

    private static final String DRIVER = "jdbc:sqlite:test.db";
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASS = "";

    public void ABancoDeDados() {
        Connection conn = null;
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Conexao estabelecida");
    }

    public void CriarTablea( ) {
    	
    }
    
    public void inserirDados(){

    }

}