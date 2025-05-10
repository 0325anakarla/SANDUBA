package Console;

import java.time.LocalDate;

import Financeiro.CarteiraDoCliente;
import Pessoa.Cliente;
import TratamentoDeErro.DadoInvalidoException;

public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {
		Cliente cliente = new Cliente("lana", "lana@gmail.com", "1234", "12345678-90", LocalDate.of(2004, 9, 23));
		CarteiraDoCliente cdC = new CarteiraDoCliente();
		cliente.setCarteiraDigital(cdC);
		
		TelaCliente viewsC = new TelaCliente();
		viewsC.telaMinhaContaCliente(cliente);

		TelaEmpresa viewE = new TelaEmpresa();
		viewE.telaMinhaContaEmpresa(null);

		viewE.telaJogosCadastrados(null);
	}

}
