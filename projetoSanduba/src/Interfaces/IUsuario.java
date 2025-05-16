package Interfaces;

public interface IUsuario {

	void exibirInformacaoPublica();

	void exibirInformacaoPrivada();

	String alterarSenha(String senha);

	String alterarEmail(String email);

	void seusJogos();

	void excluirConta();

}
