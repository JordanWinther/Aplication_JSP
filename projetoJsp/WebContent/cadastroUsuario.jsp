<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet"   type="text/css"  href="css/estilo2.css">
<title>Cadastrar usuário</title>
</head>
	<body>
		<div>
			<img alt="topo" src="topo2.jpg">
		</div>
		<form class="colorForm"  action="salvarUsuario" method="post">
			
							
					Usuário:
					<input type="text" size="30" name="login"  id="login"> 
					
					Senha:
					<input type="password" size="30" name="senha"  id="senha"> 

					<input type="submit" name="salvar" value="enviar"> 
					<input type="reset" name="BTApaga" value="apagar">
				
		</form>
		
		<table>
				<c:forEach items="${usuarios}"  var="user">
					<tr>
						<td style="width:150px"><c:out value="${user.login}"></c:out> </td>
						<td><c:out value="${user.senha}"></c:out></td>
						<td><a href="salvarUsuario?acao=delete&user=${user.login }" >Excluir</a></td>
					</tr>
				</c:forEach>
		</table>
	
	</body>
</html>