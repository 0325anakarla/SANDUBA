package projetoSanduba;

import java.util.HashMap;
import java.util.Map;

import Pessoa.Cliente;

public class CarrinhoDeCompras {
	private double total;
	private Map<Jogo, Double> jogos;
	
	public CarrinhoDeCompras() {
		this.jogos = new HashMap<>();
	}
	
	//Falta verificar se é a primeira compra do cliente para aplicar um desconto fixo de 10%
	//ainda falta implementar o histórico de compras
	public void adiciona(Jogo jogo) {
		jogos.put(jogo, jogo.getPreco());
	}
	
	public Map<Jogo, Double> getJogos() {
		return jogos;
	}
	
	public double getTotal() {
		total = 0;
		
		for (Map.Entry<Jogo, Double> entrada : jogos.entrySet()) {
			Jogo jogo = entrada.getKey();
			double preco = jogo.getPreco();
			total += preco;
		}
		
		return total;
	}

	public void aplicarPercentualDesconto(double desconto) {
		for (Jogo jogo : jogos.keySet()) {
			jogo.aplicaDescontoDe(desconto);
			jogos.put(jogo, jogo.getPreco());
		}
	}
	
	public void imprimirCarrinho() {
		System.out.printf("%-40s %-15s%n", "Jogo", "Valor Unitário");
		System.out.println("--------------------------------------------------------");
		for (Map.Entry<Jogo, Double> entrada : jogos.entrySet()) {
			Jogo jogo = entrada.getKey();
			double preco = jogo.getPreco();
			System.out.printf("%-40s R$ %-13.2f%n", jogo.getResumo(), preco);
		}
		System.out.println("--------------------------------------------------------");
		System.out.printf("%-40s R$ %-13.2f%n", "TOTAL", getTotal());
	}

	public boolean remove(Jogo jogo) {
		if (jogos.containsKey(jogo)) {
			jogos.remove(jogo);
			return true;
		} else{
			return false;
		}
	}
	
	public boolean finalizarCompra(Cliente cliente) {
		if (getTotal() <= cliente.getCarteiraDigital().getSaldo()) {
			cliente.getCarteiraDigital().descontar(getTotal());
			
			//construi o restante do código
			
			cliente.getCarteiraDigital().gerarCashback();
			return true;
		} else {
			return false;
		}
	}
}
