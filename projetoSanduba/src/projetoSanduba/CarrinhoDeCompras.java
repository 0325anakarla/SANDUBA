package projetoSanduba;

import Pessoa.Cliente;

public class CarrinhoDeCompras {
	private double total;
	
	public CarrinhoDeCompras() {	
	}
	
	//Falta verificar se é a primeira compra do cliente para aplicar um desconto fixo de 10%
	//ainda falta implementar o histórico de compras
	public void adiciona(Jogo jogo) {
		System.out.println("Adicionando: "+jogo);
		total = total + jogo.getPreco();
	}
	
	public double getTotal() {
		return total;
	}
	
	public boolean finalizarCompra(Cliente cliente) {
		if (total <= cliente.getCarteiraDigital().getSaldo()) {
			cliente.getCarteiraDigital().descontar(total);
			
			//construi o restante do código
			
			cliente.gerarCashback();
			return true;
		} else {
			return false;
		}
	}
}
