package Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;
import Financeiro.CartaoDeCredito;
import Financeiro.CarteiraDoCliente;
import Financeiro.RegistroDeCompras;
//import TratamentoDeErro.DadoInvalidoException;
//import jogo.Jogo;

public class Cliente extends Usuarios {
	private String cpf;
	private LocalDate natalicio; // data de nascimento
	private CarteiraDoCliente carteiraDigital;
	private List<RegistroDeCompras> historico;
	private List<Jogo> jogosAdquiridos;
	private final List<Jogo> listaDeDesejos;
	private final List<CartaoDeCredito> cartoesCadastrados;

	public Cliente(String nome, String email, String senha, String cpf, LocalDate natalicio) {
		super(nome, email, senha);
		this.cpf = cpf;
		this.natalicio = natalicio;
		// this.carteiraDigital = carteiraDigital; Nao bateu com o cadastro foi mal,
		// tive que tirar. agora temos que arrumar isso
		this.historico = new ArrayList<>();
		this.jogosAdquiridos = new ArrayList<>();
		this.listaDeDesejos = new ArrayList<>();
		this.cartoesCadastrados = new ArrayList<>();
	}

	// --- Geteres e Seteres
	// ------------------------------------------------------------------------//

	public CarteiraDoCliente getCarteiraDigital() {
		return carteiraDigital;
	}

	public void setCarteiraDigital(CarteiraDoCliente carteiraDigital) {
		this.carteiraDigital = carteiraDigital;
	}

	public LocalDate getNatalicio() {
		return natalicio;
	}

	public void setNatalicio(LocalDate natalicio) throws DadoInvalidoException {
		if (natalicio == null || natalicio.isAfter(LocalDate.now())) {
			throw new DadoInvalidoException("Data invalida");
		}
		this.natalicio = natalicio;
	}

	public String getCpf() throws DadoInvalidoException {
		if (cpf == null || !cpf.matches("\\d{11}")) {
			throw new DadoInvalidoException(cpf);
		}
		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		// subtring eh tipo um slicing(do python) ele vai separar a string em intervalos
	}

	public void setCpf(String cpf) throws DadoInvalidoException {
		if (cpf == null || cpf.isBlank() || !cpf.matches("\\d{11}")) {
			throw new DadoInvalidoException("Cpf invalido");
		}
		this.cpf = cpf;
	}

	public List<RegistroDeCompras> getHistorico() {
		return historico;
	}

	public void atualizarHistorico(RegistroDeCompras registro) {
		historico.addLast(registro);
	}

	public List<Jogo> getJogosAdquiridos() {
		return jogosAdquiridos;
	}

	public Jogo procurarNomeJA(String titulo) throws DadoNaoEncontradoException, DadoInvalidoException {
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new DadoInvalidoException("O título não pode ser vazio.");
		}

		for (Jogo jogo : jogosAdquiridos) {
			if (jogo.getTitulo().equalsIgnoreCase(titulo)) {
				return jogo;
			}
		}
		throw new DadoNaoEncontradoException("Jogo com o título '" + titulo + "' não foi encontrado.");
	}

	public void atualizarLista(Jogo jogo) {
		for (Jogo jogo1 : jogosAdquiridos) {
			if (jogo1.getTitulo().equalsIgnoreCase(jogo.getTitulo())) {
				throw new DadoDuplicadoException("O jogo " + jogo.getTitulo() + " já foi adquirido.");
			}
		}
		jogosAdquiridos.add(jogo);
	}

	// -- @Override aqui embaixo do implements perfil
	// ------------------------------------------------------//

	public void exibirInformacaoPublica() {
		System.out.println("Nome do usuario: " + getNome());
	}

	public void exibirInformacaoPrivada() {

	}

	@Override
	public void seusJogos() {

	}

	@Override
	public String mostrarDetalhesUsuario() {
		return "-------------------------------------------------------------" + "\n  DADOS DO CLIENTE:"
				+ "\n  Nome:              " + getNome() + "\n  Email:             " + getEmail()
				+ "\n  CPF:               " + cpf + "\n  Nascimento:        "
				+ natalicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\n-------------------------------------------------------------" + "\n  Carteira:          "
				+ (carteiraDigital != null ? carteiraDigital.toString() : "Sem carteira")
				+ "\n-------------------------------------------------------------";
	}

	// Lista de desejos
	public List<Jogo> getJogos() {
		return listaDeDesejos;
	}

	public void addListaDeDesejo(Jogo jogo) throws DadoInvalidoException {
		if (jogo == null) {
			throw new DadoInvalidoException("O jogo não pode ser nulo.");
		}
		if (listaDeDesejos.contains(jogo)) {
			throw new DadoDuplicadoException("O jogo " + jogo.getTitulo() + " ja foi adicionado.");
		}
		listaDeDesejos.add(jogo);
	}

	public void removeListaDeDesejo(Jogo jogo) throws DadoInvalidoException {
		if (jogo == null) {
			throw new DadoInvalidoException("O jogo não pode ser nulo.");
		}
		if (!listaDeDesejos.contains(jogo)) {
			throw new DadoNaoEncontradoException("O jogo " + jogo.getTitulo() + " não está em sua Lista de desejos.");
		}
		listaDeDesejos.remove(jogo);
	}

	public Jogo procurarNomeLD(String titulo) throws DadoNaoEncontradoException {
		if (titulo == null) {
			throw new DadoNaoEncontradoException("O título não pode ser vazio.");
		}

		for (Jogo jogo : listaDeDesejos) {
			if (jogo.getTitulo().equalsIgnoreCase(titulo)) {
				return jogo;
			}
		}
		throw new DadoNaoEncontradoException("Jogo com o título '" + titulo + "' não foi encontrado.");
	}

	public String resumoListaDeDesejos() {
		StringBuilder resumo = new StringBuilder();

		for (Jogo j : listaDeDesejos) {
			resumo.append(
					String.format("- %s [%s] | R$ %.2f\n", j.getTitulo(), j.getCategoriasValidas(), j.getPreco()));
		}

		return resumo.toString();
	}

	// teste cartao de credito
	public List<CartaoDeCredito> getCartoesCadastrados() {
		return cartoesCadastrados;
	}

	public CartaoDeCredito procurarUltimosDig(String ultimosDig) throws DadoInvalidoException {
		if (ultimosDig == null) {
			throw new DadoInvalidoException("Os últimos dígitos não podem ser vazios.");
		}

		for (CartaoDeCredito cartao : cartoesCadastrados) {
			String ultimosDigitos = cartao.getNumDoCartao().substring(cartao.getNumDoCartao().length() - 4);
			if (ultimosDigitos.equals(ultimosDig)) {
				return cartao;
			}
		}
		throw new DadoNaoEncontradoException("Cartão com os últimos dígitos '" + ultimosDig + "' não foi encontrado.");
	}

	public void addCartaoDeCredito(CartaoDeCredito cartao) {
		if (cartoesCadastrados.contains(cartao)) {
			throw new DadoDuplicadoException("O cartão já foi adicionado.");
		}
		cartoesCadastrados.add(cartao);
	}

	public void removerCartao(CartaoDeCredito cartao) {
		if (!cartoesCadastrados.contains(cartao)) {
			throw new DadoNaoEncontradoException("O cartão não está cadastrado.");
		}
		cartoesCadastrados.remove(cartao);
	}

	public void mostrarCartoes() {
		if (cartoesCadastrados.isEmpty()) {
			throw new DadoNaoEncontradoException("Não há cartões cadastrados");
		}
		for (CartaoDeCredito cartao : cartoesCadastrados) {
			cartao.mostrarDados();
		}
	}

}