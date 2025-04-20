package projetoSanduba;

public abstract class DadosCartao {
	private double saldo;
	private DadosBancarios dadosBancarios;

	public DadosCartao(DadosBancarios dadosBancarios) {
		//inicializa o saldo zerado
		this.saldo = 0;
		this.dadosBancarios = dadosBancarios;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	//atribuir o novo saldo que vai ser calculado nas carteiras digitais do cliente e da empresa
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}
	
	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
}
