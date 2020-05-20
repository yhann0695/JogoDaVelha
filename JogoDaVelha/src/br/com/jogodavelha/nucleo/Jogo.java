package br.com.jogodavelha.nucleo;

import java.io.IOException;

import br.com.jogodavelha.Constantes;
import br.com.jogodavelha.pontuacao.ArquivoPontuacao;
import br.com.jogodavelha.pontuacao.Pontuacao;
import br.com.jogodavelha.ui.UI;

public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();

	private Jogador[] jogadores = new Jogador[Constantes.SIMBOLO_JOGADOR.length];
	
	private int posicaoJogadorAtual = -1;
	
	private Pontuacao pontuacao;

	
	public void jogar() throws IOException {
		pontuacao = criarGerentePontuacao();

		UI.mostrarTituloDoJogo();

		for (int i = 0; i < jogadores.length; i++) {
			jogadores[i] = criarJogador(i);
		}

		boolean jogoTerminou = false;
		Jogador jogadorAtual = proximoJogador();
		Jogador vencedor = null;

		while (!jogoTerminou) {
			tabuleiro.imprimirTabuleiro();
			
			boolean sequenciaEncontrada;
			try {
				sequenciaEncontrada = jogadorAtual.jogar();
			} catch (MovimentacaoInvalidaException e) {
				UI.mostrarTexto("ERRO: " + e.getMessage());
				continue;
			}


			if (sequenciaEncontrada) {
				jogoTerminou = true;
				vencedor = jogadorAtual;

			} else if (tabuleiro.tabuleiroCheio()) {
				jogoTerminou = true;
			} else {
				jogadorAtual = proximoJogador();
			}
		}
		if (vencedor == null) {
			UI.mostrarTexto("O jogo terminou empatado!");

		} else {
			UI.mostrarTexto("O Jogador vencedor foi " + vencedor.getNome());
			
			pontuacao.salvarPontuacao(vencedor);
		}

		tabuleiro.imprimirTabuleiro();

		UI.mostrarTexto("Fim do jogo!");

	}

	private Jogador criarJogador(int indice) {
		String nome = UI.lerConsole("Jogador " + (indice + 1) + " => ");
		char simbolo = Constantes.SIMBOLO_JOGADOR[indice];
		Jogador jogador = new Jogador(nome, simbolo, tabuleiro);
		
		Integer pontos = pontuacao.pegarPontuacao(jogador);
		
		if(pontos != null) {
			UI.mostrarTexto("O jogador '" + jogador.getNome() + "' Já possui " + pontos + " vitória(s)!");
		}
		
		UI.mostrarTexto("O jogador '" + nome + "' vai usar o símbolo " + simbolo);
		
		return jogador;
	}
	
	private Jogador proximoJogador() {
		/*
		posicaoJogadorAtual ++;
		
		if(posicaoJogadorAtual >= jogadores.length) {
			posicaoJogadorAtual = 0;
		}
		*/
		
		
		posicaoJogadorAtual = (posicaoJogadorAtual + 1) % jogadores.length;
		return jogadores[posicaoJogadorAtual];
	}
	
	private Pontuacao criarGerentePontuacao() throws IOException {
		return new ArquivoPontuacao();
	}

}
