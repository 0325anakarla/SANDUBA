package Financeiro;

public class Venda {
	private String tituloDoJogo;
	private double preco;
	private int quantidadeVendida;

	public Venda(String tituloDoJogo, double preco, int quantidadeVendida) {
		this.tituloDoJogo = tituloDoJogo;
		this.preco = preco;
		this.quantidadeVendida = quantidadeVendida;
	}

	public double getPrecoTotal() {
		return preco * quantidadeVendida;
	}

	public double getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void adicionaQuantidadeVendida(int quantidade) {
		this.quantidadeVendida += quantidade;
	}

	public String getTituloDoJogo() {
		return tituloDoJogo;
	}
}
