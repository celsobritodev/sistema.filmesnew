package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme implements Serializable {
  private static final long serialVersionUID = 1L;	
  
  
  private Integer codFilme;
  private String titulo;
  private Integer duracao;
  private Integer ano;

  private List<Participacao> participacoes;
  
  public Filme() {
	  participacoes = new ArrayList<>();
	  
  }

public Filme(Integer codFilme, String titulo, Integer duracao, Integer ano) {
	super();
	this.codFilme = codFilme;
	this.titulo = titulo;
	this.duracao = duracao;
	this.ano = ano;
    participacoes = new ArrayList<>();
	  
}

public Integer getCodFilme() {
	return codFilme;
}

public void setCodFilme(Integer codFilme) {
	this.codFilme = codFilme;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public Integer getDuracao() {
	return duracao;
}

public void setDuracao(Integer duracao) {
	this.duracao = duracao;
}

public Integer getAno() {
	return ano;
}

public void setAno(Integer ano) {
	this.ano = ano;
}

public List<Participacao> getParticipacoes() {
	return participacoes;
}

public void setParticipacoes(List<Participacao> participacoes) {
	this.participacoes = participacoes;
}


public void addParticipacao(Participacao x) {
	this.participacoes.add(x);
    x.setFilme(this); 
}
  

public void removeParticipacao(Participacao x) {
	this.participacoes.remove(x);
}

@Override
public String toString() {
	return "Filme [codFilme=" + codFilme + ", titulo=" + titulo + ", duracao=" + duracao + ", ano=" + ano + "]";
}

@Override
public int hashCode() {
	return Objects.hash(codFilme);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Filme other = (Filme) obj;
	return Objects.equals(codFilme, other.codFilme);
}


public BigDecimal cacheTotal() {
	BigDecimal soma = new BigDecimal("0.00");
	for(Participacao p:participacoes) {
		soma= soma.add(p.cachePago());
	}
	return soma;
}


}


