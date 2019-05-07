package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PersonDao;
import model.Person;

@WebServlet("/login")
public class Login extends HttpServlet{
	private PersonDao pd = PersonDao.getInstance();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Person person = new Person(username, password);
		HttpSession session = request.getSession();
		
		if(pd.containsPerson(person)) { //o metodo containsPerson retorna verdadeiro se existir a pessoa
			session.setAttribute("userLogged", username);
			response.sendRedirect("initialView"); //servlet que da um dispatch para success.html
		}
		else {
			System.out.println("redirecionou pra errorView");
			response.sendRedirect("errorView"); //servlet que da um dispatch para error.html
		}
	}
}
