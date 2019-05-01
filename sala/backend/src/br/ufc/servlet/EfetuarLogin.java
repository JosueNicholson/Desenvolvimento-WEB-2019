package br.ufc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.dao.PessoaDao;
import br.ufc.model.Pessoa;

@WebServlet("/efetuarLogin")
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PessoaDao pessoaDao = new PessoaDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Pessoa pessoa = pessoaDao.buscarPessoa(username, password);
		
		HttpSession sessao = request.getSession();
		
		if(pessoa!=null) {
			sessao.setAttribute("usuarioLogado", username);
			response.sendRedirect("telaInicial");
		}
		else {
			response.sendRedirect("loginFormulario");
		}
	}


}
