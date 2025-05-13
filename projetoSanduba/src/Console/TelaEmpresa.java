package Console;

import java.util.Scanner;

import Financeiro.CarteiraDaEmpresa;
import Financeiro.ResumoDeVendas;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeJogos;
import jogo.Jogo;

public class TelaEmpresa {
<<<<<<< HEAD
	Scanner sc = new Scanner(System.in);

	VisualizacaoMenu menu = new VisualizacaoMenu();
	CarteiraDaEmpresa cdE = new CarteiraDaEmpresa(null);
	ControleDeJogos controlJogos = new ControleDeJogos();

	Empresa empresa = new Empresa(null, null, null, null, null, null, null);
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();	

=======
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private RepositorioJogoArrayList listJogos;
	private ControleDeJogos controleJogos;
>>>>>>> 7752f138a2c7ce56fe2a872959b1bd0bc394abc1
	
	public TelaEmpresa(Scanner sc, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos, ControleDeJogos controleJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.listJogos = listJogos;
		this.controleJogos = controleJogos;
	}
	
	public void telaMinhaContaEmpresa(Empresa empresa){		
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuMcEmpresa();
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					System.out.println(empresa.mostrarDetalhesUsuario());
					break;
				case 2:
					telaCarteiraDigital(empresa.getCarteiraDigital());
					break;
				case 3:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║   🎮 JOGOS CADASTRADOS         ║");
					System.out.println("╚══════════════════════════════╝");
					controleJogos.ListJogosEmpresa(empresa);
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
						System.out.println("Sem registro de vendas de jogos!");
					}
					break;
				case 6:
					System.out.println("sair");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
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
					
					System.out.println("Sacar");
					System.out.println("Quanto vai sacar: ");
					
					valor = sc.nextDouble();
					
					if(cdE.sacar(valor)) {
						System.out.println("O valor retirado foi: "+valor+ ". Seu saldo é de:"+cdE.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("Mostrar dados bancarios");
					System.out.println(cdE.getDadosBancarios().toString());
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
					
			}
			
		}while(opcao != 3);
	}
	
	public void telaJogosCadastrados(Empresa empresa) {
		int opcao = 0;
		
		visualizacaoMenu.telaJogosCadastrados();
		
		do {
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao){
				case 1: 
					System.out.print("Digite o jogo que irar alterar:");
					String titulo = sc.nextLine();
					Jogo jogo = listJogos.procurarNome(titulo);
					controleJogos.alterarDadosDosJogos(jogo);
					break;
				case 2:
					controleJogos.deletarJogo(empresa);
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
					
			}
		}while(opcao != 3);
	}
}
