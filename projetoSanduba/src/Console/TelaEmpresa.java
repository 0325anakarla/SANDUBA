package Console;

import java.util.Scanner;

import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import funcionalidades.ControleDeJogos;
import projetoSanduba.CarteiraDaEmpresa;

public class TelaEmpresa {
	Scanner sc = new Scanner(System.in);
	veiwsMenu menu = new veiwsMenu();
	CarteiraDaEmpresa cdE = new CarteiraDaEmpresa(null);
	ControleDeJogos controlJogos = new ControleDeJogos();
	Empresa empresa = new Empresa(null, null, null, null, null, null, null);
	
	public void telaMinhaContaEmpresa() {
		int opcao = 0;
		
		do {
			
			menu.telaMenuMcEmpresa();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					empresa.toString();
					break;
				case 2:
					System.out.println("Mostra carteira digital e suas opções");
					telaCarteiraDigital();
					break;
				case 3:
					System.out.println("Jogos cadastrados");
					controlJogos.ListJogosEmpresa(empresa);
					break;
				case 4:
					System.out.println("\n--- CADASTRAR JOGOS ---");
					controlJogos.CadastrarJogos();
					break;
				case 5:
					System.out.println("Resumo de vendas");
					//list para resumo de vendas
					break;
				case 6:
					System.out.println("sair");
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
					sc.nextLine();
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital() {
		int opcao = 0;
		
		do {
			
			menu.telaMenuCdEmpresa();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					double valor =0;
					
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
					
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
					
			}
			
		}while(opcao != 3);
	}
}
