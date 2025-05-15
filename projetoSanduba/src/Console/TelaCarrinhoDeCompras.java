package Console;

import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Financeiro.CartaoDeCredito;
import Pessoa.Cliente;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class TelaCarrinhoDeCompras {
	private Scanner sc;
	private BibliotecaJogos bibJogos;
	private TelaCliente telaCliente;

	public TelaCarrinhoDeCompras(Scanner sc, BibliotecaJogos bibJogos, TelaCliente telaCliente) {
		this.sc = sc;
		this.bibJogos = bibJogos;
		this.telaCliente = telaCliente;
	}

	public void CarrinhoDeCompras(Cliente cliente, CarrinhoDeCompras carrinho) throws DadoInvalidoException {
		int opcao = 0;
		
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║          🛒 CARRINHO DE COMPRAS          ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		carrinho.imprimirCarrinho();
		
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] ❌ Remover item do carrinho");
		System.out.println("  [2] 💰 Finalizar compra");
		System.out.println("  [3] 🔙 Voltar para a biblioteca");
		System.out.print("\nDigite a opção desejada: ");
	
		 boolean opcaoValida = false;
		    while(!opcaoValida) {
			    try {
			    	opcao = Integer.parseInt(sc.nextLine());
			    	opcaoValida = true;
			    }catch(NumberFormatException  e) {
			    	System.out.println("❌ Erro: " + e.getMessage());
			    	System.out.print("\nTenta de novo: ");
			    }
			 }
		    switch(opcao) {
			case 1:
					System.out.println("Qual jogo deseja remover.");
					Jogo resultado = carrinho.procurarNome(sc.nextLine());
					carrinho.remove(resultado); 
				break;
			case 2:
				if (!cliente.getCartoesCadastrados().isEmpty()) {
					
					cliente.mostrarCartoes();
				
					boolean continuarAcao = true;
					while(continuarAcao) {
						try {
							System.out.println("Digite os ultimos digitos do cartão:");
							CartaoDeCredito resultado1 = cliente.procurarUltimosDig(sc.nextLine());
							String ultimosDigitos = resultado1.getNumDoCartao().substring(resultado1.getNumDoCartao().length() - 4);
							
							System.out.println("\nDeseja usar seu cashback disponível nessa compra?");
							System.out.println("  [1] 💰 Sim, usar cashback");
							System.out.println("  [2] ❌ Não, pagar normalmente");
							System.out.print("\nDigite a opção desejada: ");
							
							double novoValor =0;
							boolean opcaoValida1 = false;
							while(!opcaoValida1) {
								try {
								    int opcao2 = Integer.parseInt(sc.nextLine());
								    if(opcao2 == 1) {
								    	opcaoValida1 = true;
								    	novoValor = carrinho.aplicarCashBack(cliente);
								    }
								    else if(opcao2 == 2) {
								    	opcaoValida1 = true;
								    }else System.out.println("Escolha 1 ou 2.");
								    	
								    }catch(NumberFormatException  e) {
								    	System.out.println("❌ Erro: " + e.getMessage());
								    	System.out.print("\nTenta de novo: ");
								    }
							} 
							
							if(carrinho.finalizarCompra(cliente, novoValor)) {
								System.out.println("💳 Forma de Pagamento: Cartão: **** **** ****"+ultimosDigitos);
								System.out.println("Compra realizada com sucesso.");
							}
							else {
							System.out.println("Saldo insuficiente para concluir a compra!");
							}
							continuarAcao = false;
						}catch(DadoNaoEncontradoException e) {
							System.out.println("Erro: "+e.getMessage());
							System.out.println("Tente novamente:");
						}
					}
				}
				
				else System.out.println("Nenhum cartão cadastrado.\\nAdicione algum cartão para realizar transações.");
				
				break;
			case 3:
				bibJogos.Biblioteca(cliente);
				break;
			default:
				 System.out.println("⚠️ Opção inválida.");
	               
		}
		
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] 🔙 Voltar para a biblioteca");
		System.out.println("  [2] 👤 Ir para minha conta");
		System.out.print("\nDigite a opção desejada: ");
		opcao = Integer.parseInt(sc.nextLine());
		
		switch(opcao) {
			case 1:
				bibJogos.Biblioteca(cliente);
				break;
			case 2:
				telaCliente.telaMinhaContaCliente(cliente);
				break;
			default:
				System.out.println("⚠️ Opção inválida.");
				break;
		}
	}
}
