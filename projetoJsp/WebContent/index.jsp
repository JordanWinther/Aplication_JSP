<jsp:useBean id="calcula"  class="beans.BeanProjetoJsp"   scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"  type="text/css"  href="css/estilo2.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sistema em Java web</title>
</head>
<body class="imagem_de_fundo box">
	
		<div >
				<img class="imgTop" alt="topo" src="topo2.jpg">
		</div>
				<div class="colorForm">
				
							<form action="LoginServlet" method="post">
								<label>Usuário</label>
								<input type="text" name="login"  id="login">
								
								<label>Senha</label>
								<input type="text" name="senha" id="senha">
								
								<input type="submit" value="Enviar">
							</form>
							
							
							<form class="paddingTopBtn" action="cadastroUsuario.jsp">
								<button type="submit" >Novo Usuário</button>
							</form>	
				</div>
				
				
	
					<div  class=""><img class="img2" alt="Fundo Novo" src="css/fundoNovo.png"> </div>
			
	</body>
</html>