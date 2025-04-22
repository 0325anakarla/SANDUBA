package projetoSanduba;

//carteira digital do cliente
public class CarteiraDoCliente extends DadosCartao {
	
	public CarteiraDoCliente(DadosBancarios dadosBancarios) {
		super(dadosBancarios);
	}
	
	public boolean depositar(double valor) {
		if (valor > 0) {
			double saldo = super.getSaldo() + valor;
			
			super.setSaldo(saldo);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean descontar(double valor) {
		if (valor > 0) {
			double saldo = super.getSaldo() - valor;
			
			super.setSaldo(saldo);
			return true;
		} else {
			return false;
		}
	}
}
