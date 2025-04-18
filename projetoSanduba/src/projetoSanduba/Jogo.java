package projetoSanduba;

import java.text.Normalizer;

public class Jogo {	
	private String titulo;
	private double preco;
	private String descricao;
	private CategoriasJogos categoria;
	private int classEtaria;
	private String idiomas;
	private String plataDisp;
	private String modAtivacao;
	
	public Jogo(String titulo, double preco, String descricao, String categoria, int classEtaria, String idiomas,
			String plataDisp, String modAtivacao) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.descricao = descricao;
		categoria = Normalizer.normalize(categoria, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		// Pega o string escrito e retira acentuação
		this.categoria = CategoriasJogos.valueOf(categoria.toUpperCase()); 
		// vai converter o String categoria em valor Enum da list e depois colocar a palavra toda em letras maiusculas
		// (no padrão da lista do Enum), assim as empresas vão poder escrever as categórias de várias formas e mesmo assim
		// será cadastrado igual e de forma padronizada
		this.classEtaria = classEtaria;
		this.idiomas = idiomas;
		this.plataDisp = plataDisp;
		this.modAtivacao = modAtivacao;
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
	
	/*public String getCategorias() { por causa do jeito que as categorias estão implementadas, a gente não vai usar get e set aqui
		return categorias;
	}
	
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
		System.out.println("Categorias: "+categoria.getCategoria());
		System.out.println("Classificação Etaria: "+classEtaria);
		System.out.println("Idiomas Disponiveis: "+idiomas);
		System.out.println("Plataformas: "+plataDisp);
		System.out.println("Modo de ativação: "+modAtivacao);
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
