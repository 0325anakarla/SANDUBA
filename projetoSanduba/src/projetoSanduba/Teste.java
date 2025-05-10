package projetoSanduba;

import java.time.LocalDate;

import Pessoa.Empresa;
import jogo.CategoriasJogos;
import jogo.Jogo;

public class Teste {

	public static void main(String[] args) {
		CategoriasJogos[] categorias  =  CategoriasJogos.values();
		System.out.println("As categorias são as seguintes:");
		for (CategoriasJogos categoria : categorias) {
			System.out.println(categoria.getCategoria());
		}

		System.out.println("");

		/*Jogo jogo = new Jogo("Genshin", new String[]{"rpg", "aventura", "mundo aberto"});
		jogo.mostrarDadosCat();*/

		Empresa empresa = new Empresa("miHoYo", "", "", "", "", null, "");
		Jogo jogo1 = new Jogo("Genshin Impact", 49.90, "", 0, "", "", "", empresa, null);

		Empresa outraEmpresa = new Empresa("ConcernedApe", "", "", "", "", null, "");
		Jogo jogo2 = new Jogo("Stardew Valley", 14.99, "", 0, "", "", "", outraEmpresa, null);

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(jogo1);
		carrinho.adiciona(jogo2);
		
		System.out.println("***** Sem desconto");
		carrinho.imprimirCarrinho();

		System.out.println();

		System.out.println("***** Com desconto de 10%");
		carrinho.aplicarPercentualDesconto(0.1);
		carrinho.imprimirCarrinho();

		System.out.println();

		System.out.println("***** Removendo um jogo");
		carrinho.remove(jogo1);
		carrinho.imprimirCarrinho();
	}
}
// as multiplas categorias ta funcionando !!!!