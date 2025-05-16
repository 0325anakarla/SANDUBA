package Financeiro;

//carteira digital da empresa
public class CarteiraDaEmpresa extends DadosCartao {
	private DadosBancarios dadosBancarios;
	private double fatura;
	// acumulo de lucro, que corresponde a retirada de 5% das vendas, para cada
	// venda realizada

	public CarteiraDaEmpresa(DadosBancarios dadosBancarios) {
		super();
		this.dadosBancarios = dadosBancarios;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public double getFatura() {
		return fatura;
	}

	// metodo onde calcula o saldo das vendas dos jogos
	// valor -> valor das vendas de jogos
	public void adicionar(double valor) {
		double vendas = retirar(valor);

		double saldo = super.getSaldo() + vendas;

		super.setSaldo(saldo);
	}

	private double retirar(double valor) {
		double lucro = valor * 0.05; // lucro do sistema
		fatura += lucro;

		if (CarteiraDoAdm.adidionar(fatura)) {
			fatura = 0;
		}

		return valor = valor - lucro;
	}

	// metodo para a empresa sacar o dinheiro das vendas dos jogos
	public boolean sacar(double valor) {
		if (valor > 0 && valor <= super.getSaldo()) {
			double saldo = super.getSaldo() - valor;

			super.setSaldo(saldo);
			return true;
		} else {
			return false;
		}
	}
}
