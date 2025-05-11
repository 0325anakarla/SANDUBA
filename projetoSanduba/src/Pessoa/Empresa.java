package Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import Financeiro.CarteiraDaEmpresa;
import Financeiro.DadosBancarios;
import Financeiro.Venda;
import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;


public class Empresa extends Usuarios{
	private String cpnj;
	private String endereco;
	private String razaoSocial;
	private DadosBancarios bancoEmpresa;
	private CarteiraDaEmpresa carteiraDigital;
	private List<Jogo> jogosEmpresa;
	private Map<Jogo, Venda> vendasPorJogo;

	public Empresa(String nome, String email, String senha, String cpnj, String endereco, DadosBancarios bancoEmpresa,
			String razaoSocial) {
		super(nome, email, senha);
		this.cpnj = cpnj;
		this.endereco = endereco;
		this.bancoEmpresa = bancoEmpresa;
		this.razaoSocial = razaoSocial;
		CarteiraDaEmpresa carteiraDigital = new CarteiraDaEmpresa(bancoEmpresa);
		this.carteiraDigital = carteiraDigital;
		this.jogosEmpresa = new ArrayList<>();
		this.vendasPorJogo = new HashMap<>();
	}

	// arraylist que vai estar todos os jogos da empresa

	// --- Geteres e Seteres ---------------------------------------------//

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
		if (endereco == null || endereco.isBlank()) {
			throw new DadoInvalidoException("Endereco invalido");
		}
		this.endereco = endereco;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) throws DadoInvalidoException {
		if (cpnj == null || cpnj.isBlank()) {
			throw new DadoInvalidoException("Cnpj invalido");
		}
		this.cpnj = cpnj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) throws DadoInvalidoException {
		if (razaoSocial == null || razaoSocial.isBlank()) {
			throw new DadoInvalidoException("Razao Social invalida");
		}
		this.razaoSocial = razaoSocial;
	}

	public List<Jogo> getJogosEmpresa() {
		return jogosEmpresa;
	}

	public Map<Jogo, Venda> getVendasPorJogo() {
		return vendasPorJogo;
	}

	// verifica se a chave associada, que no caso é o objeto Jogo, existe no mapa
	// vendasPorJogo
	// se nao existir cria um novo valor associado aquela chave
	// e adiciona a quantidade de jogos vendidos daquele jogo
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

	// --- Metodos da Empresa
	// ----------------------------------------------------------------------------------------------------//

	
	//public void seusJogos() 
	
	
	@Override
	public String mostrarDetalhesUsuario() {
	    return "-------------------------------------------------------------"
	            + "\n  DADOS DA EMPRESA: " + razaoSocial
	            + "\n  Email: " + getEmail()
	            + "\n  Cpnj: " + cpnj
	            + "\n  Endereço: " + endereco
	            + "\n-------------------------------------------------------------"
	            + "\n" + bancoEmpresa.toString()
	            + "\n-------------------------------------------------------------";
	}


}
