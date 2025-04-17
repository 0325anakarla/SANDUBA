package Cadastro;

public class Empresa extends Usuarios {
	private String cpnj;
	private String  endereco;
	private DadosBancarios bancoEmpresa;
	
	public Empresa(String nome, String email, String senha, String cpnj, String endereco) {
		super(nome, email, senha);
		this.setCpnj(cpnj);
		this.setEndereco(endereco);
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
