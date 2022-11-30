package web;

import java.io.IOException;
import java.util.List;

import dominio.Filme;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.FilmeDAO;

public class FilmeResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/filme/resultadoBusca.jsp";

	public FilmeResultado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmeDAO filmeDAO = new FilmeDAO();
		String nome = request.getParameter("titulo");
		int anoMin = Integer.parseInt(request.getParameter("anoMin"));
		int anoMax = Integer.parseInt(request.getParameter("anoMax"));
		List<Filme> filmes = filmeDAO.buscarPorNomeAno(nome, anoMin, anoMax);
		request.setAttribute("filmes", filmes);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
