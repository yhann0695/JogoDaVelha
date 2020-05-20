package br.com.jogodavelha.nucleo;

import br.com.jogodavelha.ui.UI;

public class Jogador {

	private String nome;
	
	private char simbolo;
	
	private Tabuleiro tabuleiro;

	public Jogador(String nome, char simbolo, Tabuleiro tabuleiro) {
		this.nome = nome;
		this.simbolo = simbolo;
		this.tabuleiro = tabuleiro;
	}

	private Movimento movimentacaoDoJogador() throws MovimentacaoInvalidaException {
		
		String mover = UI.lerConsole("Jogador '" + nome + "' => ");
		return new Movimento(mover);
	}
	
	public boolean jogar() throws MovimentacaoInvalidaException {
		Movimento movimento = movimentacaoDoJogador();
		return tabuleiro.jogar(this, movimento);
	}

	public String getNome() {
		return nome;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	
	
	
}
