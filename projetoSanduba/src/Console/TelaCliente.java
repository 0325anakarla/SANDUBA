package Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	private BibliotecaJogos bibJogos;

	public TelaCliente(Scanner sc, VisualizacaoMenu visualizacaoMenu) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		
	}
	

	public void setTelaListaDeDesejos(TelaListaDeDesejos telaListaDeDesejos) {
		this.telaListaDeDesejos = telaListaDeDesejos;
	}
	
	public void setBibliotecaJogos(BibliotecaJogos bibJogos) {
		this.bibJogos = bibJogos;
	}
	
	public void telaMinhaContaCliente(Cliente cliente) throws DadoInvalidoException {
	
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuMcCliente();
			
			 opcao = Integer.parseInt(sc.nextLine());
			
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
					boolean continuarAcao = true;
					while(continuarAcao) {
						System.out.println("\n╔══════════════════════════════╗");
						System.out.println("║          🎮 MEUS JOGOS         ║");
						System.out.println("╚══════════════════════════════╝");
						
						System.out.println("\nO que deseja fazer agora?");
					    System.out.println("  [1] 🔐 Ver de chave de ativação");
					    System.out.println("  [2] 🧑‍ Voltar a minha conta");
					    System.out.print("\nDigite a opção desejada: ");
					    
					    boolean opcaoValida = false;
					    while(!opcaoValida) {
					    	try {
					    		int opcao1 = Integer.parseInt(sc.nextLine());
					    		if(opcao1 == 1) {
					    			opcaoValida = true;
					    			if (!cliente.getJogosAdquiridos().isEmpty()) {
										for (Jogo jogo : cliente.getJogosAdquiridos()) {
											System.out.println(jogo.getTitulo());
										}
										System.out.println("Escolha o jogo que voce deseja ver a chave de ativação.");
										try{
											Jogo resultado = cliente.procurarNomeJA(sc.nextLine());
											System.out.println("Chave de Ativação: "+resultado.getModAtivacao());
										}catch(DadoNaoEncontradoException e) {
											System.out.println("❌ Erro: " + e.getMessage());
										}
									} else {
										System.out.println("Você ainda não comprou jogos!");
									}
					    		}
					    		if(opcao1 == 2) {
					    			continuarAcao = false;
					    			break;
					    		}
					    		else
					    			System.out.println("Opção invalida. Escolha 1 ou 2.");
					    	}catch(NumberFormatException e) {
					    		System.out.println("❌ Erro: " + e.getMessage());
					    	}
					    }
					}
					break;
				case 4:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║       💖 LISTA DE DESEJOS      ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getJogos().isEmpty()) {
						telaListaDeDesejos.telaLD(cliente);
					} else {
						System.out.println("Lista de desejos vazia!");
					}
					break;
				case 5:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║   📜 HISTÓRICO DE PEDIDOS      ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getHistorico().isEmpty()) {
						for (RegistroDeCompras registro : cliente.getHistorico()) {
							System.out.println(registro.toString()+"\n");
						}
					} else {
						System.out.println("Sem registro de compras!");
					}
					break;
				case 6:
					bibJogos.Biblioteca(cliente);
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital(CarteiraDoCliente cdC, Cliente cliente) throws DadoInvalidoException {
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuCdCliente(cdC);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					double valor = 0;
					
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║         ➕ DEPÓSITO           ║");
					System.out.println("╚══════════════════════════════╝");

					System.out.println("Escolha o cartão que vai ser realizado o depósito.");	
					if (!cliente.getCartoesCadastrados().isEmpty()) {
						
						cliente.mostrarCartoes();
					
						boolean continuarAcao = true;
						while(continuarAcao) {
							try {
								System.out.println("Digite os ultimos digitos do cartão:");
								CartaoDeCredito resultado = cliente.procurarUltimosDig(sc.nextLine());
								String ultimosDigitos = resultado.getNumDoCartao().substring(resultado.getNumDoCartao().length() - 4);
							
								System.out.print("Qual valor vai depositar:");
								valor = sc.nextDouble();
								sc.nextLine();
								
								if(cdC.depositar(valor)) {
									System.out.println("💳 Forma de Pagamento: Cartão: **** **** ****"+ultimosDigitos);
									System.out.println("O valor depositado foi: "+valor+ ". Seu saldo é de:"+cdC.getSaldo());
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
				case 2:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║     💳 CARTÕES CADASTRADOS     ║");
					System.out.println("╚══════════════════════════════╝");
					
					if (!cliente.getCartoesCadastrados().isEmpty()) {
						cliente.mostrarCartoes();
					}else System.out.println("Nenhum cartão cadastrado.");
					
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
	
	public void adicionarCartao(Cliente cliente) throws DadoInvalidoException {
		boolean continuarAcao = true;
		
		CartaoDeCredito cartao = new CartaoDeCredito(null, null, null, 0);
		
		while(continuarAcao) {
			try{
				System.out.println("➕ Digite os dados do cartão que vai ser adicionado.");
				System.out.print("Nome do Titular:");
				cartao.setNomeDoTitular(sc.nextLine());
				
				System.out.print("Número do Cartão:");
				cartao.setNumDoCartao(sc.nextLine());
				String ultimosDigitos = cartao.getNumDoCartao().substring(cartao.getNumDoCartao().length() - 4);
				
				System.out.print("Data de expiração - (dd/MM/yyy): ");
				String data = sc.nextLine();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate expiracao = LocalDate.parse(data, formato);
				cartao.setDataDeExpiracao(expiracao);
				
				System.out.print("CVC: ");
				cartao.setCvc(sc.nextInt());
				sc.nextLine();
				
				try {
					cliente.addCartaoDeCredito(cartao);
					System.out.println("O cartão com os últimos dígitos "+ultimosDigitos+" foi adicionado com sucesso.");
					continuarAcao = false;
				}catch(DadoDuplicadoException e) {
					System.out.println("⚠️ Erro: " +e.getMessage());
					System.out.println("Tente novamente:");
				}
			}catch(DadoInvalidoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println("Tente novamente:");
			}
		}
	}
	
	public void deletarCartao(Cliente cliente) throws DadoInvalidoException {
		
		boolean continuarAcao = true;
		
		while(continuarAcao) {
			System.out.println("❌ Digite os ultimos digitos do Cartão que deseja remover.");
			CartaoDeCredito resultado = cliente.procurarUltimosDig(sc.nextLine());
			String ultimosDigitos = resultado.getNumDoCartao().substring(resultado.getNumDoCartao().length() - 4);
			
			try{
				cliente.removerCartao(resultado);
				System.out.println("Cartao com final "+ultimosDigitos+" foi removido com sucesso.");
				continuarAcao = false;
			}catch(DadoNaoEncontradoException e) {
				System.out.println("⚠️ Erro: " +e.getMessage());
			}
		}
	}

}
