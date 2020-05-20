package br.com.jogodavelha.ui;

import java.util.Scanner;

public class UI {

	public static void mostrarTexto(String text) {
		System.out.println(text);
	}
	
	public static void mostrarTextoSemPularLinha(String text) {
		System.out.print(text);
	}
	
	public static void pularLinha() {
		System.out.println();
	}
	
	public static void mostrarTituloDoJogo() {
		mostrarTexto(" ===================== ");
		mostrarTexto("|   JOGO DA VELHA     |");
		mostrarTexto(" ===================== ");
		pularLinha();
	}
	
	public static String lerConsole(String text) {
		mostrarTextoSemPularLinha(text + " ");
		
		Scanner entrada = new Scanner(System.in);
		String entradaString = entrada.nextLine();
		return entradaString;
	}
}
