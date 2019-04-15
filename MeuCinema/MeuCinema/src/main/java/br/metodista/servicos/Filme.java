/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

public class Filme {
  private int id;
  private String filme;
  private String sinopse;
  private String genero;
  private Integer duracao;
  private String trailer;

  public Filme(int id, String filme, String sinopse,
    String genero, Integer duracao, String trailer) {

    this.id = id;
    this.filme = filme;
    this.sinopse = sinopse;
    this.genero = genero;
    this.duracao = duracao;
    this.trailer = trailer;
  }

  // get e set dos atributos.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    //métodos obrigatórios

    public String toString()
    {
		return this.filme + ": " this.sinopse;
	}

	public int hashCode()
	{
		int ret = 666;

		ret += 2 * new Integer(this.id).HashCode();
		ret += 2 * this.filme.HashCode();
		ret += 2 * this.sinopse.HashCode();
		ret += 2 * this.genero.HashCode();
		ret += 2 * this.duracao.HashCode();
		ret += 2 * this.trailer.HashCode();

		return ret;
	}

	public boolean equals(Object outro)
	{
		if(this == outro) return true;
		if(outro == null) return false;
		if(!(outro instanceof Filme)) return false;

		Filme filOutro = (Filme) outro;

		if(this.id != filOutro.id) return false;
		if(!this.filme.equals(filOutro.filme)) return false;
		if(!this.sinopse.equals(filOutro.sinopse)) return false;
		if(!this.genero.equals(filOutro.genero)) return false;
		if(!this.duracao.equals(filOutro.duracao)) return false;
		if(!this.trailer.equals(filOutro.trailer)) return false;

		return true;
	}

	//Clone
	public Filme(Filme modelo) throws Exception
	{
		if(modelo == null) throw new Exception("Modelo ausente!");

		this.id = modelo.id;
		this.filme = modelo.filme;
		this.sinopse = modelo.sinopse;
		this.genero = modelo.genero;
		this.duracao = modelo.duracao;
		this.trailer = modelo.trailer;
	}

	public Object close()
	{
		Filme ret = null;

		try
		{
			ret = new Filme(this);
		}
		catch(Exception erro) { }

		return ret;
	}
}
