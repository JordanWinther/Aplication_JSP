package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


//import beans.BeanProjetoJsp;
import dao.DaoLogin;
import dao.DaoUsuario;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public DaoLogin daoLogin = new DaoLogin();
	public DaoUsuario daoUsuario = new DaoUsuario();
    
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//BeanProjetoJsp beanProjetoJsp = new BeanProjetoJsp();
		String login = (request.getParameter("login"));
		String senha = (request.getParameter("senha"));
		
			if(daoLogin.validarLogin(login, senha)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
				request.setAttribute("usuarios",daoUsuario.listar());
				dispatcher.forward(request, response);
				JOptionPane.showMessageDialog(null, "Usuário encontrado.");
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
				dispatcher.forward(request, response);
				JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
