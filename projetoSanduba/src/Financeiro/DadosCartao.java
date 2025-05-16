package Financeiro;

public abstract class DadosCartao {
	private double saldo;

	public DadosCartao() {
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	//atribuir o novo saldo que vai ser calculado nas carteiras digitais do cliente e da empresa
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\n 💼 Saldo da conta:    "+saldo;
	}
}
