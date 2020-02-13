package br.com.teste.cefet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    public Connection getConnection(){

        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/joaoteste", "postgres", "Alice090");
            System.out.println("Conexão com Banco de Dados com Sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;

    }

}
