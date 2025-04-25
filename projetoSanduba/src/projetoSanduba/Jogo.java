package projetoSanduba;

import java.util.Arrays;

public class Jogo {
	private String titulo;
	private double preco;
	private String descricao;
	private CategoriasJogos[] categoriasValidas;
	private int classEtaria;
	private String idiomas;
	private String plataDisp;
	private String modAtivacao;

	public Jogo(String titulo, double preco, String descricao, String[] categoriasInv, int classEtaria, String idiomas,
				String plataDisp, String modAtivacao) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.descricao = descricao;
		String[] categoriasVal = CategoriasJogos.converteString(categoriasInv);
		// pega o string escrito e chama o metodo do enum para converter
		this.categoriasValidas = Arrays.stream(categoriasVal)
				.map(CategoriasJogos::valueOf)
				.toArray(CategoriasJogos[]::new);
		// aqui ele esta armazenando cada String do categoriasVal dentro do categoriasValidas
		this.classEtaria = classEtaria;
		this.idiomas = idiomas;
		this.plataDisp = plataDisp;
		this.modAtivacao = modAtivacao;
	}

	//criando um construtor apenas para teste
	public Jogo(String titulo, String[] categoriasInv){
		this.titulo = titulo;
		String[] categoriasVal = CategoriasJogos.converteString(categoriasInv);
		this.categoriasValidas = Arrays.stream(categoriasVal)
				.map(CategoriasJogos::valueOf)
				.toArray(CategoriasJogos[]::new);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*public String getCategorias() {
		return categorias;
	}
	a gente não vai usar esses get e set aqui
	(lembrar de retirar isso depois)
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}*/

	public int getClassEtaria() {
		return classEtaria;
	}

	public void setClassEtaria(int classEtaria) {
		this.classEtaria = classEtaria;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getPlataDisp() {
		return plataDisp;
	}

	public void setPlataDisp(String plataDisp) {
		this.plataDisp = plataDisp;
	}

	public String getModAtivacao() {
		return modAtivacao;
	}

	public void setModAtivacao(String modAtivacao) {
		this.modAtivacao = modAtivacao;
	}

	public void mostrarDados() {
		System.out.println("Titulo: "+titulo);
		System.out.println("Preço: "+preco);
		System.out.println("Descrição: "+descricao);
		System.out.println("Categorias: ");
		System.out.println(Arrays.toString(categoriasValidas));
		System.out.println("Classificação Etaria: "+classEtaria);
		System.out.println("Idiomas Disponiveis: "+idiomas);
		System.out.println("Plataformas: "+plataDisp);
		System.out.println("Modo de ativação: "+modAtivacao);
	}

	// criando outro mostrarDados so pra teste
	public void mostrarDadosCat(){
		System.out.println("Títutlo: "+titulo);
		System.out.println("Categorias: ");
		System.out.printf(Arrays.toString(categoriasValidas));
	}

	public boolean aplicaDescontoDe(double desconto) {
		if (desconto > 0) {
			preco = preco - preco * desconto;
			return true;
		} else {
			return false;
		}
	}
}
