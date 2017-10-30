package projeto.bancoDeDados;

import javax.swing.*;
import java.sql.*;

public class BancoDeDados {

    private static final String DRIVER = "jdbc:sqlite:test.db";
    private static final String URL = "jdbc:sqlite:test.db";
    private static final String USER = "";
    private static final String PASS = "";

    public BancoDeDados() {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null,e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.getMessage();
        }
        return conn;
    }

    public void criarTable( ) {
        String sql = "CREATE TABLE IF NOT EXISTS produtos(\n" +
                "id integer PRIMARY KEY,\n" +
                "nome text NOT NULL,\n" +
                "tipo text,\n" +
                "quantidade integer,\n" +
                "valor real\n" +
                ");";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // cria a nova tabela
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String mostrarDados(){
        String sql = "SELECT id, nome,tipo, quantidade,valor FROM produtos";
        String dados="";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)){

            // loop through the result set
            // String nome,String tipo,short qtd,float valor
            while (rs.next()) {
                dados+=rs.getInt("id") +  "\n" +
                        rs.getString("nome") + "\n" +
                        rs.getString("tipo")+"\n"+
                        rs.getInt("quantidade")+ "\n"+
                        rs.getFloat("valor");

                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("nome") + "\t" +
                        rs.getString("tipo")+"\t"+
                        rs.getInt("quantidade")+ "\t"+
                        rs.getFloat("valor"));


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return dados;
    }


    public void inserirDados(String nome,String tipo,int qtd,float valor ){
        criarTable();

        String sql = "INSERT INTO produtos(nome,tipo,quantidade,valor) VALUES (?,?,?,?)";

        try (Connection conn = this.connect();PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1,nome);
            pstm.setString(2,tipo);
            pstm.setInt(3,qtd);
            pstm.setFloat(4,valor);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(String nome) {
        String sql = "DELETE FROM produtos WHERE nome = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, nome);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}