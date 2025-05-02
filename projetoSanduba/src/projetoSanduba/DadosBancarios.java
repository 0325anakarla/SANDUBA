package projetoSanduba;

public class DadosBancarios {
	private String titularConta;
	private String nomeBanco;
	private String tipoConta; // conta correntem, poupanca , pj...etc
	private int agencia;
	private int numeroConta;

	public DadosBancarios(String titularConta, String nomeBanco, String tipoConta, int agencia, int numeroConta) {
		this.setTitularConta(titularConta);
		this.setNomeBanco(nomeBanco);
		this.setTipoConta(tipoConta);
		this.setAgencia(agencia);
		this.setNumeroConta(numeroConta);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}
	
	/*public void mostrarDadosBancarios() {
		System.out.println("");
	}*/

}