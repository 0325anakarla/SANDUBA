package Financeiro;

public class CarteiraDoAdm {
	private static double saldo;

	public CarteiraDoAdm() {

	}

	public double getSaldo() {
		return saldo;
	}

	public static boolean adidionar(double valor) {
		if (valor > 0) {
			saldo += valor;
			return true;
		} else {
			return false;
		}
	}
}
