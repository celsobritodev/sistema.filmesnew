package web;

import java.io.IOException;
import dominio.Artista;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;

public class ArtistaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/formEditar.jsp";

	public ArtistaEditar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		Long codArtista = Long.parseLong(request.getParameter("cod"));
		Artista artista = artistaDAO.buscarPorCod(codArtista);
		request.setAttribute("artista", artista);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
