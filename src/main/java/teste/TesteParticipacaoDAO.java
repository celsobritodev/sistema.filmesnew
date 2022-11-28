package teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import erro.Excessao;
import persistencia.ParticipacaoDAO;

public class TesteParticipacaoDAO {

public static void main(String[] args) {
		
		testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
	     //testBuscarPorCod();
	    //testBuscarPorPersonagem();

	}

	public static void testCadastrar() {

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Filme f1 = new Filme(1L, "O aviador", 170, 2005);
		Filme f2 = new Filme(2L, "Titanicr", 195, 1997);
		try {
			Artista a1 = new Artista(1L, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
			Artista a2 = new Artista(2L, "Cate Blanchett", "Australia", new BigDecimal("5000000.00"),
					sdf.parse("11/01/1983"));
			Artista a3 = new Artista(3L, "Kate Winslet", "UK", new BigDecimal("8000000.00"), sdf.parse("04/09/1999"));

			Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000000.00"), f2, a1);
			Participacao p2 = new Participacao(null, "Howard Hughes", new BigDecimal("1000000.00"), f1, a1);
			Participacao p3 = new Participacao(null, "Rose Bukater", new BigDecimal("1000000.00"), f2, a3);
			Participacao p4 = new Participacao(null, "Katharine Heburn", new BigDecimal("500000.00"), f1, a2);

			ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
			participacaoDAO.salvar(p1);
			participacaoDAO.salvar(p2);
			participacaoDAO.salvar(p3);
			participacaoDAO.salvar(p4);
			
		} catch (ParseException e) {
		
			System.out.println("Erro ao criar objetos para cadastrar");
			
		} catch (Excessao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void testAlterar() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Filme f1 = new Filme(1L, "O aviador", 170, 2005);
	
		try {
			Artista a1 = new Artista(1L, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
		
			Participacao p1 = new Participacao(1L, "Jack Dawson", new BigDecimal("2000000.00"), f1, a1);
			
			ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
			participacaoDAO.alterar(p1);
		
			
		} catch (ParseException e) {
		
			System.out.println("Erro ao criar objetos para alterar");
			
		}
		
	
	}
	
	
	public static void testExcluir() {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Filme f1 = new Filme(3L, "O aviador", 170, 2005);
	
		try {
			Artista a1 = new Artista(5L, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
		
			Participacao p1 = new Participacao(5L, "Jack Dawson", new BigDecimal("2000000.00"), f1, a1);
			
			ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
			participacaoDAO.excluir(p1);
		
			
		} catch (ParseException e) {
		
			System.out.println("Erro ao criar objetos para excluir");
			
		}
	
	}
	
	
	public static void testBuscarTodos() {
		
	    ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		List<Participacao> participacaos = participacaoDAO.buscarTodos();
		
		for(Participacao participacao:participacaos) {
			System.out.println(participacao.getCodParticipacao()+" "+participacao.getArtista().getNome());
			System.out.println(participacao.getFilme().getTitulo()+" "+participacao.getDesconto());
			System.out.println(participacao.getPersonagem());
			System.out.println("-------------------------------------------");
		}
		
	}
	


	public static void testBuscarPorCod() {
	    ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		System.out.println(participacaoDAO.buscarPorCod(1L));
	}
	
	
	public static void testBuscarPorPersonagem() {
	    ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		System.out.println(participacaoDAO.buscarPorPersonagem("Howard"));
	}
	
	  
}
