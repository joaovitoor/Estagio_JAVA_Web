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

@WebServlet("/BuscarProdutoController")
public class BuscarProdutoController extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            String descricao = request.getParameter("descricao");
            try{
                if (descricao.length() > 0 && descricao != null){
                    Produto produto = new Produto();
                    Produto result = produto.buscarProdutoPorDescricao(descricao);
                    request.setAttribute("produto", result);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProduto.jsp");
                    dispatcher.forward(request, response);
                }else{
                    String mensagem = "Preencha corretamente o(s) campo(s) descricao";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("buscarProduto.jsp");
                    dispatcher.forward(request, response);
                }
            }catch (ExceptionDAO | ServletException | IOException e){
                response.getWriter().write("Erro ao realizar consulta: " + e);
            }

        }

}
