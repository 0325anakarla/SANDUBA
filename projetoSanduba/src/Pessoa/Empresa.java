package Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jogo.Jogo;
import projetoSanduba.CarteiraDaEmpresa;
import projetoSanduba.DadosBancarios;
import jogo.Jogo;
import projetoSanduba.Venda;

public class Empresa extends Usuarios{
	
	private String cpnj;
	private String endereco;
	private DadosBancarios bancoEmpresa;
	private CarteiraDaEmpresa carteiraDigital;
	private String razaoSocial;
	private List<Jogo> jogosEmpresa;
	private Map<Jogo, Venda> vendasPorJogo;
	

	public Empresa(String nome, String email, String senha, String cpnj, String endereco, DadosBancarios bancoEmpresa, String razaoSocial) {
		super(nome, email, senha);
		this.setCpnj(cpnj);
		this.setEndereco(endereco);
		this.setBancoEmpresa(bancoEmpresa);
		this.setRazaoSocial(razaoSocial);
		CarteiraDaEmpresa carteiraDigital = new CarteiraDaEmpresa(bancoEmpresa);
		this.setCarteiraDigital(carteiraDigital);
		this.jogosEmpresa = new ArrayList<>();
		this.vendasPorJogo = new HashMap<>();
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

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public List<Jogo> getJogosEmpresa() {
		return jogosEmpresa;
	}
	
	public Map<Jogo, Venda> getVendas() {
		return vendasPorJogo;
	}
	
	//verifica se a chave associada, que no caso é o objeto Jogo, existe no mapa vendasPorJogo
	//se nao existir cria um novo valor associado aquela chave
	//e adiciona a quantidade de jogos vendidos daquele jogo
	public void registrarVenda(Jogo jogo, int quantidade) {
		if (vendasPorJogo.containsKey(jogo)) {
			Venda venda = vendasPorJogo.get(jogo);
			venda.adicionaQuantidadeVendida(quantidade);
			vendasPorJogo.put(jogo, venda);
		} else {
			Venda venda = new Venda(jogo.getTitulo(), jogo.getPreco(), quantidade);
			vendasPorJogo.put(jogo, venda);
		}
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
