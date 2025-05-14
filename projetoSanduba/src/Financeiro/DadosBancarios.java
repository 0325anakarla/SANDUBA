package Financeiro;

import java.time.LocalDate;

import TratamentoDeErro.DadoInvalidoException;

public class DadosBancarios {
	private String titularConta;
	private String nomeBanco;
	private String tipoConta; // conta correntem, poupanca , pj...etc
	private String agencia;
	private String numeroConta;

	public DadosBancarios(String titularConta, String nomeBanco, String tipoConta, String agencia, String numeroConta) throws DadoInvalidoException {
		this.titularConta =titularConta;
		this.nomeBanco = nomeBanco;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public String getNumeroConta() throws DadoInvalidoException {
		 if (numeroConta == null || !numeroConta.matches("\\d{8}") ) {
		    	throw new DadoInvalidoException(numeroConta);
		    }
		    return numeroConta;
	}

	public void setNumeroConta(String numeroConta) throws DadoInvalidoException  {
		if (numeroConta == null || numeroConta.isBlank() || !numeroConta.matches("\\d{9}")) {
			throw new DadoInvalidoException("Número da conta invalido");
		}
		this.numeroConta = numeroConta;	}

	public String getAgencia() throws DadoInvalidoException {
		if (agencia == null || !agencia.matches("\\d{4}") ) {
	    	throw new DadoInvalidoException(agencia);
	    }
		return agencia;

	}

	public void setAgencia(String agencia)throws DadoInvalidoException{
		if (agencia == null || agencia.isBlank() || !agencia.matches("\\d{4}")) {
			throw new DadoInvalidoException("Cpf invalido");
		}
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
	
	
	public String toString() {
		return "\n  DADOS BANCARIOS "+
				"\n  Titular da Conta: "+titularConta+
				"\n  Banco:            "+nomeBanco+
				"\n  Conta:            "+tipoConta+
				"\n  Agência:          "+agencia+
				"\n  Número da conta:  "+numeroConta;
	}

}