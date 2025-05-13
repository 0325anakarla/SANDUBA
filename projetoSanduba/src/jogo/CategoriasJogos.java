package jogo;

import java.text.Normalizer;
import java.util.*;

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

	ArrayList<CategoriasJogos> categoriasJogos = new ArrayList<CategoriasJogos>(List.of(CategoriasJogos.values()));

	public void imprimeCategorias() {
		for (CategoriasJogos categoria : categoriasJogos) {
			System.out.println(categoria.getCategoria());
		}
	}
}
