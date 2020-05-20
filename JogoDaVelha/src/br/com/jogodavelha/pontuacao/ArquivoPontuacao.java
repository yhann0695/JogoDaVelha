package br.com.jogodavelha.pontuacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.jogodavelha.nucleo.Jogador;

public class ArquivoPontuacao implements Pontuacao{

	private static final Path PONTUACAO_ARQUIVO = Path.of("pontuacao.txt");
	private Map<String, Integer> pontuacaoMapa = new HashMap<>();
	
	
	public ArquivoPontuacao() throws IOException {
		configuracao();
	}
	
	private void configuracao() throws IOException {
		
		if(!Files.exists(PONTUACAO_ARQUIVO)) {
			Files.createFile(PONTUACAO_ARQUIVO);
		}
		
		try (BufferedReader reader = Files.newBufferedReader(PONTUACAO_ARQUIVO)) {
			String linha;
			
			while((linha = reader.readLine()) != null) {
				String[] tokens = linha.split("\\|");
				
				pontuacaoMapa.put(tokens[0],Integer.parseInt(tokens[1]));
			}
		}
	}
	
	@Override
	public Integer pegarPontuacao(Jogador jogador) {
		
		return pontuacaoMapa.get(jogador.getNome().toUpperCase());
	}

	@Override
	public void salvarPontuacao(Jogador jogador) throws IOException {
		Integer pontuacao = pegarPontuacao(jogador);
		
		if(pontuacao == null) {
			pontuacao = 0;
		}
		
		pontuacaoMapa.put(jogador.getNome().toUpperCase(), pontuacao + 1);
		
		try (BufferedWriter writer = Files.newBufferedWriter(PONTUACAO_ARQUIVO)) {
			Set<Map.Entry<String, Integer>> entries = pontuacaoMapa.entrySet();
			for (Map.Entry<String, Integer> entry : entries) {
				String nome = entry.getKey();
				Integer pont = entry.getValue();
				writer.write(nome + "|" + pont);
				writer.newLine();
			}
		}
		
	}

}
