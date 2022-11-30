package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;
import persistencia.FilmeDAO;

public class ParticipacaoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/participacao/formInserir.jsp";

	public ParticipacaoNovo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmeDAO filmeDAO = new FilmeDAO();
		ArtistaDAO artistaDAO = new ArtistaDAO();
		
		Long codFilme = Long.parseLong(request.getParameter("codFilme"));
		Filme filme = filmeDAO.buscarPorCod(codFilme);
		
		Participacao participacao = new Participacao();
		participacao.setFilme(filme);
		
		List<Artista> artistas = artistaDAO.buscarTodos();
		
		request.setAttribute("participacao", participacao);
	    request.setAttribute("artistas", artistas);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
