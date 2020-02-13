<%--
  Created by IntelliJ IDEA.
  User: 15836968730
  Date: 11/02/2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@page import="br.com.teste.cefet.model.Produto"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consulta de Produtos</title>
</head>
<body>

        <p style="text-align: center">
            <%
                String mensagem = (String) request.getAttribute("mensagem");
                if( mensagem != null){
                    out.print(mensagem);
                }
            %>
        </p>

        <form action="http://localhost:8080/JoaoVittorWeb_war_exploded//BuscarProdutoController" method="get">
            <table>
                <thead>
                <tr><th>Consultar um produto</th></tr>
                </thead>
                <tbody>
                <td>Descrição<input type="text" name="descricao"></td>
                <td><input type="submit" value="Buscar" name="buscar"></td>
                </tbody>
            </table>
        </form>



        <%
           if (request.getAttribute("produto")!=null){
                Produto produto = (Produto)request.getAttribute("produto");

        %>
        <p>
            <%
                String mensagem2 = (String) request.getAttribute("mensagem");
                if(mensagem != null){
                    out.print(mensagem2);
                }
            %>
        </p>

        <form action="http://localhost:8080/JoaoVittorWeb_war_exploded//AlterarProdutoController" method="post">
            <table>
                <thead>
                    <tr><th colspan="2">Alteração/Exclusão de Produto
                            <input type="hidden" name="idProduto" value="<%out.print(produto.getIdProduto());%>"/></th> </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Descrição</td>
                    <td><input type="text" name="descricao" value="<%out.print(produto.getDescricao());%>"></td>
                    <td>Quantidade</td>
                    <td><input type="text" name="quantidade" value="<%out.print(produto.getQuantidade());%>"></td>
                    <td>Fornecedor</td>]
                    <td><input type="text" name="fornecedor" value="<%out.print(produto.getFornecedor());%>"></td>
                    <td>Preço</td>
                    <td><input type="text" name="preco" value="<%out.print(produto.getPreco());%>"></td>
                </tr>
                <tr>
                    <td>Vendas On-line</td>
                    <td><input type="radio" name="vendasonline" value="sim"
                        <%if (produto.getVendasOnline().equals("sim")){out.print("checked=checked");}%>><label>Sim</label>
                        <input type="radio" name="vendasonline" value="nao"
                            <%if (produto.getVendasOnline().equals("nao")){out.print("checked=checked");}%>><label>Não</label>
                    </td>
                </tr>
                <tr style="vertical-align: text-bottom">
                    <td>
                        <input type="submit" value="Alterar">
                        <input type="reset" value="Limpar">
                        <a href="http://localhost:8080/JoaoVittorWeb_war_exploded//ExcluirProdutoController?id=<%out.print(produto.getIdProduto());%>">Excluir</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
        <% } %>

</body>
</html>
