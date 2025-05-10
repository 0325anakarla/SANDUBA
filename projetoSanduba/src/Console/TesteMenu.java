package Console;

import TratamentoDeErro.DadoInvalidoException;

public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {
		
		Menu menu = new Menu();
		menu.cadastro();
		
		TelaCliente viewsC = new TelaCliente();
		viewsC.telaMinhaContaCliente();

		TelaEmpresa viewE = new TelaEmpresa();
		viewE.telaMinhaContaEmpresa();

	}

}
