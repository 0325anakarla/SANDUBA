package Pessoa;

import java.time.LocalDate;

import Console.VisualizacaoMenu;
//import Financeiro.RegistroDeCompras;
import Financeiro.ResumoDeVendas;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeJogos;
import jogo.CategoriasJogos;
import jogo.Jogo;

import java.util.List;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ArrayList;
//
//import java.util.Comparator;
//import java.util.List;
import java.util.Scanner;

public class Adm extends Usuarios {
	Scanner sc = new Scanner(System.in);
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
	RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList(sc);
	VisualizacaoMenu visualizacaoMenu = new VisualizacaoMenu();
	ControleDeJogos controleJogos = new ControleDeJogos(sc, visualizacaoMenu, listJogos);

	LocalDate hoje = LocalDate.now();
	int anoHoje = LocalDate.now().getYear();
	ResumoDeVendas resumo;
//	private LocalDate dataDesconto; 
//    private int duracaoDescontoDias;

	// para ter certeza que so existe um adm
	private static Adm instanciaUnica;

	private Adm() {

	}

	private Adm(String nome, String email, String senha, RepositorioUsuarioArrayList listUsuarios) {
		super(nome, email, senha);
//        this.listJogos = listUsuarios;

	}

	public static Adm getInstancia(String nome, String email, String senha, RepositorioUsuarioArrayList listUsuarios) {
		if (instanciaUnica == null) {
			instanciaUnica = new Adm(nome, email, senha, listUsuarios);
			try {
				listUsuarios.add(instanciaUnica);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return instanciaUnica;

	}

	public void AplicarDesconto(Jogo jogo, double desconto) {
		try {
			jogo.Desconto(desconto);
			System.out.println("Desconto aplicado com sucesso.");

		} catch (DadoInvalidoException e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}

	public void VoltarPreço(Jogo jogo) throws DadoInvalidoException {
		jogo.VoltaPreco();
		jogo.setDescontoApli(false);

	}

	public void descontoPorAno(int ano, double desconto, RepositorioUsuarioArrayList listUsuarios,
			RepositorioJogoArrayList listJogos)
			throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		int diferencaAnos = anoHoje - ano;
		for (Usuarios empresa : listUsuarios.getTipo(Empresa.class)) {
			Empresa empresas = (Empresa) empresa;
			for (Jogo jogo : listJogos.procurarEmpresa(empresas)) {
				if (jogo.verAnosPassados() >= diferencaAnos) {
					AplicarDesconto(jogo, desconto);
					System.out.println("🎮. " + jogo.getTitulo() + " lançado em " + jogo.getDataDeLancamento()
							+ ", sofreu " + desconto + "% de desconto. \n");

				}
			}
		}

	}

	@Override
	public String mostrarDetalhesUsuario() {
		return "Nome do Adm: "+getNome()+"\nEmail:"+getEmail()+"\nSenha: "+getSenha();
	}

	public void empresasCadastradas(RepositorioUsuarioArrayList listUsuarios)
			throws DadoInvalidoException, DadoDuplicadoException {
		for (Usuarios empresas : listUsuarios.getTipo(Empresa.class)) {
			Empresa empresa = (Empresa) empresas;
			System.out.println("🏢 " + empresa.getRazaoSocial() + " /n");
		}
	}

	public void clientesCadastrados(RepositorioUsuarioArrayList listUsuarios)
			throws DadoInvalidoException, DadoDuplicadoException {
		for (Usuarios cliente : listUsuarios.getTipo(Cliente.class)) {
			System.out.println("\n👤 " + cliente.getNome() + " \n");
		}
	}

	public void jogoPorEmpresa(RepositorioUsuarioArrayList listUsuarios, RepositorioJogoArrayList listJogos2)
			throws DadoInvalidoException, DadoDuplicadoException {
		for (Usuarios usuario : listUsuarios.getTipo(Empresa.class)) {
			Empresa empresa = (Empresa) usuario;
			System.out.println("🏢 Empresa " + empresa.getRazaoSocial() + ". \n");
			System.out.println("---------------------------------------------");
			System.out.println("Jogos da Empresa:");
			for (Jogo jogo : listJogos2.procurarEmpresa(empresa)) {
				System.out.println("- " + jogo.getTitulo());
			}
			System.out.println("");
		}
	}

	public void informacoesTodosClientes(RepositorioUsuarioArrayList listUsuarios)
			throws DadoInvalidoException, DadoDuplicadoException {
		for (Usuarios clientes : listUsuarios.getTipo(Cliente.class)) {
//			tranformar o ciente do tipo usario em do tipo cliente
			Cliente cliente = (Cliente) clientes;
			System.out.println(cliente.mostrarDetalhesUsuario());
		}
	}

	public void informacoesTodasEmpresas(RepositorioUsuarioArrayList listUsuarios)
			throws DadoInvalidoException, DadoDuplicadoException {
		for (Usuarios empresas : listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			System.out.println(empresa.mostrarDetalhesUsuario());
		}
	}

	public void infoTodosJogos(RepositorioUsuarioArrayList listUsuarios, RepositorioJogoArrayList listJogos2)
			throws DadoNaoEncontradoException, DadoInvalidoException {
		visualizacaoMenu.telaInfJogos();
		for (Usuarios empresas : listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			for (Jogo jogo : listJogos.procurarEmpresa(empresa)) {
				jogo.mostrarDados();
				System.out.println();
			}
		}
	}

//	

	public void resumoVendaJogos(RepositorioUsuarioArrayList listUsuarios) throws DadoInvalidoException {
		for (Usuarios empresas : listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			System.out.println("Empresa: " + empresa.getRazaoSocial());
			ResumoDeVendas.gerarResumoTotal(empresa.getVendasPorJogo());
		}
	}

//	public void descontoPorTempoLimt(int tipo, int tempo, double desconto, List<CategoriasJogos> categorias) throws DadoNaoEncontradoException, DadoInvalidoException {
//		dataDesconto = LocalDate.now();
//		if(tipo == 1) {
//			duracaoDescontoDias = tempo;
//		}
//		else if (tipo == 2) {
//			duracaoDescontoDias = 30*tempo;
//		}
//		
//		LocalDate dataFinal = dataDesconto.plusDays(duracaoDescontoDias);
//		
//		
//			
//		for(Jogo jogo : listJogos.procurarPorCategorias(categorias)) {
//					if ( LocalDate.now().isAfter(dataFinal))  {
//						VoltarPreço( jogo);
//					}else {
//						AplicarDesconto( jogo, desconto);
//						System.out.println("🎮. "+jogo.getTitulo()+", sofreu "+desconto+"% de desconto. Durante o tempo de "+ tempo + (tipo == 1 ? " dias./n" : " meses./n"));
//					}
//	        }
//		}

}