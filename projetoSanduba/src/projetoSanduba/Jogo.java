package projetoSanduba;

public class Jogo {	
	private String titulo;
	private double preco;
	private String descricao;
	private String categorias;
	private int classEtaria;
	private String idiomas;
	private String plataDisp;
	private String modAtivacao;
	
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
	public String getCategorias() {
		return categorias;
	}
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
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
	
	public Jogo(String titulo, double preco, String descricao, String categorias, int classEtaria, String idiomas,
			String plataDisp, String modAtivacao) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.descricao = descricao;
		this.categorias = categorias;
		this.classEtaria = classEtaria;
		this.idiomas = idiomas;
		this.plataDisp = plataDisp;
		this.modAtivacao = modAtivacao;
	}
	
	public void mostrarDados() {
		System.out.println("Titulo: "+titulo);
		System.out.println("Preço: "+preco);
		System.out.println("Descrição: "+descricao);
		System.out.println("Categorias: "+categorias);
		System.out.println("Classificação Etaria: "+classEtaria);
		System.out.println("Idiomas Disponiveis: "+idiomas);
		System.out.println("Plataformas: "+plataDisp);
		System.out.println("Modo de ativação: "+modAtivacao);
	}
}
