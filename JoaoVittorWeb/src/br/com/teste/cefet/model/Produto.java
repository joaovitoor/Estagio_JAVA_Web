package br.com.teste.cefet.model;

import br.com.teste.cefet.dao.ExceptionDAO;
import br.com.teste.cefet.dao.ProdutoDAO;

public class Produto {

    private int idProduto;
    private String descricao;
    private int quantidade;
    private String fornecedor;
    private double preco;
    private String vendasOnline;

    public int getIdProduto(){
        return idProduto;
    }
    public String getDescricao(){
        return descricao;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public String getFornecedor(){
        return fornecedor;
    }
    public double getPreco(){
        return preco;
    }
    public String getVendasOnline(){
        return vendasOnline;
    }

    public void setIdProduto(int idProduto){ this.idProduto = idProduto;}
    public void setDescricao(String descricao){ this.descricao = descricao;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setFornecedor(String fornecedor){this.fornecedor = fornecedor;}
    public void setPreco(double preco){this.preco = preco;}
    public void setVendasOnline(String vendasOnline){this.vendasOnline = vendasOnline;}

    public void cadastrarProduto(Produto produto) throws ExceptionDAO {
        new ProdutoDAO().cadastrarProduto(produto);
    }
    public Produto buscarProdutoPorDescricao(String descricao) throws ExceptionDAO{
        return  new ProdutoDAO().buscarProdutoPorDescricao(descricao);
    }
    public void excluirProduto(int idProduto)throws ExceptionDAO{
        new ProdutoDAO().excluirProduto(idProduto);
    }
    public void alterarProduto(Produto produto)throws ExceptionDAO{
        new ProdutoDAO().alterarProduto(produto);
    }

}
