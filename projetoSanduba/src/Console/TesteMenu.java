package Console;

import java.time.LocalDate;
import java.util.Scanner;

import Financeiro.CarteiraDoCliente;
import Financeiro.DadosBancarios;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;
public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {
		Scanner sc = new Scanner(System.in);
		RepositorioUsuarioArrayList repositorio = new RepositorioUsuarioArrayList();
		ControleDeCadastros controleCadastros = new ControleDeCadastros(sc, repositorio);
		TelaCliente telaCliente = new TelaCliente();
		TelaEmpresa telaEmpresa = new TelaEmpresa();
		
		Menu menu = new Menu(sc, repositorio, controleCadastros, telaCliente, telaEmpresa);

		menu.cadastroUsuario();
		
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
