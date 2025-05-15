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
							System.out.println("Lista de jogos comprados: ");
							registro.exibiJogos();
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

					System.out.print("Qual valor vai depositar:");
					
					valor = sc.nextDouble();
					sc.nextLine();
					
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
					
					if (!cliente.getCartoesCadastrados().isEmpty()) {
						cliente.mostrarCartoes();
					}
					
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
			
			try {
				cliente.addCartaoDeCredito(cartao);
				System.out.println("O cartão com os últimos dígitos "+ultimosDigitos+" foi adicionado com sucesso.");

				boolean opcaoValida = true;
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
						opcaoValida = false;
						continuarAcao = false;
					}
					else System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");	
					
					//falta implementar o restante(alana)
				}
			}catch(DadoDuplicadoException e) {
				System.out.println("⚠️ Erro: " +e.getMessage());
				//perguntar se vai voltar para o cadastro
			}
		}
	}
	
	public void deletarCartao(Cliente cliente) throws DadoInvalidoException {
		
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
