package projetoSanduba;

//carteira digital da empresa
public class CarteiraDaEmpresa extends DadosCartao {
	private DadosBancarios dadosBancarios;
	private double fatura; 
	//acumulo de lucro, que corresponde a retirada de 5% das vendas, para cada venda realizada
	//depois relacionar, com o admin, o atributo fatura
	
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
	
	//metodo onde calcula o saldo das vendas dos jogos
	//valor -> valor das vendas de jogos
	//porcentagem -> porcentagem que vai ser retirada por cada venda de jogos
	public void adicionar(double valor, double porcentagem) {
		double vendas = retirar(valor, porcentagem);
		
		double saldo = super.getSaldo() + vendas;
		
		super.setSaldo(saldo);
	}
	
	//metodo para retirar um certa porcentagem da venda dos jogos e acumular a fatura
	
	//um duvida ele num vai so retirar nao, precisa desse porcentagem(analice)
	//resposta: a porcentagem está sendo acumulada na fatura(alana)
	//mas falta relacionar a fatura com o admin, que é o responsável por gerenciar o sistema
	private double retirar(double valor, double porcentagem) {
		double lucro = valor * porcentagem; //lucro do sistema
		fatura += lucro;
		
		return valor = valor - lucro;
	}
	
	//metodo para a empresa sacar o dinheiro das vendas dos jogos
	public boolean sacar(double valor) {
		if (valor <= super.getSaldo()) {
			double saldo = super.getSaldo() - valor;
			
			super.setSaldo(saldo);
			return true;
		} else {
			return false;
		}
	}
}
