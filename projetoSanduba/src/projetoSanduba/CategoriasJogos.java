package projetoSanduba;

import java.text.Normalizer;

public enum CategoriasJogos { // Lista de categoria em Enum (enumeração),

	RPG("Role Playing Game"),
	AVENTURA("Aventura"),
	ACAO("Ação"),
	PLATAFORMA("Plataforma"),
	CORRIDA("Corrida"),
	HORROR("Horror"),
	MUNDOABERTO("Mundo Aberto"),
	TIRO("Tiro"),
	PRIMEIRAPESSOA("Primeira Pessoa"),
	TERCEIRAPESSOA("Terceira Pessoa"),
	PUZZLE("Puzzle"),
	TURNO("Turno"),
	ROGUELIKE("Rogue Like"),
	ESPORTE("Esporte"),
	SIMULACAO("Simulação"),
	LUTA("Luta"),
	FANTASIA("Fantasia"),
	MMO("MMO"),
	MOBA("MOBA"),
	CONSTRUCAO("Construção"),
	TABULEIRO("Tabuleiro"),
	CASUAL("Casual"),
	RITMO("Ritmo"),
	BATTLEROYALE("Battle Royale");

	private String categoria;

	CategoriasJogos(String categoria) {
		this.categoria = categoria; // construtor padrao
	}

	public String getCategoria() {
		return this.categoria; // isso aqui é so pra imprimir a categoria bonitinho
	}

	public void imprimeCategorias() {
		CategoriasJogos[] categorias  =  CategoriasJogos.values();
		for (CategoriasJogos categoria : categorias) {
			System.out.println(categoria.getCategoria());
		}
	}

	//versao mais legivel do metodo para converter as strings
	public static String[] converteString(String[] categoriasIvn){
		String[] categoriasVal = new String[categoriasIvn.length];

		for(int i = 0; i < categoriasVal.length; i++){
			categoriasVal[i] = Normalizer.normalize(categoriasIvn[i].trim().toUpperCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("\\s+", "");
			// Pega cada  string escrito e retira acentuação, limpa acentos, retira espaço entre palavras e dos lados e deixa tudo maisculo
		}

		return categoriasVal;
	}
	// no final as entradas vao ficar todas no padrao do Enum, por exemplo:
	// entrada: "construção "; após a conversão: "CONSTRUCAO"
}
