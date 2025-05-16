package Financeiro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import Pessoa.Cliente;
import Pessoa.Empresa;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
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

	public double aplicarCashBack(Cliente cliente) {
		double valorCashBack = getTotal() - cliente.getCarteiraDigital().getCashback();

		return valorCashBack;
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
		} else {
			return false;
		}
	}

	public double aplicaDescontoDe10Porcento(double valor) {
		return valor -= valor * 0.1;
	}

	public Jogo procurarNome(String titulo) throws DadoNaoEncontradoException, DadoInvalidoException {
		if (titulo == null) {
			throw new DadoInvalidoException("O título não pode ser vazio.");
		}

		for (Jogo jogo : jogos.keySet()) {
			if (jogo.getTitulo().equalsIgnoreCase(titulo)) {
				return jogo;
			}
		}
		throw new DadoNaoEncontradoException("Jogo com o título '" + titulo + "' não foi encontrado.");
	}

	public boolean finalizarCompra(Cliente cliente, double cashBack) {
		CarteiraDoCliente carteiraDoCliente = cliente.getCarteiraDigital();
		double valorDaCompra = 0;
		if (cashBack == 0) {
			valorDaCompra = getTotal();
		} else {
			valorDaCompra = cashBack;
		}

		if (cliente.getHistorico().isEmpty()) {
			valorDaCompra = aplicaDescontoDe10Porcento(valorDaCompra);
			System.out.println("Parabéns.\n10% na sua primeira compra.");
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

			LocalDate data = LocalDate.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			data.format(formato);

			RegistroDeCompras registro = new RegistroDeCompras(valorDaCompra, data, jogos, jogos.size());
			cliente.atualizarHistorico(registro);

			carteiraDoCliente.gerarCashback();

			// limpa o carrinho de compras
			jogos.clear();
			return true;
		} else {
			return false;
		}
	}

}
