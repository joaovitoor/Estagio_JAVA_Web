package br.com.teste.cefet.dao;

import br.com.teste.cefet.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) throws ExceptionDAO{
        String sql = "insert into produto (descricao, quantidade, fornecedor, preco, vendasonline) values (?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection connection = null;
        try {
            connection = new ConexaoBancoDeDados().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setString(3, produto.getFornecedor());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getVendasOnline());
            stmt.execute();
        } catch (SQLException e){
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar produto"+ e);
        } finally {
            try{
                if (stmt !=null){
                    stmt.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public Produto buscarProdutoPorDescricao(String descricao) throws ExceptionDAO{

        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        Produto produto = null;
        try{
            String sql = "select * from produto where descricao=?";
            connection = new ConexaoBancoDeDados().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, descricao);
            rs = stmt.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    produto = new Produto();
                    produto.setIdProduto(rs.getInt("idproduto"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setFornecedor(rs.getString("fornecedor"));
                    produto.setPreco(rs.getDouble("quantidade"));
                    produto.setVendasOnline(rs.getString("vendasonline"));
                }
            }
        }catch (SQLException e ){e.printStackTrace(); throw new ExceptionDAO("Erro ao buscar produto: " + e);

        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if (connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }return produto;
    }

    public void excluirProduto(int idProduto) throws ExceptionDAO{

        String sql = "delete from produto where idproduto=?";
        PreparedStatement stmt = null;
        Connection connection = null;
        try{
            connection = new ConexaoBancoDeDados().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir produto: " + e );
        }finally {
            try{
                if (stmt !=null){
                    stmt.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if (connection !=null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public void alterarProduto(Produto produto) throws ExceptionDAO{

        String sql = "update produto set descricao=?, quantidade=?, fornecedor=?, preco=?, vendasonline=? where idproduto=?";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBancoDeDados().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setString(3, produto.getFornecedor());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.getVendasOnline());
            stmt.setInt(6, produto.getIdProduto());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar produto" + e);
        }finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
