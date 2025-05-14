package Console;

import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Pessoa.Cliente;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class TelaListaDeDesejos {
	
	private Scanner sc;
	private CarrinhoDeCompras carrinho;
	private TelaCarrinhoDeCompras mostrarCarrinho;
	private TelaCliente telaCliente;
	
	public TelaListaDeDesejos(Scanner sc, CarrinhoDeCompras carrinho, TelaCarrinhoDeCompras mostrarCarrinho, TelaCliente telaCliente) {
		this.sc = sc;
		this.carrinho = carrinho;
		this.mostrarCarrinho = mostrarCarrinho;
		this.telaCliente = telaCliente;
	}
	
	public void telaLD(Cliente cliente) throws DadoInvalidoException{
		int opcao =0;
		
		System.out.println("\n╔══════════════════════════════╗");
		System.out.println("║   💖 LISTA DE DESEJOS          ║");
		System.out.println("╚══════════════════════════════╝");
		
		cliente.resumoListaDeDesejos();
		
		boolean continuarNaTela = true;
		while(continuarNaTela) {
			
			System.out.println("Escolha uma opção:");
			System.out.println("  [1] ➕ Adicionar jogo ao carrinho");
			System.out.println("  [2] ❌ Remover jogo da lista de desejos");
			System.out.println("  [3] 👤 Voltar a minha conta.");
			System.out.print("\nDigite a opção desejada: ");
			opcao = Integer.parseInt(sc.nextLine());
		
			boolean continuarAcao = true;
			switch(opcao) {
				case 1:		
					while(continuarAcao) {
						
						System.out.println("🛒 Digite o nome do jogo que você quer adicionar ao carrinho:");
						
						try{
							Jogo resultado = cliente.procurarNomeLD(sc.nextLine());
							carrinho.adiciona(resultado);
							System.out.println("O jogo "+resultado.getTitulo()+" foi adicionado ao carrinho.");
							
							boolean opcaoValida = false;
							while(opcaoValida) {
								System.out.println("\nDeseja adicionar mais algum jogo ao carrinho?");
								System.out.println("  [1] ✅ Sim");
								System.out.println("  [2] ❌ Não");
								System.out.print("\nDigite a opção desejada: ");
								int subOpcao = Integer.parseInt(sc.nextLine());
								
								if(subOpcao == 1) {
									opcaoValida = true;
								}
								else if(subOpcao == 2) {
									opcaoValida = true;
									continuarAcao = false;
									
									boolean opcaoValida2 = false;
									while(opcaoValida2) {
										System.out.println("\nO que deseja fazer agora?");
										System.out.println("  [1] 🛒 Ir para o carrinho");
										System.out.println("  [2] 💖 Continuar na lista de desejos");
										System.out.println("  [3] 👤 Voltar à Minha Conta");
										System.out.print("\nDigite a opção desejada: ");
										int subOpcao2 = Integer.parseInt(sc.nextLine());
										if(subOpcao2 == 1) {
											opcaoValida2 = true;
											continuarNaTela = false;
											mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
										}
										else if(subOpcao2 == 2) {
											opcaoValida2 = true;
											continuarNaTela = true;
										}
										else if(subOpcao2 == 3) {
											opcaoValida2 = true;
											continuarNaTela = false;
											telaCliente.telaMinhaContaCliente(cliente);
										}
										else System.out.println("⚠️ Opção inválida. Digite 1, 2 ou 3.");
										}
								}
							
								else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
						}
						}catch (DadoNaoEncontradoException e) {
								System.out.println("❌ Erro: " + e.getMessage());
						}
					}
					break;
				case 2:
					while(continuarAcao) {
						System.out.print("❌ Digite o nome do jogo que você quer remover da lista de desejos: ");
						
						try{
							Jogo resultado = cliente.procurarNomeLD(sc.nextLine());
							cliente.removeListaDeDesejo(resultado);
							System.out.println("O jogo "+resultado.getTitulo()+" foi removido da Lista de Desejos.");
							
							boolean opcaoValida = false;
							while(opcaoValida) {
							System.out.println("\nDeseja remover mais algum jogo da Lista de Desejos?");
							System.out.println("  [1] ✅ Sim");
							System.out.println("  [2] ❌ Não");
							System.out.print("\nDigite a opção desejada: ");
							int subOpcao = Integer.parseInt(sc.nextLine());
							
							if(subOpcao == 1) {
								opcaoValida = true;
							}
							else if(subOpcao == 2) {
								opcaoValida = true;
								continuarAcao = false;
								
								boolean opcaoValida2 = false;
								while(opcaoValida2) {
									System.out.println("\nO que deseja fazer agora?");
									System.out.println("  [1] 🛒 Ir para o carrinho");
									System.out.println("  [2] 💖 Continuar na lista de desejos");
									System.out.println("  [3] 👤 Voltar à Minha Conta");
									System.out.print("\nDigite a opção desejada: ");
									int subOpcao2 = Integer.parseInt(sc.nextLine());
									if(subOpcao2 == 1) {
										opcaoValida2 = true;
										continuarNaTela = false;
										mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
									}
									else if(subOpcao2 == 2) {
										opcaoValida2 = true;
										continuarNaTela = true;
									}
									else if(subOpcao2 == 3) {
										opcaoValida2 = true;
										continuarNaTela = false;
										telaCliente.telaMinhaContaCliente(cliente);
									}
									else System.out.println("⚠️ Opção inválida. 1, 2 ou 3.");
									}
								
								}
							
							else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
							}
						}catch (DadoNaoEncontradoException | DadoInvalidoException e) {
								System.out.println("❌ Erro: " + e.getMessage());
						}
					}
					break;
				case 3:
					continuarNaTela = false;
					telaCliente.telaMinhaContaCliente(cliente);
				default:
					System.out.println("⚠️ Opção inválida. Digite 1, 2 ou 3.");
			}
		}
	}
}
