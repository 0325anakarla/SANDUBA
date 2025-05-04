package Pessoa;

import projetoSanduba.CarteiraDoCliente;
import java.time.LocalDate;


public class Cliente extends Usuarios{
	private int cpf;
	private LocalDate natalicio; //data de nascimento
	private CarteiraDoCliente carteiraDigital;
	
	
	public Cliente(String nome, String email, String senha, int cpf, LocalDate natalicio, CarteiraDoCliente carteiraDigital) {
		super(nome, email, senha);
		this.cpf = cpf;
		this.natalicio = natalicio;
		this.carteiraDigital = carteiraDigital;
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
	
	public void setNatalicio(LocalDate natalicio) {
		this.natalicio = natalicio;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	// -- @Override aqui embaixo do implements perfil ------------------------------------------------------//
	
	public void exibirInformacaoPublica() {
		System.out.println("Nome do usuario: "+getNome());
	}
	
	public void exibirInformacaoPrivada() {
		
	}

	public String alterarSenha(String senha) {
		setSenha(senha);
		return "| Alterar senha | Senha Atual: " +getSenha() + "Senha nova:" +senha;
	}

	public String alterarEmail(String email) {
		setEmail(email);
		return "| Alterar Email | Email Atual: " +getEmail() + "Email novo:" +email;
	}
	
	public void seusJogos() {
		
	}

	public void excluirConta() {
		
	}
	
}