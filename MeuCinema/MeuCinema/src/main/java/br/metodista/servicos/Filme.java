/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

public class Filme {
  private Long id;
  private String filme;
  private String sinopse;
  private String genero;
  private Integer duracao;
  private String trailer;

  public Filme(Long id, String filme, String sinopse, 
    String genero, Integer duracao, String trailer) {

    this.id = id;
    this.filme = filme;
    this.sinopse = sinopse;
    this.genero = genero;
    this.duracao = duracao;
    this.trailer = trailer;
  }

  // get e set dos atributos.
}
