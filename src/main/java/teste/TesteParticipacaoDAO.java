package teste;

import java.util.List;

import dominio.Participacao;
import persistencia.ParticipacaoDAO;

public class TesteParticipacaoDAO {

public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
	     testBuscarPorCod();

	}

	public static void testCadastrar() {

		Participacao f1 = new Participacao(null, "O aviador", 170, 2005);
		Participacao f2 = new Participacao(null, "Titanicr", 195, 1997);
		
		ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		participacaoDAO.cadastrar(f1);
		participacaoDAO.cadastrar(f2);
	}
	
	
	public static void testAlterar() {
		Participacao f1 = new Participacao(1L, "O aviador maluco", 170, 2005);
		
		ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		participacaoDAO.alterar(f1);
	}
	
	
	public static void testExcluir() {
		
		Participacao f2 = new Participacao(3L, "Titanicr", 195, 1997);
	
		ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		participacaoDAO.excluir(f2);
	}
	
	
	public static void testBuscarTodos() {
		
	    ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		List<Participacao> participacaos = participacaoDAO.buscarTodos();
		
		for(Participacao participacao:participacaos) {
			System.out.println(participacao.getCodParticipacao()+" "+participacao.getAno());
			System.out.println(participacao.getDuracao()+participacao.getTitulo());
			System.out.println("-------------------------------------------");
		}
		
	}
	


	public static void testBuscarPorCod() {
	    ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
		System.out.println(participacaoDAO.buscarPorCod(1L));
	}

}
