package projetoSanduba;

//carteira digital da empresa
public class CarteiraDaEmpresa extends DadosCartao {
	private double fatura; //acumulo de lucro, que corresponde a retirada de 5% das vendas, para cada venda realizada
	
	public CarteiraDaEmpresa(DadosBancarios dadosBancarios) {
		super(dadosBancarios);
	}
	
	public double getFatura() {
		return fatura;
	}
	
	//metodo onde calcula o saldo das vendas dos jogos
	public void adicionar(double valor, double porcentagem) {
		double vendas = retirar(valor, porcentagem);
		
		double saldo = super.getSaldo() + vendas;
		
		super.setSaldo(saldo);
	}
	
	//metodo para retirar um certa porcentagem da venda dos jogos e acumular a fatura
	
	//um duvida ele num vai so retirar nao, precisa desse porcentagem(analice)
	private double retirar(double valor, double porcentagem) {
		double lucro = valor * porcentagem;
		fatura += lucro;
		
		return valor = valor - lucro;
	}
}
