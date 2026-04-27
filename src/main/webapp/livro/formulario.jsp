<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h1>Livro</h1>

<form action="livros" method="post">

    <input type="hidden" name="id" value="${livro.id}" />

    Título: <input type="text" name="titulo" value="${livro.titulo}" /><br/>
    Autor: <input type="text" name="autor" value="${livro.autor}" /><br/>
    Preço: <input type="text" name="preco" value="${livro.preco}" /><br/>

    <input type="submit" value="Salvar" />
</form>

<a href="livros">Voltar</a>

</body>
</html>