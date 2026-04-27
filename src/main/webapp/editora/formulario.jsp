<%@ page contentType="text/html;charset=UTF-8" %>

<h1>Editora</h1>

<form action="editoras" method="post">

    <input type="hidden" name="id" value="${editora.id}" />

    Nome: <input type="text" name="nome" value="${editora.nome}" /><br/>
    Cidade: <input type="text" name="cidade" value="${editora.cidade}" /><br/>

    <input type="submit" value="Salvar" />
</form>

<a href="editoras">Voltar</a>