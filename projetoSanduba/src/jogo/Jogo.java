package jogo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

import java.util.ArrayList;
import Pessoa.Empresa;
import TratamentoDeErro.DadoInvalidoException;

public class Jogo {
	private String titulo;
	private double preco;
	private String descricao;
	private ArrayList<CategoriasJogos> categoriasValidas;
	private int classEtaria;
	private String idiomas;
	private String plataDisp;
	private String modAtivacao;
	private Empresa empresa;
	private LocalDate dataDeLancamento;
	private double precoModificador;
	LocalDate hoje = LocalDate.now();

	public Jogo(String titulo, double preco, String descricao, ArrayList<String> categoriasInv, int classEtaria, String idiomas,
				String plataDisp, String modAtivacao, Empresa empresa, LocalDate dataDeLancamento) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.descricao = descricao;

		ArrayList<String> categoriasVal = CategoriasJogos.converteArrayListString(categoriasInv); // convertendo de invalido para valido e depois armazenando
		this.categoriasValidas = new ArrayList<CategoriasJogos>(categoriasVal.size());
		for(int i = 0; i < categoriasVal.size(); i++){ // aqui ele esta armazenando cada String do categoriasVal dentro do categoriasValidas
			this.categoriasValidas.add(i, CategoriasJogos.valueOf(categoriasVal.get(i)));
		}

		this.classEtaria = classEtaria;
		this.idiomas = idiomas;
		this.plataDisp = plataDisp;
		this.modAtivacao = modAtivacao;
		this.empresa = empresa;
		this.dataDeLancamento = dataDeLancamento;
		this.precoModificador=preco;
	}

	//criando um construtor apenas para teste
	public Jogo(String titulo, ArrayList<String> categoriasInv){
		this.titulo = titulo;

		ArrayList<String> categoriasVal = CategoriasJogos.converteArrayListString(categoriasInv);
		this.categoriasValidas = new ArrayList<CategoriasJogos>(categoriasVal.size());
		for(int i = 0; i < categoriasVal.size(); i++){ // aqui ele esta armazenando cada String do categoriasVal dentro do categoriasValidas
			this.categoriasValidas.add(i, CategoriasJogos.valueOf(categoriasVal.get(i)));
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws DadoInvalidoException {
		if(titulo == null || titulo.isEmpty()) {
			throw new DadoInvalidoException("Título não pode ser vazio.");
		}
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) throws DadoInvalidoException {
		if(preco <= 0) {
			throw new DadoInvalidoException("Preço não pode ser negativo ou zerado.");
		}
		this.preco = preco;
	}

	public String getDescricao () {
		return descricao;
	}

	public void setDescricao(String descricao) throws DadoInvalidoException {
		if(descricao.length() > 200) {
			throw new DadoInvalidoException("Descrição muito longa, resuma a descrição em menos caracteres.");
		}


		if(descricao == null || descricao.isEmpty()) {
			throw new DadoInvalidoException("Descrição não pode ser vazia.");
		}

		this.descricao = descricao;
	}

	public int getClassEtaria() {
		return classEtaria;
	}

	public void setClassEtaria(int classEtaria) throws DadoInvalidoException {
		if(classEtaria < 0) {
			throw new DadoInvalidoException("Não existe essa Classificação Etaria.");
		}

		this.classEtaria = classEtaria;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) throws DadoInvalidoException {
		this.idiomas = idiomas;
	}

	public String getPlataDisp() {
		return plataDisp;
	}

	public void setPlataDisp(String plataDisp) throws DadoInvalidoException{
		this.plataDisp = plataDisp;
	}

	public String getModAtivacao() {
		return modAtivacao;
	}

	public void setModAtivacao(String modAtivacao) throws DadoInvalidoException {
		this.modAtivacao = modAtivacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) throws DadoInvalidoException {
		this.empresa = empresa;
	}

	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}

	public String getResumo() {
		return titulo+" ("+empresa.getNome()+")";
	}
	
	public double getPrecoModificador() {
		return precoModificador;
	}

	/*public void mostrarDados() {
		System.out.println("Titulo: "+titulo);
		System.out.println("Preço: "+preco);
		System.out.println("Descrição: "+descricao);
		System.out.println("Categorias: ");
		for(CategoriasJogos categorias : categoriasValidas){
			System.out.println(categorias.getCategoria());
		}
		System.out.println("Classificação Etaria: "+classEtaria);
		System.out.println("Idiomas Disponiveis: "+idiomas);
		System.out.println("Plataformas: "+plataDisp);
		System.out.println("Modo de ativação: "+modAtivacao);
		System.out.println("");
	}*/
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("🎮 Título: ").append(titulo).append("\n");
	    sb.append("💲 Preço: R$").append(String.format("%.2f", preco)).append("\n");
	    sb.append("📝 Descrição: ").append(descricao).append("\n");

	    sb.append("🏷 Categorias: ");
	    if (categoriasValidas.isEmpty()) {
	        sb.append("Nenhuma categoria cadastrada");
	    } else {
	        for (CategoriasJogos categoria : categoriasValidas) {
	            sb.append(categoria.getCategoria()).append(" | ");
	        }
	        // tira o último " | "
	        sb.setLength(sb.length() - 3);
	    }
	    sb.append("\n");

	    sb.append("🔞 Classificação Etária: ").append(classEtaria).append("+\n");
	    sb.append("🌐 Idiomas Disponíveis: ").append(idiomas).append("\n");
	    sb.append("🖥 Plataformas: ").append(plataDisp).append("\n");
	    sb.append("🔑 Modo de Ativação: ").append(modAtivacao).append("\n");

	    // Adicionando Empresa
	    sb.append("🏢 Empresa: ").append(empresa).append("\n");

	    // Adicionando Data de Lançamento
	    sb.append("📅 Data de Lançamento: ").append(dataDeLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

	    return sb.toString();
	}



	// criando outro mostrarDados so pra teste
	public void mostrarDadosCat(){
		System.out.println("Títutlo: "+titulo);
		System.out.println("Categorias: ");
		for(CategoriasJogos categorias : categoriasValidas){
			System.out.println(categorias.getCategoria());
		}
		System.out.println("");
	}
	
	 public void Desconto(double desconto ) throws DadoInvalidoException {
		 if(desconto <=0) {
				throw new DadoInvalidoException("Desconto não pode ser negativo ou zerado");
			}
		 setPreco( getPrecoModificador()-(getPrecoModificador()* desconto));
	}

	public boolean aplicaDescontoDe(double desconto) {
		if (desconto > 0) {
			preco = preco - preco * desconto;
			return true;
		} else {
			return false;
		}
	}
	
	public void VoltaPreco() throws DadoInvalidoException {
		setPreco(getPrecoModificador());
	}
	
	public int verAnosPassados() {
		return  Period.between(this.dataDeLancamento, hoje).getYears();
	}
}
