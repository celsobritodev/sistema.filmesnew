package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;

public class ArtistaNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/formInserir.jsp";

	public ArtistaNovo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setAttribute("artista", new Artista());
		request.getRequestDispatcher(DESTINO).forward(request, response);

		

	}

}
