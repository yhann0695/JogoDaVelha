package br.com.jogodavelha.pontuacao;

import java.io.IOException;

import br.com.jogodavelha.nucleo.Jogador;

public interface Pontuacao {

	public Integer pegarPontuacao(Jogador jogador);
	
	public void salvarPontuacao(Jogador jogador) throws IOException ;
}
