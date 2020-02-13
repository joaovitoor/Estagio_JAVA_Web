package br.com.teste.cefet.controller;

import br.com.teste.cefet.dao.ExceptionDAO;
import br.com.teste.cefet.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AlterarProdutoController")
public class AlterarProdutoController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idProduto = request.getParameter("idProduto");
        String descricao = request.getParameter("descricao");
        String quantidade = request.getParameter("quantidade");
        String fornecedor = request.getParameter("fornecedor");
        String preco = request.getParameter("preco");
        String vendasonline = request.getParameter("vendasonline");
        Produto produto = null;
        String mensagem = null;

        String[] arrayParametros = {descricao, quantidade, fornecedor, preco, vendasonline};
        String[] arrayCampos = {"Descricao", "Quantidade", "Fornecedor", "Preco", "Vendas On-line"};

        try{
            for (int cont = 0; cont <arrayParametros.length; cont ++){
                if(arrayParametros[cont] == null || arrayParametros[cont].length() <= 0){
                    if(mensagem==null){
                        mensagem = arrayCampos[cont];
                    }else {
                        mensagem = mensagem + ", " + arrayCampos[cont];
                    }
                }
            }
            if(mensagem != null){
                mensagem = "Preencha corretamente o(s) campo(s): "+ mensagem + ".";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProduto.jsp");
                dispatcher.forward(request, response);
            }else {
                produto = new Produto();
                produto.setIdProduto(Integer.parseInt(idProduto));
                produto.setDescricao(descricao);
                produto.setQuantidade(Integer.parseInt(quantidade));
                produto.setFornecedor(fornecedor);
                produto.setPreco(Double.parseDouble(preco));
                produto.setVendasOnline(vendasonline);

                produto.alterarProduto(produto);
                RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProduto.jsp");
                dispatcher.forward(request, response);
            }
        }catch (ServletException | IOException | NumberFormatException | ExceptionDAO e){
            response.getWriter().write("Erro em alterar produto: " + e);
        }
    }

}
