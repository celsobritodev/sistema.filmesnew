package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;
import erro.Excessao;
import servico.ValidacaoException;

public class ParticipacaoDAO {
	
	private Connection con = Conexao.getConnection();

	

	public void validar(Participacao participacao) throws ValidacaoException {
		
		List<String> erros = new ArrayList<>();
		if (participacao.getPersonagem()==null) {
			erros.add("Favor preencher o campo personagem");
		}
		if (participacao.getArtista()==null) {
			erros.add("Favor informar um artista");
		}
     	if (participacao.getFilme()==null) {
			erros.add("Favor informar um filme");			
		}
		if (participacao.getDesconto()==null) {
			erros.add("Favor preencher um valor valido para o desconto");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação",erros);
		}
		
	}
	
	
	
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
	
	
	
	
	public void salvar(Participacao participacao) throws Excessao {
		Long codParticipacao = participacao.getCodParticipacao();
		if(codParticipacao!=null && codParticipacao!=0) {
			Participacao participacaoExiste = buscarPartipacaoExataCodDiferente(codParticipacao,
					participacao.getPersonagem(),
                    participacao.getArtista(),
                    participacao.getFilme());
            if (participacaoExiste !=null) {
            	throw new Excessao("Ja existe uma participacao com estes dados!", 1);
            }
			this.alterar(participacao);
		} else {
			Participacao participacaoExiste = buscarPartipacaoExata(participacao.getPersonagem(),
                    participacao.getArtista(),
                    participacao.getFilme());
            if (participacaoExiste !=null) {
            	throw new Excessao("Ja existe uma participacao com estes dados!", 1);
            }
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
	
	

	public Participacao buscarPartipacaoExata(String personagem, Artista artista,Filme filme) {
		String sql = "SELECT * FROM TB_PARTICIPACAO WHERE personagem =? AND codArtista=? AND codFilme=?";
		PreparedStatement preparador;
		Participacao participacao = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, personagem);
			preparador.setLong(2, artista.getCodArtista());
			preparador.setLong(3,filme.getCodFilme());
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
		
		public Participacao buscarPartipacaoExataCodDiferente(Long codParticipacao, String personagem, Artista artista,Filme filme) {
			String sql = "SELECT * FROM TB_PARTICIPACAO WHERE codParticipacao<>? AND personagem =? AND codArtista=? AND codFilme=?";
			PreparedStatement preparador;
			Participacao participacao = null;
			try {
				preparador = con.prepareStatement(sql);
				preparador.setLong(1,codParticipacao);
				preparador.setString(2, personagem);
				preparador.setLong(3, artista.getCodArtista());
				preparador.setLong(4,filme.getCodFilme());
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
	
	
	
}
