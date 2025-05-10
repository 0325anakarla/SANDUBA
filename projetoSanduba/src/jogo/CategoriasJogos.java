package jogo;

import java.text.Normalizer;
import java.util.ArrayList;

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
	public static ArrayList<String> converteArrayListString(ArrayList<String> categoriasIvn){

		ArrayList<String> categoriasVal =  new ArrayList<String>(categoriasIvn.size());

		for(int i = 0; i < categoriasIvn.size(); i++){
			// Pega cada  string escrito e retira acentuação, limpa acentos, retira espaço entre palavras e dos lados e deixa tudo maisculo
			categoriasVal.add(i, Normalizer.normalize(categoriasIvn.get(i).trim().toUpperCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("\\s+", "") );
		}

		return categoriasVal;
	}
	// no final as entradas vao ficar todas no padrao do Enum, por exemplo:
	// entrada: "construção "; após a conversão: "CONSTRUCAO"
}
