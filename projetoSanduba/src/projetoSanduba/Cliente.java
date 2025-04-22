package projetoSanduba;

public class Cliente extends Usuarios{
	private int cpf;
	private String natalicio; //data de nascimento
	private double cashback; //onde vai ser gerado a cada compra realizada com sucesso
	private CarteiraDoCliente carteiraDigital; //tem acesso ao dados bancários
	
	
	public Cliente(String nome, String email, String senha, int cpf, String natalicio, CarteiraDoCliente carteiraDigital) {
		super(nome, email, senha);
		this.setCpf(cpf);
		this.setNatalicio(natalicio);
		this.setCarteiraDigital(carteiraDigital);
	}
	
	public double getCashback() {
		return cashback;
	}
	
	public void gerarCashback() {
		cashback += 0.01;
	}
	
	public CarteiraDoCliente getCarteiraDigital() {
		return carteiraDigital;
	}
	
	public void setCarteiraDigital(CarteiraDoCliente carteiraDigital) {
		this.carteiraDigital = carteiraDigital;
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