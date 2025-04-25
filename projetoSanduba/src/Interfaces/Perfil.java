package Interfaces;

public interface Perfil {
	void exibirInformacaoPublica(); //nome de usuario
	void exibirInformacaoPrivada(); //detalhes da conta
	
	String alterarSenha(String senha); //alterar dados
	String alterarEmail(String email);
	
	void seusJogos(); //jogos cadastrados e jogos comprados
	
	void excluirConta(); //excluir conta
}
