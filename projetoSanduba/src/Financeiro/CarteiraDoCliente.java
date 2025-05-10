package Financeiro;

//carteira digital do cliente
public class CarteiraDoCliente extends DadosCartao {
	private double cashback; //onde vai ser gerado a cada compra realizada com sucesso
	
	public CarteiraDoCliente() {
		super();
	}

	public double getCashback() {
		return cashback;
	}
	
	public void gerarCashback() {
		cashback += 0.01;
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
	
	@Override
	public String toString() {
		return "\n  Saldo da conta:    "+getSaldo()+
			   "\n  Saldo no cashback: "+cashback;
	}
}
