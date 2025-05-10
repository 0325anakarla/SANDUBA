package Console;

import TratamentoDeErro.DadoInvalidoException;

public class TesteMenu {

	public static void main(String[] args) throws DadoInvalidoException {
		TelaCliente viewsC = new TelaCliente();
		viewsC.telaMinhaContaCliente();

		TelaEmpresa viewE = new TelaEmpresa();
		viewE.telaMinhaContaEmpresa(null);

		viewE.telaJogosCadastrados(null);
	}

}
