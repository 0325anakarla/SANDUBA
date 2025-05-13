package projetoSanduba;

import java.util.ArrayList;

import Financeiro.CarrinhoDeCompras;
import Pessoa.Empresa;
import jogo.CategoriasJogos;
import jogo.Jogo;

public class Teste {

	public static void main(String[] args) {
		// O forma para imrpimir as categorias, idiomas, plataformas e classificações é a seguinte:
		// System.out.println("As classificações indicativas são as seguintes:");
		// ClassificacaoIndicativa.imprimeClassificacoes();
		// cada Enum já tem seu proprio metodo imprimir então é só chamar a classe
		// será impresso no formato de lista:
		/*  1: Inglês
			2: Espanhol
			3: Alemão
			etc...
		 */

		Empresa empresa = new Empresa("miHoYo", "", "", "", "", "", null);
		Jogo jogo1 = new Jogo("Genshin Impact", 49.90, "", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 0, "", empresa, null);

		Empresa outraEmpresa = new Empresa("ConcernedApe", "", "", "", "", "", null);
		Jogo jogo2 = new Jogo("Stardew Valley", 14.99, "", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 0, "", outraEmpresa, null);

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