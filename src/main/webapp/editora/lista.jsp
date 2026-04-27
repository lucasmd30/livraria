<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Editoras</h1>

<a href="editoras?acao=novo">Nova Editora</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Cidade</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="e" items="${editoras}">
        <tr>
            <td>${e.id}</td>
            <td>${e.nome}</td>
            <td>${e.cidade}</td>
            <td>
                <a href="editoras?acao=editar&id=${e.id}">Editar</a>
                <a href="editoras?acao=excluir&id=${e.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>