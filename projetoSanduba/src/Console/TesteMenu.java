package Console;

import java.time.LocalDate;

import Financeiro.CarteiraDoCliente;
import Financeiro.DadosBancarios;
import Pessoa.Cliente;
import Pessoa.Empresa;
import TratamentoDeErro.DadoInvalidoException;

public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {

		
		Menu menu = new Menu();
		InicioSanduba inicio = new InicioSanduba(null);
		
		inicio.start();
		menu.cadastroUsuario();

		
		
		Cliente cliente = new Cliente("lana", "lana@gmail.com", "1234", "12345678-90", LocalDate.of(2004, 9, 23));
		CarteiraDoCliente cdC = new CarteiraDoCliente();
		cliente.setCarteiraDigital(cdC);

		
		TelaCliente viewsC = new TelaCliente();
		viewsC.telaMinhaContaCliente(cliente);

		
		DadosBancarios banco = new DadosBancarios("CP", "Santander", "Conta corrente", 5, 200);
		Empresa empresa = new Empresa("ConcernedApe", "aux@gmail.com", "5678", "1234567890-12", "", banco, "");
		TelaEmpresa viewE = new TelaEmpresa();
		viewE.telaMinhaContaEmpresa(empresa);

		viewE.telaJogosCadastrados(empresa);
	}

}
