package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codParticipacao;
	private String personagem;
	private BigDecimal desconto;

	private Filme filme;
	private Artista artista;

	public Participacao() {

	}

	public Participacao(Integer codParticipacao, String personagem, BigDecimal desconto, Filme filme, Artista artista) {
		super();
		this.codParticipacao = codParticipacao;
		this.personagem = personagem;
		this.desconto = desconto;
		this.filme = filme;
		filme.addParticipacao(this);
		this.artista = artista;
		artista.addParticipacao(this);
	}

	public Integer getCodParticipacao() {
		return codParticipacao;
	}

	public void setCodParticipacao(Integer codParticipacao) {
		this.codParticipacao = codParticipacao;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Participacao [codParticipacao=" + codParticipacao + ", personagem=" + personagem + ", desconto="
				+ desconto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codParticipacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participacao other = (Participacao) obj;
		return Objects.equals(codParticipacao, other.codParticipacao);
	}

	
	public BigDecimal cachePago(){
		return artista.getCache().subtract(desconto);
	}
	
}
