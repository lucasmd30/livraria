<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="pt_BR"/>

<html>
<body>

<h1>Livros</h1>

<a href="livros?acao=novo">Novo Livro</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Autor</th>
        <th>Preço</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="l" items="${livros}">
        <tr>
            <td>${l.id}</td>
            <td>${l.titulo}</td>
            <td>${l.autor}</td>
            <td>
                <fmt:formatNumber value="${l.preco}" type="currency" currencySymbol="R$" />
            </td>
            <td>
                <a href="livros?acao=editar&id=${l.id}">Editar</a>
                <a href="livros?acao=excluir&id=${l.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>