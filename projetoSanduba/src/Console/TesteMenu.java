package Console;

import java.time.LocalDate;
import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Financeiro.CarteiraDoCliente;
import Financeiro.DadosBancarios;
import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeCadastros;
import funcionalidades.ControleDeJogos;
public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {
		Scanner sc = new Scanner(System.in);
		
		VisualizacaoMenu visualizacaoMenu = new VisualizacaoMenu();
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		Adm adm = Adm.getInstancia(null, null, null);
		
		//REPOSITORIOS
		RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList(sc);
		RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
		
		//CONTROLES
		ControleDeJogos controleJogos = new ControleDeJogos(sc, visualizacaoMenu, listJogos);
		ControleDeCadastros controleCadastros = new ControleDeCadastros(sc, listUsuarios);
		
		//TELAS
		TelaCliente telaCliente = new TelaCliente(sc, visualizacaoMenu);
		TelaEmpresa telaEmpresa = new TelaEmpresa(sc, visualizacaoMenu, listJogos, controleJogos);
		TelaAdm telaAdm = new TelaAdm(sc, visualizacaoMenu, adm, listUsuarios, listJogos, controleJogos);
		BibliotecaJogos bibJogos = new BibliotecaJogos(sc, carrinho, listJogos, telaCliente);
		TelaCarrinhoDeCompras mostrarCarrinho = new TelaCarrinhoDeCompras(sc, carrinho, listJogos, bibJogos, telaCliente);
		bibJogos.setMostrarCarrinho(mostrarCarrinho);
		TelaListaDeDesejos telaListaDeDesejos = new TelaListaDeDesejos(sc, carrinho, mostrarCarrinho, telaCliente);
		telaCliente.setTelaListaDeDesejos(telaListaDeDesejos);
		
		//INICIALIZACAO DO MENU
		Menu menu = new Menu(sc, listUsuarios, controleCadastros, bibJogos, telaEmpresa, telaAdm);

		controleCadastros.setMenu(menu);
		menu.start();
		
//		Cliente cliente = new Cliente("lana", "lana@gmail.com", "1234", "12345678-90", LocalDate.of(2004, 9, 23));
//		CarteiraDoCliente cdC = new CarteiraDoCliente();
//		cliente.setCarteiraDigital(cdC);

		
//		TelaCliente viewsC = new TelaCliente();
//		viewsC.telaMinhaContaCliente(cliente);

		
//		DadosBancarios banco = new DadosBancarios("CP", "Santander", "Conta corrente", 5, 200);
//		Empresa empresa = new Empresa("ConcernedApe", "aux@gmail.com", "5678", "", "1234567890-12", "", banco);
//		TelaEmpresa viewE = new TelaEmpresa();
//		viewE.telaMinhaContaEmpresa(empresa);

//		viewE.telaJogosCadastrados(empresa);
	}

}
