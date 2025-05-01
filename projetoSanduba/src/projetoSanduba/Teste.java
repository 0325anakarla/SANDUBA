package projetoSanduba;

public class Teste {

	public static void main(String[] args) {
		CategoriasJogos[] categorias  =  CategoriasJogos.values();
		System.out.println("As categorias são as seguintes:");
		for (CategoriasJogos categoria : categorias) {
			System.out.println(categoria.getCategoria());
		}

		System.out.println("");

		Jogo jogo = new Jogo("Genshin", new String[]{"rpg", "aventura", "mundo aberto"});
		jogo.mostrarDadosCat();

	}
}
// as multiplas categorias ta funcionando !!!!