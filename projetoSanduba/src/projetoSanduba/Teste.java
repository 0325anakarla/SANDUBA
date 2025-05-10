package projetoSanduba;

import java.time.LocalDate;
import java.util.ArrayList;

import Financeiro.CarrinhoDeCompras;
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

		ArrayList<String> categoriasIvn = new ArrayList<String>();
		categoriasIvn.add("rpg");
		categoriasIvn.add("aventura");
		categoriasIvn.add("mundo aberto");

		Jogo jogo = new Jogo("Genshin", categoriasIvn);
		jogo.mostrarDadosCat();

		Empresa empresa = new Empresa("miHoYo", "", "", "", "", null, "");
		Jogo jogo1 = new Jogo("Genshin Impact", 49.90, "", null, 0, "", "", "", empresa, null);

		Empresa outraEmpresa = new Empresa("ConcernedApe", "", "", "", "", null, "");
		Jogo jogo2 = new Jogo("Stardew Valley", 14.99, "", null, 0, "", "", "", outraEmpresa, null);

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