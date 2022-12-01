package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import jakarta.servlet.http.HttpServletRequest;
import persistencia.ArtistaDAO;
import persistencia.FilmeDAO;

public class Instanciar {

	
public static Participacao participacao(HttpServletRequest request) {
		
		ArtistaDAO artistaDAO = new ArtistaDAO();
		FilmeDAO filmeDAO = new FilmeDAO();
		
		Participacao participacao = new Participacao();

		String codParticipacao = request.getParameter("codParticipacao");
		if (codParticipacao != null && !codParticipacao.isEmpty()) {
			try {
				participacao.setCodParticipacao(Long.parseLong(codParticipacao));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codParticipacao invalido");
			}
		}

		String personagem = request.getParameter("personagem");
		if (personagem != null && !personagem.isEmpty()) {
			participacao.setPersonagem(personagem);
		}

		String desconto = request.getParameter("desconto");
		if (desconto != null && !desconto.isEmpty()) {
			try {
				participacao.setDesconto(new BigDecimal(desconto));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: desconto invalido");
			}
		}

		String codArtista = request.getParameter("codArtista");
		if (codArtista != null && !codArtista.isEmpty()) {
			try {
				Artista artista = artistaDAO.buscarPorCod(Long.parseLong(codArtista));
				participacao.setArtista(artista);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
		}

		String codFilme = request.getParameter("codFilme");
		if (codFilme != null && !codFilme.isEmpty()) {
			try {
				Filme filme = filmeDAO.buscarPorCod(Long.parseLong(codFilme));
				participacao.setFilme(filme);
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
		}

		return participacao;
	}
	
	
	public static Artista artista(HttpServletRequest request) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Artista artista = new Artista();

		String codArtista = request.getParameter("codArtista");
		if (codArtista != null && !codArtista.isEmpty()) {
			try {
				artista.setCodArtista(Long.parseLong(codArtista));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		String nome = request.getParameter("nome");
		if (nome != null && !nome.isEmpty()) {
			artista.setNome(nome);
		}
		String nacionalidade = request.getParameter("nacionalidade");
		if (nacionalidade != null && !nacionalidade.isEmpty()) {
			artista.setNacionalidade(nacionalidade);
		}
		
		String cache = request.getParameter("cache");
		if (cache != null && !cache.isEmpty()) {
			try {
				artista.setCache(new BigDecimal(cache));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}

		String nascimento = request.getParameter("nascimento");
		if (nascimento != null && !nascimento.isEmpty()) {
			try {
				artista.setNascimento(sdf.parse(nascimento));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return artista;

	}

}
