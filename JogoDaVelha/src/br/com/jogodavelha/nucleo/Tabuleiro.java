package br.com.jogodavelha.nucleo;

import br.com.jogodavelha.Constantes;
import br.com.jogodavelha.ui.UI;

public class Tabuleiro {

	private char[][] matriz;
	
	public Tabuleiro() {
		matriz = new char[Constantes.TABULEIRO_TAMANHO][Constantes.TABULEIRO_TAMANHO];
		limpar();
	}
	
	public void limpar() {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}
	
	public void imprimirTabuleiro() {
		UI.pularLinha();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				UI.mostrarTextoSemPularLinha(String.valueOf(matriz[i][j]));
				
				if(j < matriz[i].length -1) {		
					UI.mostrarTextoSemPularLinha(" | ");
				}
				
			}
			UI.pularLinha();
			
			if(i < matriz.length -1) {
				UI.mostrarTexto(" -------- ");				
			}
			
		}
	}
	
	public boolean tabuleiroCheio() {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean jogar(Jogador jogador, Movimento movimento) throws MovimentacaoInvalidaException {
		
			int i = movimento.getI();
			int j = movimento.getJ();
			
			if(i < 0 || j < 0 || i >= Constantes.TABULEIRO_TAMANHO || j >= Constantes.TABULEIRO_TAMANHO) {
				throw new MovimentacaoInvalidaException("Jogada inválida, tente outra!");
			}
			
			if(matriz[i][j] != ' ') {
				throw new MovimentacaoInvalidaException("Esta jogada já foi realizada");
			}
			
			matriz[i][j] = jogador.getSimbolo();
			
			return verificarLinhas(jogador) || verificarColunas(jogador) || verificarDiagonal(jogador) || verificarDiagonalInvertida(jogador);
		 
	}
	
	private boolean verificarLinha(int i, Jogador jogador) {
		char simbolo = jogador.getSimbolo();
		
		for(int j = 0; j < Constantes.TABULEIRO_TAMANHO; j++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	private boolean verificarLinhas(Jogador jogador) {
		
		for(int i = 0; i < Constantes.TABULEIRO_TAMANHO; i++) {
			if(verificarLinha(i, jogador)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarColuna(int j, Jogador jogador) {
		char simbolo = jogador.getSimbolo();
		
		for(int i = 0; i < Constantes.TABULEIRO_TAMANHO; i++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	private boolean verificarColunas(Jogador jogador) {
		for(int j = 0; j < Constantes.TABULEIRO_TAMANHO; j++) {
			if(verificarColuna(j, jogador)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarDiagonal(Jogador jogador) {
		char simbolo = jogador.getSimbolo();
		
		for(int i = 0; i < Constantes.TABULEIRO_TAMANHO; i++) {
			if(matriz[i][i] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	private boolean verificarDiagonalInvertida(Jogador jogador) {
		char simbolo = jogador.getSimbolo();
		int ultimaLinha = Constantes.TABULEIRO_TAMANHO -1;
		
		for(int i = ultimaLinha, j = 0; i >= 0; i--, j++) {
			if(matriz[i][j] != simbolo) {
				return false;
			}
		}
		return true;
	}
	
	
}
