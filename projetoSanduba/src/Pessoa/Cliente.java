package Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;
import Financeiro.CarteiraDoCliente;
import Financeiro.RegistroDeCompras;
import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;

public class Cliente extends Usuarios{
	private String cpf;
	private LocalDate natalicio; // data de nascimento
	private CarteiraDoCliente carteiraDigital;
	private List<RegistroDeCompras> historico;
	private List<Jogo> jogosAdquiridos;

	public Cliente(String nome, String email, String senha, String cpf, LocalDate natalicio) {
		super(nome, email, senha);
		this.cpf = cpf;
		this.natalicio = natalicio;
		// this.carteiraDigital = carteiraDigital; Nao bateu com o cadastro foi mal,
		// tive que tirar. agora temos que arrumar isso
		this.historico = new ArrayList<>();
		this.jogosAdquiridos = new ArrayList<>();
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

	public String getCpf(){
	    if (cpf == null || !cpf.matches("\\d{11}") ) {
	    	throw new DadoInvalidoException(cpf);
	    }
	    return cpf.substring(0, 3) + "." +
	           cpf.substring(3, 6) + "." +
	           cpf.substring(6, 9) + "-" +
	           cpf.substring(9, 11);
	    //subtring eh tipo um slicing(do python) ele vai separar a string em intervalos 
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

	public void atualizarLista(Jogo jogo) {
		for (Jogo jogo1 : jogosAdquiridos) {
			if (!jogo1.getTitulo().equalsIgnoreCase(jogo.getTitulo())) {
				jogosAdquiridos.add(jogo);
			}
		}
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
	    return "-------------------------------------------------------------"
	         + "\n  DADOS DO CLIENTE:"
	         + "\n  Nome:              " + getNome()
	         + "\n  Email:             " + getEmail()
	         + "\n  CPF:               " + cpf
	         + "\n  Nascimento:        " + natalicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
	         + "\n-------------------------------------------------------------"
	         + "\n  Carteira:          " + (carteiraDigital != null ? carteiraDigital.toString() : "Sem carteira")
	         + "\n-------------------------------------------------------------";
	}
}