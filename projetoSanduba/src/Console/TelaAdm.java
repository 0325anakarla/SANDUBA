package Console;


import java.util.Scanner;

import Financeiro.CarteiraDoAdm;
import Pessoa.Adm;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;

import funcionalidades.ControleDeJogos;

public class TelaAdm {
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private Adm adm;
	private RepositorioUsuarioArrayList listUsuarios;
	private RepositorioJogoArrayList listJogos;
	private ControleDeJogos controleJogos;
//	private boolean deuCerto = true;
	private CarteiraDoAdm cartAdm;
	 OrganicaoTelaAdm orgAdm = new OrganicaoTelaAdm();
	
	
	public TelaAdm(Scanner sc, VisualizacaoMenu visualizacaoMenu, Adm adm, RepositorioUsuarioArrayList listUsuarios, RepositorioJogoArrayList listJogos,  ControleDeJogos controleJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.adm = adm;
		this.listUsuarios = listUsuarios;
		this.listJogos = listJogos;
		this.controleJogos = controleJogos;
	}
	
	public void exibirMenuAdm() throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		int opcao;
//		visualizacaoMenu.telaMenuMcAdm();
//		int opcao = sc.nextInt();
//		sc.nextLine();
//		
//////		System.out.println("  [1] 🧑‍ Gerenciar Cliente");
//	    System.out.println("  [2] 🏦 Gerenciar Empresas");
//	    System.out.println("  [3] 🎮 Gerenciar Jogos");
//	    System.out.println("  [4] 💰 Ver saldo do SANDUBA");
//	    System.out.println("  [5] ❌ Sair");
////		
		do {
		visualizacaoMenu.telaMenuMcAdm();
		 opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				
				orgAdm.opcoesCase1(sc,  adm, listUsuarios,visualizacaoMenu);
				
				break;
			case 2:
				
				orgAdm.opcoesCase2(sc, adm, listUsuarios, visualizacaoMenu);
				
				break;
			case 3:
				
				orgAdm.opcoesCase3(sc,  adm, listUsuarios, visualizacaoMenu, listJogos, controleJogos);
				break;
			case 4:
				visualizacaoMenu.telaSaldoSanduba();
				System.out.println("O saldo do SANDUBA  R$: "+cartAdm.getSaldo());
				
				break;
			case 5:
				//menu.statrt
				break;
			default:
				System.out.println("Opção invalida");
				opcao= sc.nextInt();
				
		}
		
		
	}while(opcao != 4);
		

	}
	
}
