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

public class ArtistaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";
	private static String ERRO ="/publico/erro.jsp";

	public ArtistaInserir() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		Artista artista = Instanciar.artista(request);
		
	//	String nome = request.getParameter("nome");
	//	System.out.println("O nome: "+nome);
		
		
		
		try {
			artistaDAO.salvar(artista);
			List<Artista> artistas = artistaDAO.buscarTodosOrdenadosPorNome();
			request.setAttribute("artistas", artistas);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (Excessao e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher(ERRO).forward(request, response);
	
		}
		
		
		

	}

}
