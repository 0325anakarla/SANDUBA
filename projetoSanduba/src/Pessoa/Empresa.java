package Pessoa;
import Interfaces.ControleDeJogos;
import Interfaces.ResumoDeVendas;
import projetoSanduba.CarteiraDaEmpresa;
import projetoSanduba.DadosBancarios;
import projetoSanduba.Jogo;

public class Empresa extends Usuarios implements ControleDeJogos, ResumoDeVendas{
	private String cpnj;
	private String  endereco;
	private DadosBancarios bancoEmpresa;
	private CarteiraDaEmpresa carteiraDigital;
	
	public Empresa(String nome, String email, String senha, String cpnj, String endereco, DadosBancarios bancoEmpresa) {
		super(nome, email, senha);
		this.setCpnj(cpnj);
		this.setEndereco(endereco);
		this.setBancoEmpresa(bancoEmpresa);
		CarteiraDaEmpresa carteiraDigital = new CarteiraDaEmpresa(bancoEmpresa);
		this.setCarteiraDigital(carteiraDigital);
	}
	
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
	
	// --- Metodos da Empresa ----------------------------------------------------------------------------------------------------//
	

	@Override
	public void exibirInformacaoPublica() {
		
		
	}

	@Override
	public void exibirInformacaoPrivada() {
		
		
	}

	@Override
	public String alterarSenha(String senha) {
		
		return null;
	}

	@Override
	public String alterarEmail(String email) {
				return null;
	}

	@Override
	public void seusJogos() {
				
	}

	@Override
	public void excluirConta() {
				
	}

	@Override
	public void resumoDeVendasindividual() {
				
	}

	@Override
	public void resumoDeVendasGeral() {
				
	}

	@Override
	public void cadastrarJogos(String titulo, double preco, String descricao, String categorias, int classEtaria,
			String idiomas, String plataDisp, String modAtivacao) {
				
	}

	@Override
	public void alterarDadosDoJogo(Jogo jogo) {
				
	}

	@Override
	public void excluirJogo() {
				
	}

	@Override
	public void pesquisarJogo() {
				
	}
	
	
}
