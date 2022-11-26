package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Participacao;

public class ParticipacaoDAO {
	
	private Connection con = Conexao.getConnection();

	public void cadastrar(Participacao participacao) {

		String sql = "INSERT INTO TB_PARTICIPACAO (codArtista,codFilme,desconto,personagem) VALUES (?,?,?,?)";
	
		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, participacao.getArtista().getCodArtista());
			preparador.setLong(2, participacao.getFilme().getCodFilme());
			preparador.setBigDecimal(3, participacao.getDesconto());
			preparador.setString(4, participacao.getPersonagem());
	
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrada com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	public void salvar(Participacao participacao) {
		if(participacao.getCodParticipacao()!=null && participacao.getCodParticipacao()!=0) {
			this.alterar(participacao);
		} else {
			this.cadastrar(participacao);
		}
	}
	
	

	public void alterar(Participacao participacao) {

		String sql = "UPDATE TB_PARTICIPACAO  SET codArtista=?,codFilme=?,desconto=?,personagem=? WHERE codParticipacao=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, participacao.getArtista().getCodArtista());
			preparador.setLong(2, participacao.getFilme().getCodFilme());
			preparador.setBigDecimal(2, participacao.getDesconto());
			preparador.setString(4, participacao.getPersonagem());
	        preparador.setLong(5, participacao.getCodParticipacao());
			preparador.execute();
			preparador.close();
			System.out.println("Alterada com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Participacao participacao) {

		String sql = "DELETE FROM TB_PARTICIPACAO WHERE codParticipacao=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, participacao.getCodParticipacao());
			preparador.execute();
			preparador.close();
			System.out.println("Excluida com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Participacao> buscarTodos() {

		String sql = "SELECT * FROM TB_PARTICIPACAO";
	   
		List<Participacao> participacaos = new ArrayList<Participacao>();

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Participacao participacao = new Participacao();
				participacao.setCodParticipacao(resultado.getLong("codParticipacao"));
				
				long codArtista = resultado.getLong("codArtista");
				ArtistaDAO artistaDAO = new ArtistaDAO();
				participacao.setArtista((artistaDAO.buscarPorCod(codArtista)));
				
				long codFilme = resultado.getLong("codFilme");
				FilmeDAO filmeDAO = new FilmeDAO();
				participacao.setFilme(filmeDAO.buscarPorCod(codFilme));			
				
				participacao.setDesconto(resultado.getBigDecimal("desconto"));
				participacao.setPersonagem(resultado.getString("personagem"));
				participacaos.add(participacao);
			}
			preparador.close();
			System.out.println("Listada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participacaos;

	}

	public Participacao buscarPorCod(Long codParticipacao) {
		String sql = "SELECT * FROM TB_PARTICIPACAO WHERE codParticipacao =?";
		PreparedStatement preparador;
		Participacao participacao = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setLong(1, codParticipacao);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				participacao = new Participacao();
				participacao.setCodParticipacao(resultado.getLong("codParticipacao"));
				
				long codArtista = resultado.getLong("codArtista");
				ArtistaDAO artistaDAO = new ArtistaDAO();
				participacao.setArtista((artistaDAO.buscarPorCod(codArtista)));
				
				long codFilme = resultado.getLong("codFilme");
				FilmeDAO filmeDAO = new FilmeDAO();
				participacao.setFilme(filmeDAO.buscarPorCod(codFilme));			
				
				participacao.setDesconto(resultado.getBigDecimal("desconto"));
				participacao.setPersonagem(resultado.getString("personagem"));
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participacao;

	}
	
	
	public List<Participacao> buscarPorPersonagem(String personagem) {
		String sql = "SELECT * FROM TB_PARTICIPACAO WHERE personagem LIKE ?";
		PreparedStatement preparador;
		List<Participacao> participacaos = new ArrayList<Participacao>();
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+personagem+"%");
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Participacao participacao = new Participacao();
				participacao = new Participacao();
				participacao.setCodParticipacao(resultado.getLong("codParticipacao"));
				
				long codArtista = resultado.getLong("codArtista");
				ArtistaDAO artistaDAO = new ArtistaDAO();
				participacao.setArtista((artistaDAO.buscarPorCod(codArtista)));
				
				long codFilme = resultado.getLong("codFilme");
				FilmeDAO filmeDAO = new FilmeDAO();
				participacao.setFilme(filmeDAO.buscarPorCod(codFilme));			
				
				participacao.setDesconto(resultado.getBigDecimal("desconto"));
				participacao.setPersonagem(resultado.getString("personagem"));
				participacaos.add(participacao);
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participacaos;

	}
	
	
	
	
	
	
}
