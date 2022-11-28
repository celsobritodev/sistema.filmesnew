package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;

public class ArtistaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";

	public ArtistaListar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		List<Artista> artistas = artistaDAO.buscarTodosOrdenadosPorNome();
		request.setAttribute("artistas", artistas);
		request.getRequestDispatcher(DESTINO).forward(request, response);

		

	}

}
