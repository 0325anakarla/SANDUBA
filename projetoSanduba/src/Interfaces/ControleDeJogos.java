package Interfaces;

import projetoSanduba.Jogo;

public interface ControleDeJogos {
	
	void cadastrarJogos(String titulo, double preco, String descricao, String categorias, int classEtaria, String idiomas,
			String plataDisp, String modAtivacao); //adicionar
	
	void alterarDadosDoJogo(Jogo jogo); //alterar
	
	void excluirJogo(); //remover
	
	void pesquisarJogo(); //pesquisar

}
