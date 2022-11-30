package web;

import java.io.IOException;
import java.util.List;

import dominio.Artista;
import dominio.Participacao;
import erro.Excessao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;
import persistencia.FilmeDAO;
import persistencia.ParticipacaoDAO;
import servico.ValidacaoException;

public class ParticipacaoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/filme/detalhesCompleto.jsp";
	private static String FORM ="/participacao/formInserir.jsp";
	private static String ERRO = "/public/erro.jsp";

	public ParticipacaoInserir() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FilmeDAO filmeDAO = new FilmeDAO();
		ParticipacaoDAO participacaoDAO = new Participacao();
		ArtistaDAO artistaDAO = new ArtistaDAO();
		
		Participacao participacao = Instanciar.participacao(request);
		
		try {
			participacaoDAO.validar(participacao);
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
		
		
		
		
		request.setAttribute("artistas", artistas);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
