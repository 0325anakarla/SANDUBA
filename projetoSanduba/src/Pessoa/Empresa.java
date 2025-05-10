package Pessoa;

import java.util.ArrayList;
import java.util.List;

import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;
import projetoSanduba.CarteiraDaEmpresa;
import projetoSanduba.DadosBancarios;

public class Empresa extends Usuarios{
	
	private String cpnj;
	private String endereco;
	private String razaoSocial;
	private DadosBancarios bancoEmpresa;
	private CarteiraDaEmpresa carteiraDigital;
	

	
	public Empresa(String nome, String email, String senha, String razaoSocial, String cpnj, String endereco, DadosBancarios bancoEmpresa) {
		super(nome, email, senha);
		this.cpnj =cpnj;
		this.endereco = endereco;
		this.bancoEmpresa = bancoEmpresa;
		this.razaoSocial =  razaoSocial;
		CarteiraDaEmpresa carteiraDigital = new CarteiraDaEmpresa(bancoEmpresa);
		this.carteiraDigital = carteiraDigital;
	}
	
	//arraylist que vai estar todos os jogos da empresa
	
	//--- Geteres e Seteres ---------------------------------------------//
	
	public CarteiraDaEmpresa getCarteiraDigital() {
		return carteiraDigital;
	}
	
	public void setCarteiraDigital(CarteiraDaEmpresa carteiraDigital) {
		this.carteiraDigital = carteiraDigital;
	}

	public DadosBancarios getBancoEmpresa() {
		return bancoEmpresa;
	}

	public void setBancoEmpresa(DadosBancarios bancoEmpresa) {
		this.bancoEmpresa = bancoEmpresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws DadoInvalidoException {
		if(endereco ==  null || endereco.isBlank()) {
			throw new DadoInvalidoException("Endereco invalido");
		}
		this.endereco = endereco;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) throws DadoInvalidoException {
		if(cpnj ==  null || cpnj.isBlank()) {
			throw new DadoInvalidoException("Cnpj invalido");
		}
		this.cpnj = cpnj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) throws DadoInvalidoException {
		if(razaoSocial ==  null || razaoSocial.isBlank()) {
			throw new DadoInvalidoException("Razao Social invalida");
		}	
		this.razaoSocial = razaoSocial;
	}
	
	public List<Jogo> getJogosEmpresa() {
		return getJogosEmpresa();
	}
	
	// --- Metodos da Empresa ----------------------------------------------------------------------------------------------------//
	


	@Override
	public void exibirInformacaoPublica() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void exibirInformacaoPrivada() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String alterarSenha(String senha) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String alterarEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void seusJogos() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void excluirConta() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	@Override
	public String toString(){
		return "-------------------------------------------------------------"+
				"  DADOS DA EMPRESA: " +razaoSocial+
				"\n  Email: "+getEmail()+
				"\n  Senha: "+getSenha()+
				"\n  Cnpj: "+cpnj+
				"\n  Endereço: "+endereco+
				"\n-------------------------------------------------------------"+
				"\n "+
				"\n"+bancoEmpresa.toString()+
				"\n\"-------------------------------------------------------------";
	}
	
	
}
