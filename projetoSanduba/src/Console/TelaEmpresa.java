package Console;

import java.util.Scanner;

import Financeiro.CarteiraDaEmpresa;
import Financeiro.ResumoDeVendas;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeJogos;
import funcionalidades.Gambiarras;
import jogo.Jogo;

public class TelaEmpresa {

	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private RepositorioJogoArrayList listJogos;
	private ControleDeJogos controleJogos;
	private Menu menu;

	
	public TelaEmpresa(Scanner sc, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos, ControleDeJogos controleJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.listJogos = listJogos;
		this.controleJogos = controleJogos;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void telaMinhaContaEmpresa(Empresa empresa) throws DadoInvalidoException, DadoNaoEncontradoException{		
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuMcEmpresa();
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					System.out.println(empresa.mostrarDetalhesUsuario());
					break;
				case 2:
					telaCarteiraDigital(empresa.getCarteiraDigital());
					break;
				case 3:
					int subopcao =0;
					
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║   🎮 JOGOS CADASTRADOS         ║");
					System.out.println("╚══════════════════════════════╝");
					
					System.out.println("Empresa recebida: " + empresa.getRazaoSocial());
			        System.out.println("Jogos cadastrados: " + empresa.getJogosEmpresa().size());
			       
			        for (Jogo j : empresa.getJogosEmpresa()) {
			            System.out.println("🎮 " + j.getTitulo());
			        }
					System.out.println("*-----------------------------------------*");
					System.out.println("\nO que deseja fazer com o jogo?");
					System.out.println("  [1] ✏️ Alterar dados do jogo");
					System.out.println("  [2] 🗑️ Remover jogo");
					System.out.println("  [3] 🚪 Sair");
					System.out.print(">Digite a opção desejada: ");
					
					boolean opcaoValida1 = false;
					while(!opcaoValida1) {
						try {
							subopcao = Integer.parseInt(sc.nextLine());
						    if(subopcao == 1) {
						    	opcaoValida1 = true;
						    	System.out.print("Digite o nome do jogo que seja alterar:");
						    	try{
						    		Jogo resultado = empresa.procurarNomeJC(sc.nextLine());
						    		controleJogos.alterarDadosDosJogos(resultado);
						    	}catch(DadoNaoEncontradoException e) {
						    		System.out.println("❌ Erro: " + e.getMessage());
						    		break;
						    	}
						    }
						    else if(subopcao == 2) {
						    	opcaoValida1 = true;
						    	   	System.out.println("\n╔══════════════════════════════╗");
							        System.out.println("║       🗑️ REMOVER JOGO          ║");
							        System.out.println("╚══════════════════════════════╝");
							       
						    	controleJogos.deletarJogo(empresa);
						    }
						    
						    else if(subopcao == 3) {
						    	opcaoValida1 = true;
						    	break;
						    }
						    else System.out.println("Escolha 1 ou 2.");
						    	
						    }catch(NumberFormatException  e) {
						    	System.out.println("❌ Erro: " + e.getMessage());
						    	System.out.print("\nTenta de novo: ");
						    }
					} 
					
					break;
				case 4:
					controleJogos.CadastrarJogos(empresa);
					break;
				case 5:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║     📊 RESUMO DE VENDAS        ║");
					System.out.println("╚══════════════════════════════╝");
					if (!empresa.getVendasPorJogo().isEmpty()) {
						ResumoDeVendas.gerarResumoTotal(empresa.getVendasPorJogo());
					} else {
						Gambiarras.textoLento(">Sem registro de vendas de jogos!",60);
					}
					break;
				case 6:
					menu.start();
					break;
				default:
					Gambiarras.textoLento(">Opção invalida. Digite novamente.",60);
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital(CarteiraDaEmpresa cdE) {
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuCdEmpresa(cdE);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					double valor = 0;
					
					System.out.println("🔐 Sacar");
					System.out.println("🔐 Quanto vai sacar: ");
					
					valor = sc.nextDouble();
					sc.nextLine();
					
					if(cdE.sacar(valor)) {
						System.out.println(">O valor retirado foi: "+valor+ ". Seu saldo é de:"+cdE.getSaldo());
					}
					
					else {
						Gambiarras.textoLento("|Transação invalida.|",60);
					}
					break;
				case 2:
					System.out.println("> Mostrar dados bancarios");
					System.out.println(cdE.getDadosBancarios().toString());
					break;
				case 3:
					System.out.println("> Voltar para minha conta");
					break;
				default:
					System.out.println("| Opção invalida. Digite novamente. |");
					
			}
			
		}while(opcao != 3);
	}
	
	public void telaJogosCadastrados(Empresa empresa) throws DadoNaoEncontradoException, DadoInvalidoException {
		int opcao = 0;
		
		visualizacaoMenu.telaJogosCadastrados();
		
		do {
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao){
				case 1: 
					System.out.print("🔐 Digite o jogo que irar alterar:");
					String titulo = sc.nextLine();
					Jogo jogo = listJogos.procurarNome(titulo);
					controleJogos.alterarDadosDosJogos(jogo);
					break;
				case 2:
					controleJogos.deletarJogo(empresa);
					break;
				case 3:
					System.out.println("> Voltar para minha conta");
					break;
				default:
					System.out.println("| Opção invalida. Digite novamente.|");
					
			}
		}while(opcao != 3);
	}
}
