package projetoSanduba;

import java.text.Normalizer;
import java.util.Arrays;

public enum CategoriasJogos { // Lista de categoria em Enum (enumeração),

	RPG("Role Playing Game"),
	AVENTURA("Aventura"),
	ACAO("Ação"),
	PLATAFORMA("Plataforma"),
	BEATEMUP("Beat Em' Up"),
	SHOOTEMUP("Shoot Em' Up"),
	METROIDVANIA("Metroidvania"),
	CORRIDA("Corrida"),
	HORROR("Horror"),
	FURTIVO("Furtivo"),
	MUNDOABERTO("Mundo Aberto"),
	TIRO("Tiro"),
	PRIMEIRAPESSOA("Primeira Pessoa"),
	TERCEIRAPESSOA("Terceira Pessoa"),
	POINTANDCLICK("Point and Click"),
	ESCAPEROOM("Escape Room"),
	PUZZLE("Puzzle"),
	VISUALNOVEL("Visual Novel"),
	ESTRATEGIA("Estrategia"),
	TURNO("Turno"),
	TEMPOREAL("Tempo Real"),
	HACKANDSLASH("Hack and Slash"),
	TATICO("Tático"),
	ROGUELIKE("Rogue Like"),
	ESPORTE("Esporte"),
	ARCADE("Arcade"),
	SIMULACAO("Simulação"),
	LUTA("Luta"),
	ONLINE("Online"),
	FANTASIA("Fantasia"),
	MMO("MMO"),
	MOBA("MOBA"),
	CONSTRUCAO("Construção"),
	TABULEIRO("Tabuleiro"),
	CASUAL("Casual"),
	CARTAS("Cartas"),
	RITMO("Ritmo"),
	BATTLEROYALE("Battle Royale");

	private String categoria;

	CategoriasJogos(String categoria) {
		this.categoria = categoria; // construtor padrao
	}

	public String getCategoria() {
		return this.categoria; // isso aqui é so pra imprimir a categoria bonitinho
	}

	// criei um metodo no enum para converter as entradas dos usuarios
	// aqui eu to usando a biblioteca java.util.stream no lugar de um loop normal com for
	public static String[] converteString(String[] categoriasIvn){
		return Arrays.stream(categoriasIvn)
				.map(str -> Normalizer.normalize(str, Normalizer.Form.NFD)) // normalizer retira acentos
				.map(str -> str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")) //limpa acentos
				.map(str -> str.replaceAll("\\s+", "")) // retira espaço entre as palavras
				.map(str -> str.trim().toUpperCase()) // retira espaço dos lados e deixa tudo maisculo
				.toArray(String[]::new);
	}
	// no final as entradas vao ficar todas no padrao do Enum, por exemplo:
	// entrada: "construção "; após a conversão: "CONSTRUCAO"
}
