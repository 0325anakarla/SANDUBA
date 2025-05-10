package projetoSanduba;

import java.util.HashMap;
import java.util.Map;

import Pessoa.Cliente;
import Pessoa.Empresa;
import jogo.Jogo;

public class CarrinhoDeCompras {
	private double total;
	private Map<Jogo, Double> jogos;
	
	public CarrinhoDeCompras() {
		this.jogos = new HashMap<>();
	}
	
	public void adiciona(Jogo jogo) {
		jogos.put(jogo, jogo.getPreco());
	}
	
	public Map<Jogo, Double> getJogos() {
		return jogos;
	}
	
	public double getTotal() {
		total = 0;
		
		for (Map.Entry<Jogo, Double> entrada : jogos.entrySet()) {
			double preco = entrada.getValue();
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
			double preco = entrada.getValue();
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

	public double aplicaDescontoDe10Porcento(double valor) {
		return valor -= valor * 0.1;
	}
	
	public boolean finalizarCompra(Cliente cliente) {
		CarteiraDoCliente carteiraDoCliente = cliente.getCarteiraDigital();
		double valorDaCompra = getTotal();

		if (cliente.getHistorico().isEmpty()) {
			valorDaCompra = aplicaDescontoDe10Porcento(valorDaCompra);
		}

		if (valorDaCompra <= carteiraDoCliente.getSaldo()) {
			
			for (Map.Entry<Jogo, Double> entrada : jogos.entrySet()) {
				Jogo jogo = entrada.getKey();
				double preco = jogo.getPreco();
				Empresa empresa = jogo.getEmpresa();
				CarteiraDaEmpresa carteiraDaEmpresa = empresa.getCarteiraDigital();
				carteiraDaEmpresa.adicionar(preco);
				empresa.registrarVenda(jogo, 1);
				cliente.atualizarLista(jogo);
			}

			carteiraDoCliente.descontar(valorDaCompra);

			//passar a data do dia da compra realizada com sucesso
			RegistroDeCompras registro = new RegistroDeCompras(valorDaCompra, null, jogos);
			cliente.atualizarHistorico(registro);
			
			carteiraDoCliente.gerarCashback();
			
			//limpa o carrinho de compras
			jogos.clear();
			return true;
		} else {
			return false;
		}
	}
}
