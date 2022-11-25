package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Artista;

public class ArtistaDAO {
	
	private Connection con = Conexao.getConnection();

	public void cadastrar(Artista artista) {

		String sql = "INSERT INTO TB_ARTISTA (cache,nacionalidade,nascimento,nome) VALUES (?,?,?,?)";
	
		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setBigDecimal(1, artista.getCache());
			preparador.setString(2, artista.getNacionalidade());
			
			java.sql.Date mySqlDate = new java.sql.Date(artista.getNascimento().getTime());
		
			preparador.setDate(3, mySqlDate);
			preparador.setString(4, artista.getNome());
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	public void salvar(Artista artista) {
		if(artista.getCodArtista()!=null && artista.getCodArtista()!=0) {
			this.alterar(artista);
		} else {
			this.cadastrar(artista);
		}
	}
	
	

	public void alterar(Artista artista) {

		String sql = "UPDATE TB_ARTISTA  SET cache=?,nacionalidade=?,nascimento=?,nome=? WHERE codArtista=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setBigDecimal(1, artista.getCache());
			preparador.setString(2, artista.getNacionalidade());
			
			java.sql.Date mySqlDate = new java.sql.Date(artista.getNascimento().getTime());
			
			preparador.setDate(3, mySqlDate);
			preparador.setString(4, artista.getNome());
			preparador.setLong(5, artista.getCodArtista());
			preparador.execute();
			preparador.close();
			System.out.println("Alterado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Artista artista) {

		String sql = "DELETE FROM TB_ARTISTA WHERE codArtista=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, artista.getCodArtista());
			preparador.execute();
			preparador.close();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Artista> buscarTodos() {

		String sql = "SELECT * FROM TB_ARTISTA";

		List<Artista> artistas = new ArrayList<Artista>();

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Artista artista = new Artista();
				artista.setCodArtista(resultado.getInt("codArtista"));
				artista.setCache(resultado.getBigDecimal("cache"));
				artista.setNacionalidade(resultado.getString("nacionalidade"));
				artista.setNascimento(resultado.getDate("nascimento"));
				artista.setNome(resultado.getString("nome"));
				artistas.add(artista);
			}
			preparador.close();
			System.out.println("Listado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistas;

	}

	public Artista buscarPorCod(Integer codArtista) {
		String sql = "SELECT * FROM TB_ARTISTA WHERE codArtista =?";
		PreparedStatement preparador;
		Artista artista = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, codArtista);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				artista = new Artista();
				artista.setCodArtista(resultado.getInt("codArtista"));
				artista.setCache(resultado.getBigDecimal("cache"));
				artista.setNacionalidade(resultado.getString("nacionalidade"));
				artista.setNascimento(resultado.getDate("nascimento"));
				artista.setNome(resultado.getString("nome"));
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artista;

	}
	
	
	public List<Artista> buscarPorNome(String nome) {
		String sql = "SELECT * FROM TB_ARTISTA WHERE nome LIKE ?";
		PreparedStatement preparador;
		List<Artista> artistas = new ArrayList<Artista>();
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Artista artista = new Artista();
				artista.setCodArtista(resultado.getInt("codArtista"));
				artista.setCache(resultado.getBigDecimal("cache"));
				artista.setNacionalidade(resultado.getString("nacionalidade"));
				artista.setNascimento(resultado.getDate("nascimento"));
				artista.setNome(resultado.getString("nome"));
				artistas.add(artista);
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistas;

	}
	
	
	

}
