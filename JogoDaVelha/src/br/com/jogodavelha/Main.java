package br.com.jogodavelha;

import java.io.IOException;

import br.com.jogodavelha.nucleo.Jogo;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 
		 * Dica para jogar... os movimentos são valores das posiçoes de uma matriz!
		 * 
		 *   
		 * 
		 * Exemplo linha 1 ->	0,0 |0,1| 0,2
		 *	     				--------------
		 * Exemplo linha 2 ->	1,0 |1,1| 1,2
		 *	     				--------------
		 * Exemplo linha 3 ->	2,0 |2,1| 2,2
		 * 
		 * */
		
		
		
		Jogo jogo = new Jogo();
		jogo.jogar();
		
	}
}
