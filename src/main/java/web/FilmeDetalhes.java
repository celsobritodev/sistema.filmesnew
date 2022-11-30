package web;

import java.io.IOException;
import java.util.List;

import dominio.Filme;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.FilmeDAO;

public class FilmeDetalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/filme/detalhes.jsp";

	public FilmeDetalhes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmeDAO filmeDAO = new FilmeDAO();
		Long codFilme = Long.parseLong(request.getParameter("cod"));
		Filme filme = filmeDAO.buscarPorCod(codFilme);
		
		request.setAttribute("filme", filme);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
