package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDao;
import model.Hobby;
import model.Pessoa;

@WebServlet("/adicionarPessoa")
public class AdicionarPessoa extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");
		String[] hobbies = request.getParameterValues("hobby");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTime(time);
		
		for(int i=0; i<hobbies.length; i++) {
			Hobby hobby = new Hobby(hobbies[i]);
			pessoa.addHobby(hobby);
		}
		
		PessoaDao pessoaDao = PessoaDao.getInstance();
		pessoaDao.addPessoa(pessoa);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.print("<title> lista 1 </title>");
		out.println("</head>");
		out.println("<body>");
			String pessoaRecemCadastrada = "A pessoa " + pessoa.getNome()+" recem cadastrada torce pro time " + pessoa.getTime() + " e tem como hobbies:<br>";
			int i = 1;
			for (Hobby hobby : pessoa.getHobbies()) {
				pessoaRecemCadastrada += i +"- "+ hobby.toString() + "<br>";
				i++;
			}
			out.println(pessoaRecemCadastrada);
			out.println("<br>Lista:<br>" + pessoaDao.toString() +"<br>");
			out.println("<a href='./formulario.html'>return</a>");
		out.println("</body>");
		
		
		out.println("</html>");
	}
}
