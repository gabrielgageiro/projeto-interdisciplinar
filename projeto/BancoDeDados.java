package projeto;

import java.sql.*;
import java.lang.*;

public class BancoDeDados {

    public void connect() {
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
}