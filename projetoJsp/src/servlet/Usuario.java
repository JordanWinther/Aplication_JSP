package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanProjetoJsp;
import dao.DaoUsuario;


@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected DaoUsuario daoUsuario = new DaoUsuario();   
    
    public Usuario() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			if(acao.equalsIgnoreCase("delete")){
				daoUsuario.delete(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String login = request.getParameter("login");
		
		String senha = request.getParameter("senha");
		
		BeanProjetoJsp usuario = new BeanProjetoJsp();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		daoUsuario.salvar(usuario);
		try{
		RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		request.setAttribute("usuarios", daoUsuario.listar());
		view.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
