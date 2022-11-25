package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Artista implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codArtista;
	private String nome;
	private String nacionalidade;
	private BigDecimal cache;
	private Date nascimento;

	private List<Participacao> participacoes;

	public Artista() {

		participacoes = new ArrayList<>();
	}

	public Artista(Long codArtista, String nome, String nacionalidade, BigDecimal cache, Date nascimento) {
		super();
		this.codArtista = codArtista;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.cache = cache;
		this.nascimento = nascimento;
		participacoes = new ArrayList<>();
	}

	public Long getCodArtista() {
		return codArtista;
	}

	public void setCodArtista(Long codArtista) {
		this.codArtista = codArtista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public BigDecimal getCache() {
		return cache;
	}

	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	public void addParticipacao(Participacao x) {
		this.participacoes.add(x);
		x.setArtista(this);
	}

	public void removeParticipacao(Participacao x) {
		this.participacoes.remove(x);
	}

	@Override
	public String toString() {
		return "Artista [codArtista=" + codArtista + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", cache="
				+ cache + ", nascimento=" + nascimento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codArtista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(codArtista, other.codArtista);
	}

}
