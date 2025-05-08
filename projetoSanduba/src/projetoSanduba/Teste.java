package projetoSanduba;

import Pessoa.Empresa;

public class Teste {

	public static void main(String[] args) {
		CategoriasJogos[] categorias  =  CategoriasJogos.values();
		System.out.println("As categorias são as seguintes:");
		for (CategoriasJogos categoria : categorias) {
			System.out.println(categoria.getCategoria());
		}

		System.out.println("");

		Jogo jogo = new Jogo("Genshin Impact", new String[]{"rpg", "aventura", "mundo aberto"});
		jogo.mostrarDadosCat();

		Empresa empresa = new Empresa("miHoYo", "", "", "", "", null, "");
		jogo.setPreco(49.9);
		jogo.setEmpresa(empresa);

		Empresa outraEmpresa = new Empresa("ConcernedApe", "", "", "", "", null, "");
		Jogo outroJogo = new Jogo("Stardew Valley", new String[]{"rpg", "simulação"});
		outroJogo.setPreco(14.99);
		outroJogo.setEmpresa(outraEmpresa);

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(jogo);
		carrinho.adiciona(outroJogo);
		
		System.out.println("***** Sem desconto");
		carrinho.imprimirCarrinho();

		System.out.println();

		System.out.println("***** Com desconto de 10%");
		carrinho.aplicarPercentualDesconto(0.1);
		carrinho.imprimirCarrinho();

		System.out.println();

		System.out.println("***** Removendo um jogo");
		carrinho.remove(jogo);
		carrinho.imprimirCarrinho();
	}
}
// as multiplas categorias ta funcionando !!!!