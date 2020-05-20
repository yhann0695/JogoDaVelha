package br.com.jogodavelha.nucleo;

public class Movimento {

	private int i;
	
	private int j;
	
	
	public Movimento(String movimentacaoString) throws MovimentacaoInvalidaException {

		try {
			
			String[] tokens = movimentacaoString.split(",");
			
			this.i = Integer.parseInt(tokens[0]);
			this.j = Integer.parseInt(tokens[1]);
		} catch (Exception e) {
			throw new MovimentacaoInvalidaException("Jogada inválida");
		}
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	
	
	
}
