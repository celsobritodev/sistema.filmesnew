package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;

public class ArtistaFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";

	public ArtistaFiltrar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		String nome = request.getParameter("busca");
		List<Artista> artistas = artistaDAO.buscarPorNome(nome);
		request.setAttribute("artistas", artistas);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
