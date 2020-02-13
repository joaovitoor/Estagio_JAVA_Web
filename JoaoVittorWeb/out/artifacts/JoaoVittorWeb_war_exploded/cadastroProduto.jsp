<%--
  Created by IntelliJ IDEA.
  User: 15836968730
  Date: 07/02/2020
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Produto</title>
</head>
<body>

    <p style="text-align: center">
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            if(mensagem != null){
                out.print(mensagem);
            }
        %>
    </p>

    <form action="http://localhost:8080/JoaoVittorWeb_war_exploded//CadastrarProdutoController" method="post" name="cadastroProduto">

       <table>
           <tr>
               <td>Descrição</td>
               <td><input type="text" name="descricao"></td>
           </tr>
           <tr>
               <td>Quantidade</td>
               <td><input type="text" name="quantidade"></td>
           </tr>
           <tr>
               <td>Fornecedor</td>
               <td><input type="text" name="fornecedor"></td>
           </tr>
           <tr>
               <td>Preço</td>
               <td><input type="text" name="preco"></td>
           </tr>
           <tr>
               <td>Vendas On-line</td>
               <td><input type="radio" name="vendasonline" value="sim"><label>Sim</label>
                    <input type="radio" name="vendasonline" value="nao"><label>Não</label></td>
           </tr>
           <tr>
               <td><input type="submit" value="Salvar"></td>
           </tr>
       </table>

    </form>

</body>
</html>
