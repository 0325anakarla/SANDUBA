package Financeiro;



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
			throw new DadoInvalidoException("Agencia Invalida");
		}
		this.agencia = agencia;
	}

	public String getTipoConta() throws DadoInvalidoException {
		if (tipoConta == null )  {
	    	throw new DadoInvalidoException(tipoConta);
	    }
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) throws DadoInvalidoException {
		if (tipoConta == null ) {
			throw new DadoInvalidoException("Tipo de conta invalida");
		}
		this.tipoConta = tipoConta;
	}

	public String getNomeBanco() throws DadoInvalidoException {
		if (nomeBanco == null )  {
	    	throw new DadoInvalidoException(nomeBanco);
	    }

		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) throws DadoInvalidoException {
		if (nomeBanco == null ) {
			throw new DadoInvalidoException("Nome de Banco Invalido");
		}
		this.nomeBanco = nomeBanco;
	}

	public String getTitularConta() throws DadoInvalidoException {
		if (titularConta == null )  {
	    	throw new DadoInvalidoException(titularConta);
	    }
		
		return titularConta;
	}

	public void setTitularConta(String titularConta) throws DadoInvalidoException {
		if (titularConta == null ) {
			throw new DadoInvalidoException("Titular Invalido");
		}
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