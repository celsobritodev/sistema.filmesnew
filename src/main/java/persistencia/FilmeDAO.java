package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Filme;

public class FilmeDAO {
	
	private Connection con = Conexao.getConnection();

	public void cadastrar(Filme filme) {

		String sql = "INSERT INTO TB_FILME (ano,duracao,titulo) VALUES (?,?,?)";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, filme.getAno());
			preparador.setLong(2, filme.getDuracao());
			preparador.setString(3, filme.getTitulo());
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	public void salvar(Filme filme) {
		if(filme.getCodFilme()!=null && filme.getCodFilme()!=0) {
			this.alterar(filme);
		} else {
			this.cadastrar(filme);
		}
	}
	
	

	public void alterar(Filme filme) {

		String sql = "UPDATE TB_FILME  SET ano=?,duracao=?,titulo=? WHERE codFilme=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, filme.getAno());
			preparador.setLong(2, filme.getDuracao());
			preparador.setString(3, filme.getTitulo());
			preparador.setLong(4, filme.getCodFilme());
			preparador.execute();
			preparador.close();
			System.out.println("Alterado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Filme filme) {

		String sql = "DELETE FROM TB_FILME WHERE codFilme=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, filme.getCodFilme());
			preparador.execute();
			preparador.close();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Filme> buscarTodos() {

		String sql = "SELECT * FROM TB_FILME";

		List<Filme> filmes = new ArrayList<Filme>();

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Filme filme = new Filme();
				filme.setCodFilme(resultado.getInt("codFilme"));
				filme.setAno(resultado.getInt("ano"));
				filme.setDuracao(resultado.getInt("duracao"));
				filme.setTitulo(resultado.getString("titulo"));
				filmes.add(filme);
			}
			preparador.close();
			System.out.println("Listado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmes;

	}

	public Filme buscarPorCod(Integer codFilme) {
		String sql = "SELECT * FROM TB_FILME WHERE codFilme =?";
		PreparedStatement preparador;
		Filme filme = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, codFilme);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				filme = new Filme();
				filme.setCodFilme(resultado.getInt("codFilme"));
				filme.setAno(resultado.getInt("ano"));
				filme.setDuracao(resultado.getInt("duracao"));
				filme.setTitulo(resultado.getString("titulo"));
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filme;

	}
	
	
	public List<Filme> buscarPorTitulo(String titulo) {
		String sql = "SELECT * FROM TB_FILME WHERE titulo LIKE ?";
		PreparedStatement preparador;
		List<Filme> filmes = new ArrayList<Filme>();
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+titulo+"%");
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Filme filme = new Filme();
				filme.setCodFilme(resultado.getInt("codFilme"));
				filme.setAno(resultado.getInt("ano"));
				filme.setDuracao(resultado.getInt("duracao"));
				filme.setTitulo(resultado.getString("titulo"));
				filmes.add(filme);
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmes;

	}
	
	

	
	

}
