package web;

import java.io.IOException;
import java.util.List;

import dominio.Filme;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.FilmeDAO;

public class ParticipacaoFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/participacao/listarFilmes.jsp";

	public ParticipacaoFilmes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmeDAO filmeDAO = new FilmeDAO();
		List<Filme> filmes = filmeDAO.buscarTodos();
		request.setAttribute("filmes", filmes);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
