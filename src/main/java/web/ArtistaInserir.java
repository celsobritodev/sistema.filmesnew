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
import servico.ValidacaoException;

public class ArtistaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/listar.jsp";
	private static String FORM ="/artista/formInserir.jsp";
	private static String ERRO ="/publico/erro.jsp";

	public ArtistaInserir() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistaDAO artistaDAO = new ArtistaDAO();
		Artista artista = Instanciar.artista(request);
		
		try {
			artistaDAO.validar(artista);
			artistaDAO.salvar(artista);
			List<Artista> artistas = artistaDAO.buscarTodosOrdenadosPorNome();
			request.setAttribute("artistas", artistas);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (Excessao e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
	        request.setAttribute("erros", e.getErros());
	        request.setAttribute("artista", artista);
	        request.getRequestDispatcher(FORM).forward(request, response);
		}
		
		
		

	}

}
