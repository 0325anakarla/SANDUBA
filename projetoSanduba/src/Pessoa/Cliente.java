package Pessoa;

import projetoSanduba.CarteiraDoCliente;
import projetoSanduba.Jogo;
import projetoSanduba.RegistroDeCompras;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente extends Usuarios{
	private int cpf;
	private LocalDate natalicio; //data de nascimento
	private CarteiraDoCliente carteiraDigital;
	private List<RegistroDeCompras> historico;
	private List<Jogo> jogosAdquiridos;
	
	
	public Cliente(String nome, String email, String senha, int cpf, LocalDate natalicio, CarteiraDoCliente carteiraDigital) {
		super(nome, email, senha);
		this.cpf = cpf;
		this.natalicio = natalicio;
		this.carteiraDigital = carteiraDigital;
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
	
	public void setNatalicio(LocalDate natalicio) {
		this.natalicio = natalicio;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
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
		jogosAdquiridos.add(jogo);
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