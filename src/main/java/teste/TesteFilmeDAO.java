package teste;

import java.util.List;

import dominio.Filme;
import persistencia.FilmeDAO;

public class TesteFilmeDAO {

public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
	     testBuscarPorCod();

	}

	public static void testCadastrar() {

		Filme f1 = new Filme(null, "O aviador", 170, 2005);
		Filme f2 = new Filme(null, "Titanicr", 195, 1997);
		
		FilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.cadastrar(f1);
		filmeDAO.cadastrar(f2);
	}
	
	
	public static void testAlterar() {
		Filme f1 = new Filme(1L, "O aviador maluco", 170, 2005);
		
		FilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.alterar(f1);
	}
	
	
	public static void testExcluir() {
		
		Filme f2 = new Filme(3L, "Titanicr", 195, 1997);
	
		FilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.excluir(f2);
	}
	
	
	public static void testBuscarTodos() {
		
	    FilmeDAO filmeDAO = new FilmeDAO();
		List<Filme> filmes = filmeDAO.buscarTodos();
		
		for(Filme filme:filmes) {
			System.out.println(filme.getCodFilme()+" "+filme.getAno());
			System.out.println(filme.getDuracao()+filme.getTitulo());
			System.out.println("-------------------------------------------");
		}
		
	}
	


	public static void testBuscarPorCod() {
	    FilmeDAO filmeDAO = new FilmeDAO();
		System.out.println(filmeDAO.buscarPorCod(1L));
	}
}
