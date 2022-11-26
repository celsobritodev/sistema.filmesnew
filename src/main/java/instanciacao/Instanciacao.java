package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;
import persistencia.FilmeDAO;
import persistencia.ParticipacaoDAO;

/**
 * Servlet implementation class Instanciacao
 */
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Filme f1 = new Filme(null, "O aviador", 170, 2005);
		Filme f2 = new Filme(null, "Titanic", 195, 1997);
		try {
			Artista a1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
			Artista a2 = new Artista(null, "Cate Blanchett", "Australia", new BigDecimal("5000000.00"),
					sdf.parse("11/01/1983"));
			Artista a3 = new Artista(null, "Kate Winslet", "UK", new BigDecimal("8000000.00"), sdf.parse("04/09/1999"));
		
			// gravando filmes
			FilmeDAO filmeDAO = new FilmeDAO();
			filmeDAO.salvar(f1);
			filmeDAO.salvar(f2);
			
			// gravando artista
			ArtistaDAO artistaDAO = new ArtistaDAO();
			artistaDAO.salvar(a1);
			artistaDAO.salvar(a2);
			artistaDAO.salvar(a3);
			
			// colocando codigos que serao utilizados pelas participacoes
			f1.setCodFilme(1L);
			f2.setCodFilme(2L);
			a1.setCodArtista(1L);
			a2.setCodArtista(2L);
			a3.setCodArtista(3L);
			
			// gravando participacoes
        	Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000000.00"), f2, a1);
			Participacao p2 = new Participacao(null, "Howard Hughes", new BigDecimal("1000000.00"), f1, a1);
			Participacao p3 = new Participacao(null, "Rose Bukater", new BigDecimal("1000000.00"), f2, a3);
			Participacao p4 = new Participacao(null, "Katharine Heburn", new BigDecimal("500000.00"), f1, a2);
			ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
			participacaoDAO.salvar(p1);
			participacaoDAO.salvar(p2);
			participacaoDAO.salvar(p3);
			participacaoDAO.salvar(p4);
			
			response.getWriter().append("Cache total do filme "+f1+"\n");
			response.getWriter().append( f1.cacheTotal()+"\n");
			
			
			response.getWriter().append("Pronto!");
		
		} catch (ParseException e) {
		
			response.getWriter().append("Erro ao instanciar data. Instância não criada!!");
		}
	}

}
