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
	Scanner sc = new Scanner(System.in);

	VisualizacaoMenu menu = new VisualizacaoMenu();
	ControleDeJogos controlJogos = new ControleDeJogos();
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();

	
	public void telaMinhaContaEmpresa(Empresa empresa){		
		int opcao = 0;
		
		do {
			
			menu.telaMenuMcEmpresa();
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					System.out.println(empresa.mostrarDetalhesUsuario());
					break;
				case 2:
					System.out.println("Mostra carteira digital e suas opções");
					telaCarteiraDigital(empresa.getCarteiraDigital());
					break;
				case 3:
					System.out.println("Jogos cadastrados");
					controlJogos.ListJogosEmpresa(empresa);
					break;
				case 4:
					System.out.println("\n╔═══════════════════════════════╗");
					System.out.println("║       ➕ CADASTRAR JOGOS        ║");
					System.out.println("╚═══════════════════════════════╝");

					controlJogos.CadastrarJogos(empresa);
					break;
				case 5:
					System.out.println("Resumo de vendas");
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
			
			menu.telaMenuCdEmpresa(cdE);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					double valor = 0;
					
					System.out.println("Sacar");
					System.out.println("Quanto vai sacar: ");
					
					valor = sc.nextDouble();
					
					if(cdE.sacar(valor)) {
						System.out.println("O valor retirado foi: "+valor+ ". Seu saldo é de:"+cdE.getSaldo());
					} else {
						System.out.println("Transação invalida.");
					}
					sc.nextLine();
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
		
		menu.telaJogosCadastrados();
		
		do {
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao){
				case 1: 
					System.out.print("Digite o jogo que irar alterar:");
					String titulo = sc.nextLine();
					Jogo jogo = listJogos.procurarNome(titulo);
					controlJogos.alterarDadosDosJogos(jogo);
					break;
				case 2:
					controlJogos.deletarJogo(empresa);
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
