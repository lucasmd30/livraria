<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <td>${l.preco}</td>
            <td>
                <a href="livros?acao=editar&id=${l.id}">Editar</a>
                <a href="livros?acao=excluir&id=${l.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>