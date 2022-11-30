package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import erro.Excessao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;

public class ArtistaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";

	public ArtistaExcluir() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		Long codArtista = Long.parseLong(request.getParameter("cod"));
		Artista artista = artistaDAO.buscarPorCod(codArtista);
		try {
			artistaDAO.excluir(artista);
			List<Artista> artistas = artistaDAO.buscarTodosOrdenadosPorNome();
			request.setAttribute("artistas", artistas);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (Excessao e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);

		}

	}

}
