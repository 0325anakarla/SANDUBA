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


public class Adm extends Usuarios{
	Scanner sc = new Scanner(System.in);
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
	RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList(sc);
	VisualizacaoMenu visualizacaoMenu;
	ControleDeJogos controleJogos = new ControleDeJogos(sc, visualizacaoMenu, listJogos);
	
	LocalDate hoje = LocalDate.now();
	int anoHoje = LocalDate.now().getYear();
	ResumoDeVendas resumo;
	private LocalDate dataDesconto; 
    private int duracaoDescontoDias;
	
	//para ter certeza que so existe um adm
	private static Adm instanciaUnica;
	
    
    private Adm(String nome, String email, String senha,RepositorioUsuarioArrayList listUsuarios) {
        super(nome, email, senha);
       
        
       
    }

    public static Adm getInstancia(String nome, String email, String senha, RepositorioUsuarioArrayList listUsuarios ) {
        if (instanciaUnica == null) {
            instanciaUnica = new Adm(nome, email, senha,listUsuarios);
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
				
	}catch(DadoInvalidoException e) {
		System.out.println("Erro: "+ e.getMessage());
		
	}
}
	
	public void VoltarPreço(Jogo jogo) throws DadoInvalidoException {
		jogo.VoltaPreco();
		jogo.setDescontoApli(false);
		
	}
	
	public void descontoPorAno(int ano, double desconto) throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		int diferencaAnos = anoHoje - ano;
		for(Usuarios empresa: listUsuarios.getTipo(Empresa.class)){
			for(Jogo jogo:  listJogos.procurarEmpresa((Empresa)empresa)) {
				if (jogo.verAnosPassados() >= diferencaAnos) {
					AplicarDesconto( jogo, desconto);
					System.out.println("🎮. "+jogo.getTitulo()+" lançado em "+jogo.getDataDeLancamento()+", sofreu "+desconto+"% de desconto. /n");
            
        }
		}
        }

	}

	@Override
	public String mostrarDetalhesUsuario() {
		
		return "Nome do Adm: "+getNome()+"/nEmail:"+getEmail()+"/nSenha: "+getSenha();
	}
	
	public void empresasCadastradas() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
			Empresa empresa = (Empresa) empresas;
			System.out.println("🏢 "+empresa.getRazaoSocial()+" /n");
		}
	}
	
	public void clientesCadastrados() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios cliente: listUsuarios.getTipo(Cliente.class)) {
			System.out.println("/n👤 "+cliente.getNome()+" /n");
		}
	}
	
	public void jogoPorEmpresa() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
			System.out.println("🏢 Empresa "+empresas.getNome()+". \n");
			controleJogos.ListJogosEmpresa((Empresa)empresas);
			System.out.println();
			
		}
	}
	
	public void informacoesTodosClientes() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios clientes: listUsuarios.getTipo(Cliente.class)) {
//			tranformar o ciente do tipo usario em do tipo cliente
			Cliente cliente = (Cliente) clientes; 
			System.out.println(cliente.mostrarDetalhesUsuario());
		}
	}
	
	public void informacoesTodasEmpresas() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			System.out.println(empresa.mostrarDetalhesUsuario());
		}
	}	
	
	public void infoTodosJogos() throws DadoNaoEncontradoException, DadoInvalidoException {
		visualizacaoMenu.telaInfJogos();
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			for(Jogo jogo : listJogos.procurarEmpresa( empresa)) {
				jogo.mostrarDados();
				System.out.println();
			}
		}
	}
	
//	

	public void resumoVendaJogos(RepositorioUsuarioArrayList listUsuarios) throws DadoInvalidoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			ResumoDeVendas.gerarResumoTotal(empresa.getVendasPorJogo());
		}
	}
	
//	public double getPrecoFinal() {
//        if (desconto > 0 && dataDesconto != null) {
//            LocalDate dataFinal = dataDesconto.plusDays(duracaoDescontoDias);
//            if (LocalDate.now().isAfter(dataFinal)) {
//                // Já passou o tempo, remove o desconto
//                desconto = 0;
//                return preco;
//            } else {
//                return preco * (1 - desconto / 100);
//            }
	
	public void descontoPorTempoLimt(int tipo, int tempo, double desconto, List<CategoriasJogos> categorias) throws DadoNaoEncontradoException, DadoInvalidoException {
		dataDesconto = LocalDate.now();
		if(tipo == 1) {
			duracaoDescontoDias = tempo;
		}
		else if (tipo == 2) {
			duracaoDescontoDias = 30*tempo;
		}
		
		LocalDate dataFinal = dataDesconto.plusDays(duracaoDescontoDias);
		
		
			
		for(Jogo jogo : listJogos.procurarPorCategorias(categorias)) {
					if ( LocalDate.now().isAfter(dataFinal))  {
						VoltarPreço( jogo);
					}else {
						AplicarDesconto( jogo, desconto);
						System.out.println("🎮. "+jogo.getTitulo()+", sofreu "+desconto+"% de desconto. Durante o tempo de "+ tempo + (tipo == 1 ? " dias./n" : " meses./n"));
					}
	        }
		}
	
			
	
}