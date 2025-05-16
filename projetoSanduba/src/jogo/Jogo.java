package jogo;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import Pessoa.Empresa;
import TratamentoDeErro.DadoInvalidoException;

public class Jogo {
	private String titulo;
	private double preco;
	private String descricao;
	private ArrayList<CategoriasJogos> categoriasValidas;
	private ArrayList<Idiomas> idiomasValidos;
	private ArrayList<PlataformasDisponiveis> platValidas;
	private ClassificacaoIndicativa classIndicativa;
	private String modAtivacao;
	private Empresa empresa;
	private LocalDate dataDeLancamento;
	private double precoModificador;
	LocalDate hoje = LocalDate.now();

	private boolean descontoApli = false;

	public Jogo(String titulo, double preco, String descricao, ArrayList<CategoriasJogos> categoriasValidas, ArrayList<Idiomas> idiomasValidos, ArrayList<PlataformasDisponiveis> platValidas, ClassificacaoIndicativa classIndicativa
			,Empresa empresa, LocalDate dataDeLancamento) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.descricao = descricao;
		this.categoriasValidas = categoriasValidas;
		this.idiomasValidos = idiomasValidos;
		this.platValidas = platValidas;
		this.classIndicativa = classIndicativa;
		this.modAtivacao = gerarStringSegura(20);
		this.empresa = empresa;
		this.dataDeLancamento = dataDeLancamento;
		this.precoModificador=preco;
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
//		if(descontoApli) {
//			precoDesconto();
//			
//		}
		return preco;
	}
	
	public void setDescontoApli(boolean descontoApli) {
		this.descontoApli = descontoApli;
	}
	
	public String precoDesconto() {
		 String precoOriginal = "\u001B[2mR$ " + getPrecoModificador() + "\u001B[0m"; // cinza (faint)
		    String precoDescontado = "\u001B[31mR$ " + getPreco() + "\u001B[0m"; // vermelho

		    return "\n  !Jogo com desconto! De ~~" + precoOriginal + "~~ para: " + precoDescontado;
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

	public String getModAtivacao() {
		return modAtivacao;
	}

	    public static String gerarStringSegura(int tamanho) {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder sb = new StringBuilder();
	        SecureRandom random = new SecureRandom();

	        for (int i = 0; i < tamanho; i++) {
	            int index = random.nextInt(caracteres.length());
	            sb.append(caracteres.charAt(index));
	        }

	        return sb.toString();
	    }

	public ArrayList<String> getCategoriasValidas() {
		ArrayList<String> nomesCategorias = new ArrayList<>();
		for (CategoriasJogos cat : categoriasValidas) {
			nomesCategorias.add(cat.getCategoria()); // pega a String do enum
		}
		return nomesCategorias;
	}

	public void setCategoriasValidas(ArrayList<CategoriasJogos> categoriasValidas) {
		this.categoriasValidas = categoriasValidas;
	}

	public ArrayList<String> getIdiomasValidos() {
		ArrayList<String> nomesIdiomas = new ArrayList<>();
		for (Idiomas idiomas : idiomasValidos) {
			nomesIdiomas.add(idiomas.getIdioma()); // pega a String do enum
		}
		return nomesIdiomas;
	}

	public void setIdiomas(ArrayList<Idiomas> idiomasValidos) {
		this.idiomasValidos = idiomasValidos;
	}

	public ArrayList<String> getPlaformasValidas() {
		ArrayList<String> nomesPlataformas = new ArrayList<>();
		for (PlataformasDisponiveis plat : platValidas) {
			nomesPlataformas.add(plat.getPlataforma()); // pega a String do enum
		}
		return nomesPlataformas;
	}

	public void setPlataformasValidas(ArrayList<PlataformasDisponiveis> platValidas) {
		this.platValidas = platValidas;
	}

	public String  getClassIndicativa() {
		return classIndicativa.getClassificacao();
	}
	
	public int classInd() {
		return classIndicativa.getIdadeMinima();
	}

	public void setClassIndicativa(ClassificacaoIndicativa classIndicativa) {
		this.classIndicativa = classIndicativa;
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

	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}

	public String getResumo() {
		return titulo+" ("+empresa.getNome()+")";
	}
	
	public double getPrecoModificador() {
		return precoModificador;
	}
	

	public boolean isDescontoApli() {
		return descontoApli;
	}

	public void mostrarDados() {
		System.out.println("Titulo: "+titulo);
		System.out.println("Preço: "+preco);
		System.out.println("Descrição: "+descricao);
		System.out.println("Categorias: ");
		for(CategoriasJogos categorias : categoriasValidas){
			System.out.println(categorias.getCategoria());
		}
		System.out.println("");
		System.out.println("Idiomas Disponíveis: ");
		for(Idiomas idiomas : idiomasValidos){
			System.out.println(idiomas.getIdioma());
		}
		System.out.println("");
		System.out.println("Plataformas disponíveis: ");
		for(PlataformasDisponiveis plataformas : platValidas){
			System.out.println(plataformas.getPlataforma());
		}
		System.out.println("");
		System.out.println("Classificação Etaria: "+classIndicativa.getClassificacao());
		System.out.println("");
		
		System.out.println("");
		System.out.println("Empresa: "+empresa.getRazaoSocial());
		System.out.println("");
	}
	
	 public void Desconto(double desconto ) throws DadoInvalidoException {
		 if(desconto <=0 || desconto >= 100) {
				throw new DadoInvalidoException("Desconto não pode ser negativo ou zerado");
			}


		 setPreco( getPrecoModificador()-(getPrecoModificador()* desconto/100));
		 descontoApli = true;
	}

	
	public void VoltaPreco() throws DadoInvalidoException {
		setPreco(getPrecoModificador());
		
	}
	
	public int verAnosPassados() {
		return  Period.between(this.dataDeLancamento, hoje).getYears();
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
