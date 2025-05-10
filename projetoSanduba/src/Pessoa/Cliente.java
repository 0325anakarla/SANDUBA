package Pessoa;

import projetoSanduba.CarteiraDoCliente;
import projetoSanduba.RegistroDeCompras;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;


public class Cliente extends Usuarios{
	private String cpf;
	private LocalDate natalicio; //data de nascimento
	private CarteiraDoCliente carteiraDigital;
	private List<RegistroDeCompras> historico;
	private List<Jogo> jogosAdquiridos;
	
	
	public Cliente(String nome, String email, String senha, String cpf, LocalDate natalicio) {
		super(nome, email, senha);
		this.cpf = cpf;
		this.natalicio = natalicio;
		//this.carteiraDigital = carteiraDigital; Nao bateu com o cadastro foi mal, tive que tirar. agora temos que arrumar isso
		this.historico = new ArrayList<>();
		this.jogosAdquiridos = new ArrayList<>();
	}

	// --- Geteres e Seteres ------------------------------------------------------------------------//
	
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
		if(natalicio == null || natalicio.isAfter(LocalDate.now())) {
			throw new DadoInvalidoException("Data invalida");
		}
		this.natalicio = natalicio;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) throws DadoInvalidoException {
		if(cpf == null || cpf.isBlank()) {
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
	
	//arrumar
	public void atualizarLista(Jogo jogo) {
		jogosAdquiridos.add(jogo);
	}
 	
	// -- @Override aqui embaixo do implements perfil ------------------------------------------------------//
	
	public void exibirInformacaoPublica() {
		System.out.println("Nome do usuario: "+getNome());
	}
	
	public void exibirInformacaoPrivada() {
		
	}

	public String alterarSenha(String senha){
		setSenha(senha);
		return "| Alterar senha | Senha Atual: " +getSenha() + "Senha nova:" +senha;
	}

	public String alterarEmail(String email) {
		setEmail(email);
		return "| Alterar Email | Email Atual: " +getEmail() + "Email novo:" + email;
	}
	
	public void seusJogos() {
		
	}

	public void excluirConta() {
		
	}
	
	
	public String toString() {
		return  "-------------------------------------------------------------"+
				"\n  Nome do Usuario:   "+getNome()+
				"\n  Email:             "+getEmail()+
				"\n  Senha;             "+getSenha()+
				"\n  Cpf:               "+cpf+
				"\n  Data de nascimento:"+natalicio+
				"\n-------------------------------------------------------------"+
				"\n"+ carteiraDigital.toString()+
				"\n-------------------------------------------------------------";
				
		
	}
	
	
}