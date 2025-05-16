
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
	VisualizacaoMenu visualizacaoMenu = new VisualizacaoMenu();
	private Adm adm;
	private RepositorioUsuarioArrayList listUsuarios;
	private RepositorioJogoArrayList listJogos;
	ControleDeJogos controleJogos;
	CarteiraDoAdm cartAdm = new CarteiraDoAdm();
	OrganicaoTelaAdm orgAdm = new OrganicaoTelaAdm();
	private Menu menu;

	public TelaAdm(Scanner sc, VisualizacaoMenu visualizacaoMenu, Adm adm, RepositorioUsuarioArrayList listUsuarios,
			RepositorioJogoArrayList listJogos, ControleDeJogos controleJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.adm = adm;
		this.listUsuarios = listUsuarios;
		this.listJogos = listJogos;
		this.controleJogos = controleJogos;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void exibirMenuAdm() throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		int opcao;

		do {
			visualizacaoMenu.telaMenuMcAdm();
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				orgAdm.opcoesCase1(sc, adm, listUsuarios, visualizacaoMenu);
				break;
			case 2:

				orgAdm.opcoesCase2(sc, adm, listUsuarios, visualizacaoMenu);
				break;
			case 3:
				orgAdm.opcoesCase3(sc, adm, listUsuarios, visualizacaoMenu, listJogos, controleJogos);
				break;
			case 4:
				visualizacaoMenu.telaSaldoSanduba();
				System.out.println("O saldo do SANDUBA  R$: " + cartAdm.getSaldo());
				break;
			case 5:
				visualizacaoMenu.telaDadosAdm();
				System.out.println(adm.mostrarDetalhesUsuario());
			case 6:
				menu.start();
				break;

			default:
				System.out.println("Opção invalida");
				opcao = sc.nextInt();
			}
		} while (opcao != 6);
	}
}
