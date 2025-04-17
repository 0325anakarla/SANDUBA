package projetoSanduba;

public class CarrinhoDeCompras {
	private double total;
	
	public CarrinhoDeCompras() {	
	}
	
	//Falta verificar se é a primeira compra do cliente para aplicar um desconto fixo de 10%
	public void adiciona(Jogo jogo) {
		System.out.println("Adicionando: "+jogo);
		total = total + jogo.getPreco();
	}
	
	public double getTotal() {
		return total;
	}
}
