package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dominio.Artista;
import jakarta.servlet.http.HttpServletRequest;

public class Instanciar {

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
