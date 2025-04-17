package projetoSanduba;

//eh recomendado que seja abstrata
public class Usuarios implements Perfil {
	private String nome;
	private String email;
	private String senha;
	
	public Usuarios(String nome, String email, String senha){
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}