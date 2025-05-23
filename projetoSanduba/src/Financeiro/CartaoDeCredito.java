package Financeiro;

import java.time.LocalDate;

import TratamentoDeErro.DadoInvalidoException;

public class CartaoDeCredito {
	private String nomeDoTitular;
	private String numDoCartao;
	private LocalDate dataDeExpiracao;
	private int cvc;
	private String bandeira;

	public CartaoDeCredito(String nomeDoTitular, String numDoCartao, LocalDate dataDeExpiracao, int cvc) {
		this.nomeDoTitular = nomeDoTitular;
		this.numDoCartao = numDoCartao;
		this.dataDeExpiracao = dataDeExpiracao;
		this.cvc = cvc;
	}

	public String getNumDoCartao() {
		return numDoCartao;
	}

	public void setNumDoCartao(String numDoCartao) throws DadoInvalidoException {
		if (numDoCartao.length() < 16 || numDoCartao.length() > 16) {
			throw new DadoInvalidoException("⚠️ Número de Cartão inválido.");
		}
		if (numDoCartao.isBlank()) {
			throw new DadoInvalidoException("⚠️ Título não pode ser vazio.");
		}
		this.numDoCartao = numDoCartao;
	}

	public String getNomeDoTitular() {
		return nomeDoTitular;
	}

	public void setNomeDoTitular(String nomeDoTitular) throws DadoInvalidoException {
		if (nomeDoTitular.isBlank()) {
			throw new DadoInvalidoException("⚠️ Nome do titular não pode ser vazio.");
		}
		this.nomeDoTitular = nomeDoTitular;
	}

	public LocalDate getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(LocalDate dataDeExpiracao) throws DadoInvalidoException {
		if (dataDeExpiracao == null || dataDeExpiracao.isBefore(LocalDate.now())) {
			throw new DadoInvalidoException("Data invalida");
		}
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) throws DadoInvalidoException {
		int qtdDigitos = String.valueOf(cvc).length();

		if (qtdDigitos < 3 || qtdDigitos < 3) {
			throw new DadoInvalidoException("⚠️ Código de validação do cartão inválido.");
		}
		this.cvc = cvc;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		int primSeg = Integer.parseInt(numDoCartao.substring(0, 2));

		if (numDoCartao.charAt(0) == '4') {
			bandeira = "visa";
		} else if (primSeg >= 51 && primSeg <= 55) {
			bandeira = "mastercard";
		}

		else {
			bandeira = "elo";
		}
		this.bandeira = bandeira;
	}

	public void mostrarDados() {
		System.out.println(
				"💳 Cartão: **** **** **** " + numDoCartao.substring(numDoCartao.length() - 4) + " | " + bandeira);
	}

}
