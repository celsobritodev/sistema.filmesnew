package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dominio.Artista;
import erro.Excessao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.ArtistaDAO;


public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletTeste() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Artista a1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
			ArtistaDAO artistaDAO = new ArtistaDAO();
			artistaDAO.salvar(a1);
			response.getWriter().append("Inserido!");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Excessao e) {
			response.getWriter().append(e.getMessage()+"\n");
			e.printStackTrace();
		}
				
	
		
		
		
		
		
	}

}
