package projetoSanduba;

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
	
	
	
	
}
