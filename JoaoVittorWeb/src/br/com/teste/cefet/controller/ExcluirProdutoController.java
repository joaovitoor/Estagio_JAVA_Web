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

@WebServlet("/ExcluirProdutoController")
public class ExcluirProdutoController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");

        try{
            Produto produto = new Produto();
            produto.excluirProduto(Integer.parseInt(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProduto.jsp");
            dispatcher.forward(request, response);
        }catch (NumberFormatException | ExceptionDAO | ServletException | IOException e){
            response.getWriter().write("Erro ao excluir produto: " + e);
        }

    }

}
