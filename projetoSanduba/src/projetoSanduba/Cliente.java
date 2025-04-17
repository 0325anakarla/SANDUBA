package projetoSanduba;

public class Cliente extends Usuarios{
	private int cpf;
	private String natalicio; //data de nascimento
	
	
	public Cliente(String nome, String email, String senha, int cpf, String natalicio) {
		super(nome, email, senha);
		this.setCpf(cpf);
		this.setNatalicio(natalicio);
	}


	public String getNatalicio() {
		return natalicio;
	}


	public void setNatalicio(String natalicio) {
		this.natalicio = natalicio;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
}