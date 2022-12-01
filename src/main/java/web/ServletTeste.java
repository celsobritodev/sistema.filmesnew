package web;

import java.io.IOException;
import java.util.List;

import dominio.Filme;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.FilmeDAO;


public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletTeste() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		
	//	ArtistaDAO artistaDAO = new ArtistaDAO();
		FilmeDAO filmeDAO = new FilmeDAO();
	//	ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
/*		
 * 
 * 
		// tentando inserir
		try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Artista a1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
			artistaDAO.salvar(a1);
			response.getWriter().append("Inserido!");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Excessao e) {
			response.getWriter().append(e.getMessage()+"\n");
			e.printStackTrace();
		}
*/				

		
/*		
        // tentando atualizar cache	
		try {
			Artista a1=artistaDAO.buscarPorCod(19L);
			a1.setCache(a1.getCache().add(new BigDecimal("1.00")));
			artistaDAO.salvar(a1);
			response.getWriter().append("Atualizado!");
		} catch (Excessao e) {
			response.getWriter().append(e.getMessage()+"\n");
			e.printStackTrace();
		}
*/		
		
	
/*		
        // tentando atualizar um artista com um nome que ja existe	
		try {
			Artista a1=artistaDAO.buscarPorCod(19L);
			a1.setNome("Cate Blanchett");
			artistaDAO.salvar(a1);
			response.getWriter().append("Atualizado!");
		} catch (Excessao e) {
			response.getWriter().append(e.getMessage()+"\n");
			e.printStackTrace();
		}
*/
		
/*
		
		// tentando inserir uma nova participacao
		try {
     		Filme f1 = filmeDAO.buscarPorCod(12L);
			Artista a1 = artistaDAO.buscarPorCod(19L);
			Participacao p1 = new Participacao(null, "Joaozinho", new BigDecimal("0.00"), f1, a1);
			participacaoDAO.salvar(p1);
			response.getWriter().append("Participacao inserida!");
		} catch (Excessao e) {
			response.getWriter().append(e.getMessage()+"\n");
			e.printStackTrace();
		}
		
	}
	
*/

		
/*		
	// tentando inserir uma participacao repetida
	try {
 		Filme f1 = filmeDAO.buscarPorCod(12L);
		Artista a1 = artistaDAO.buscarPorCod(19L);
		Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("0.00"), f1, a1);
		participacaoDAO.salvar(p1);
		response.getWriter().append("Participacao inserida!");
	} catch (Excessao e) {
		response.getWriter().append(e.getMessage()+"\n");
		e.printStackTrace();
	}
	
*/
	
   // realizando a consulta de filmes
	//List<Filme> filmes = filmeDAO.buscar();
	List<Filme> filmes = filmeDAO.buscarPorNomeAno("o", 1997, 2010);
	for(Filme x: filmes) {
		response.getWriter().append(x+"\n");
	
}	

	}
	

}
