package teste;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dominio.Artista;
import persistencia.ArtistaDAO;

public class TesteArtistaDAO {

public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
	     testBuscarPorCod();

	}

	public static void testCadastrar() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		try {
			Artista artista1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.38"),
					sdf.parse("11/05/1974"));
			Artista artista2 = new Artista(null, "Cate Blanchett", "Australia", new BigDecimal("5000000.49"),
					sdf.parse("29/01/1983"));
			Artista artista3 = new Artista(null, "Kate Winslet", "UK", new BigDecimal("8000000.51"),
					sdf.parse("04/09/1999"));
			ArtistaDAO artistaDAO = new ArtistaDAO();
			artistaDAO.cadastrar(artista1);
			artistaDAO.cadastrar(artista2);
			artistaDAO.cadastrar(artista3);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	
	}
	
	
	public static void testAlterar() {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Artista artista = new Artista(6L, "Cuca", "Brasil", new BigDecimal("500.73"),
					sdf.parse("03/11/1966"));
			ArtistaDAO artistaDAO = new ArtistaDAO();
			artistaDAO.alterar(artista);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void testExcluir() {
		
		Artista artista = new Artista();
		artista.setCodArtista(4L);
	
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.excluir(artista);
	}
	
	
	public static void testBuscarTodos() {
		
	    ArtistaDAO artistaDAO = new ArtistaDAO();
		List<Artista> artistas = artistaDAO.buscarTodos();
		
		for(Artista artista:artistas) {
			
			DecimalFormat df = new DecimalFormat("0.##");
		    String formatCache = df.format(artista.getCache());
		    
			//    java.util.Date artistaNasc = artista.getNascimento();
		    SimpleDateFormat formatoDestino = new SimpleDateFormat("dd-MM-yyyy");
		    String formatDiaMesAno = formatoDestino.format(artista.getNascimento());
		    
			System.out.println(artista.getCodArtista()+" "+formatCache);
			System.out.println(artista.getNacionalidade()+" "+formatDiaMesAno);
			System.out.println(artista.getNome());
			System.out.println("-------------------------------------------");
		}
		
	}
	


	public static void testBuscarPorCod() {
	    ArtistaDAO artistaDAO = new ArtistaDAO();
		System.out.println(artistaDAO.buscarPorCod(1L));
	}
}
