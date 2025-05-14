package Console;

import java.util.Scanner;

import Financeiro.CartaoDeCredito;
import Financeiro.CarteiraDoCliente;
import Financeiro.RegistroDeCompras;
import Pessoa.Cliente;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class TelaCliente {
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private TelaListaDeDesejos telaListaDeDesejos;

	public TelaCliente(Scanner sc, VisualizacaoMenu visualizacaoMenu) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
	}
	
<<<<<<< HEAD
	public void telaMinhaContaCliente(Cliente cliente){
=======
	public void setTelaListaDeDesejos(TelaListaDeDesejos telaListaDeDesejos) {
		this.telaListaDeDesejos = telaListaDeDesejos;
	}
	
	public void telaMinhaContaCliente(Cliente cliente) {
>>>>>>> a1bfe3ce5bd3441d34225fc358aac91b33b97ceb
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuMcCliente();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n╔═══════════════════════════╗");
					System.out.println("║    🧑‍💻 INFORMAÇÕES PESSOAIS ║");
					System.out.println("╚══════════════════════════════╝");
					System.out.println(cliente.mostrarDetalhesUsuario());
					break;
				case 2:
					if (cliente.getCarteiraDigital() != null) {
						telaCarteiraDigital(cliente.getCarteiraDigital(), cliente);
					} else {
						System.out.println("Sem carteira digital!");
					}
					break;
				case 3:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║          🎮 MEUS JOGOS         ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getJogosAdquiridos().isEmpty()) {
						for (Jogo jogo : cliente.getJogosAdquiridos()) {
							System.out.println(jogo.getTitulo());
						}
					} else {
						System.out.println("Você ainda não comprou jogos!");
					}
					break;
				case 4:
//					System.out.println("\n╔══════════════════════════════╗");
//					System.out.println("║       💖 LISTA DE DESEJOS      ║");
//					System.out.println("╚══════════════════════════════╝");
					telaListaDeDesejos.telaLD(cliente);
					break;
				case 5:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║   📜 HISTÓRICO DE PEDIDOS      ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getHistorico().isEmpty()) {
						for (RegistroDeCompras registro : cliente.getHistorico()) {
							System.out.println(registro.toString()+"\n");
							System.out.println("Lista de jogos comprados: ");
							registro.exibiJogos();
						}
					} else {
						System.out.println("Sem registro de compras!");
					}
					break;
				case 6:
					System.out.println("Volta para biblioteca de jogos");
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital(CarteiraDoCliente cdC, Cliente cliente) {
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuCdCliente(cdC);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					double valor =0;
					
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║         ➕ DEPÓSITO           ║");
					System.out.println("╚══════════════════════════════╝");

					System.out.print("Qual valor vai depositar:");
					
					valor = sc.nextDouble();
					
					if(cdC.depositar(valor)) {
						System.out.println("O valor depositado foi: "+valor+ ". Seu saldo é de:"+cdC.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║     💳 CARTÕES CADASTRADOS     ║");
					System.out.println("╚══════════════════════════════╝");
					
					cliente.mostrarCartoes();
					
					System.out.println("\nO que deseja fazer agora?");
				    System.out.println("  [1] ➕ Adicionar Cartão");
				    System.out.println("  [2] ❌ Remover Cartão");
				    System.out.println("  [3] 💳 Voltar à Carteira Digital");
				    System.out.print("\nDigite a opção desejada: ");
				    int subOpcao = Integer.parseInt(sc.nextLine());
				    	if(subOpcao == 1) {
				    		adicionarCartao(cliente);
				    	}
				    	else if(subOpcao == 2) {
				    		deletarCartao(cliente);
				    	}
				    	else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("⚠️ Opção inválida. Digite 1, 2 ou 3.");
					
			}
			
		}while(opcao != 3);
	}
	
	public void adicionarCartao(Cliente cliente) {
		boolean continuarAcao = true;
		
		CartaoDeCredito cartao = new CartaoDeCredito(null, null, null, 0);
		
		while(continuarAcao) {
			System.out.println("➕ Digite os dados do cartão que vai ser adicionado.");
			try {
				System.out.print("Nome do Titular:");
				cartao.setNomeDoTitular(sc.nextLine());
				
				System.out.print("Número do Cartão:");
				cartao.setNumDoCartao(sc.nextLine());
				String ultimosDigitos = cartao.getNumDoCartao().substring(cartao.getNumDoCartao().length() - 4);
				
				System.out.print("Data de expiração:");
				//fazer amanha perdao to com sono
				
				System.out.print("CVC:");
				cartao.setCvc(sc.nextInt());
				
				try {
					cliente.addCartaoDeCredito(cartao);
					System.out.println("O cartão com os últimos dígitos "+ultimosDigitos+" foi adicionado com sucesso.");
		
					boolean opcaoValida = false;
					while(opcaoValida) {
						System.out.println("\nDeseja adicionar mais algum cartão?");
						System.out.println("  [1] ✅ Sim");
						System.out.println("  [2] ❌ Não");
						System.out.print("\nDigite a opção desejada: ");
						int subOpcao1 = Integer.parseInt(sc.nextLine());
						if(subOpcao1 == 1) {
							opcaoValida = true;
						}
						else if(subOpcao1 == 2) {
							opcaoValida = true;
							continuarAcao = false;
						}
						else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
					}
				}catch(DadoDuplicadoException e) {
					System.out.println("⚠️ Erro: " +e.getMessage());
					//perguntar se vai voltar para o cadastro
				}
			}catch(DadoInvalidoException e) {
				System.out.println("⚠️ Erro: " +e.getMessage());
			}
		}
	}
	
	public void deletarCartao(Cliente cliente) {
		
		boolean continuarAcao = true;
		
		while(continuarAcao) {
			System.out.println("❌ Digite os ultimos digitos do Cartão que deseja remover.");
			CartaoDeCredito resultado = cliente.procurarUltimosDig(sc.nextLine());
			
			try{
				cliente.removerCartao(resultado);
				System.out.println("Cartao removido com sucesso.");
				boolean opcaoValida = false;
				while(opcaoValida) {
					System.out.println("\nDeseja adicionar mais algum cartão?");
					System.out.println("  [1] ✅ Sim");
					System.out.println("  [2] ❌ Não");
					System.out.print("\nDigite a opção desejada: ");
					int subOpcao1 = Integer.parseInt(sc.nextLine());
					if(subOpcao1 == 1) {
						opcaoValida = true;
					}
					else if(subOpcao1 == 2) {
						opcaoValida = true;
						continuarAcao = false;
					}
					else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
				}
			}catch(DadoNaoEncontradoException e) {
				System.out.println("⚠️ Erro: " +e.getMessage());
			}
		}
	}

}
