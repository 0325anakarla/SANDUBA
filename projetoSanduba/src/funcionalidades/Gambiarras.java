package funcionalidades;

public class Gambiarras {

	public static void textoLento(String texto, int velocidade) {
		for (char c : texto.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(velocidade);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void limparTela() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	public class Cores {
		public static final String reset = "\u001B[0m";
		public static final String red = "\u001B[31m";
		public static final String green = "\u001B[32m";
		public static final String yellow = "\u001B[33m";
		public static final String blue = "\u001B[34m";
		public static final String purple = "\u001B[35m";
		public static final String ciano = "\u001B[36m";
	}
}
