package jogo;

public enum CategoriasJogos { // Lista de categoria em Enum (enumeração),

	RPG("Role Playing Game"),
	AVENTURA("Aventura"),
	ACAO("Ação"),
	HORROR("Horror"),
	MUNDOABERTO("Mundo Aberto"),
	TIRO("Tiro"),
	PRIMEIRAPESSOA("Primeira Pessoa"),
	TERCEIRAPESSOA("Terceira Pessoa"),
	PUZZLE("Puzzle"),
	TURNO("Turno"),
	ESPORTE("Esporte"),
	LUTA("Luta"),
	FANTASIA("Fantasia"),
	CONSTRUCAO("Construção"),
	RITMO("Ritmo"),
	BATTLEROYALE("Battle Royale");

	private String categoria;

	CategoriasJogos(String categoria) {
		this.categoria = categoria; // construtor padrao
	}

	public String getCategoria() {
		return this.categoria; // isso aqui é so pra imprimir a categoria bonitinho
	}

	public static void imprimeCategorias() {
		CategoriasJogos[] cateogorias = CategoriasJogos.values();
		for (int i = 0; i < cateogorias.length; i += 2) {

			System.out.print(i + ": " + cateogorias[i].getCategoria());

			if (i + 1 < cateogorias.length) {
				System.out.print(" | " + (i + 1) + ": " + cateogorias[i + 1].getCategoria());
			}

			System.out.println();
		}
	}
}
