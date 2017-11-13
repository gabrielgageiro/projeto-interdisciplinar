package projeto.bancoDeDados;

import projeto.telas.AdicionarVerba;
import projeto.telas.TelaPrincipal;

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
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

    public void criarTable() {

        String sql = "CREATE TABLE IF NOT EXISTS produtos(\n" +
                "id integer PRIMARY KEY,\n" +
                "nome text NOT NULL,\n" +
                "tipo text,\n" +
                "quantidade integer,\n" +
                "valor real\n" +
                ");";

        String sql1 = "CREATE TABLE IF NOT EXISTS verba(\n" +
                "id integer PRIMARY KEY,\n" +
                "valorVerba real,\n" +
                "prazo text\n" +
                ");";

        String sql2 = "CREATE TABLE IF NOT EXISTS logins(\n" +
                "usuario text,\n" +
                "senha text\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // cria a nova tabela
            stmt.execute(sql);
            stmt.execute(sql1);
            stmt.execute(sql2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setUsuarios(String login, String senha) {
        criarTable();

        String sql = "INSERT INTO logins(usuario,senha) VALUES (?,?)";


        try (Connection conn = this.connect(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean validarLogin(String usuario, String senha) {

        String sql = "SELECT usuario, senha FROM logins";

        try (Connection conn = this.connect(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            return rs.getString("usuario").equals(usuario) && rs.getString("senha").equals(senha);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void removerUsuarios(String user) {
        String sql = "DELETE FROM logins WHERE usuario = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, user);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public float getVerba(){
        String sql = "SELECT valorVerba FROM verba";

        float verba=0;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            float v= rs.getFloat("valorVerba");
            return v;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return verba;
    }

    public String verbaLabel(){
        String sql = "SELECT valorVerba FROM verba";
        String verba="";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            float v= rs.getFloat("valorVerba");
            return String.valueOf(v);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return verba;
    }

    public String getData() {
        String sql = "SELECT prazo FROM verba";
        String data = "";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            data = rs.getString("prazo");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }


    public String mostrarDados() {
        String sql = "SELECT id, nome,tipo, quantidade,valor FROM produtos";
        String dados = "ID  NOME \t TIPO \t QUANTIDADE \t VALOR \n ";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {
            //itera sobre os resultados
            while (rs.next()) {
                dados += rs.getInt("id") + "   " +
                        rs.getString("nome") + " \t " +
                        rs.getString("tipo") + " \t " +
                        rs.getInt("quantidade") + " \t " +
                        rs.getFloat("valor") + " \n ";

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dados;
    }

    public float calc(){
        String sql = "SELECT valor,quantidade FROM produtos";
        String valor="";
        float soma=0;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {
            //itera sobre os resultados
            while (rs.next()) {
                soma+=rs.getInt("quantidade")*rs.getFloat("valor");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return soma;
    }

    public void atualizarVerba(float valorVerba){

        String sql = "UPDATE verba SET valorVerba = ?";

        try (Connection conn = this.connect();PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setFloat(1,getVerba()-valorVerba);
            pstm.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void inserirVerba(float valorVerba, String prazo) {

        criarTable();

        if (getVerba() == 0){
            String sql = "INSERT into verba(valorVerba,prazo) VALUES(?,?)";

            try (Connection conn = this.connect(); PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setFloat(1, valorVerba);
                pstm.setString(2, prazo);
                pstm.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
            atualizarVerba(valorVerba);
        }

    }


    public void inserirDados(String nome, String tipo, int qtd, float valor) {
        criarTable();

        String sql = "INSERT INTO produtos(nome,tipo,quantidade,valor) VALUES (?,?,?,?)";

        if (valor*qtd > getVerba()) {
            JOptionPane.showMessageDialog(null,"Saldo insuficiente!\nVoce tem "+getVerba());
        }
        else {
            atualizarVerba(qtd*valor);

            try (Connection conn = this.connect(); PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setString(1, nome);
                pstm.setString(2, tipo);
                pstm.setInt(3, qtd);
                pstm.setFloat(4, valor);
                pstm.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
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