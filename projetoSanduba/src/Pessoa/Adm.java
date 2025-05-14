package Pessoa;

import java.time.LocalDate;

import Console.VisualizacaoMenu;
import Financeiro.RegistroDeCompras;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeJogos;
import jogo.Jogo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.ArrayList;
//
//import java.util.Comparator;
//import java.util.List;
import java.util.Scanner;

import Console.VisualizacaoMenu;



public class Adm extends Usuarios{
	Scanner sc = new Scanner(System.in);
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
	RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList(sc);
	VisualizacaoMenu visualizacaoMenu;
	ControleDeJogos controleJogos = new ControleDeJogos(sc, visualizacaoMenu, listJogos);
	
	LocalDate hoje = LocalDate.now();
	int anoHoje = LocalDate.now().getYear();
	
	
	//para ter certeza que so existe um adm
	private static Adm instanciaUnica;
	
    
    private Adm(String nome, String email, String senha) {
        super(nome, email, senha);
       
        
       
    }

   
    public static Adm getInstancia(String nome, String email, String senha, RepositorioUsuarioArrayList listUsuarios1 ) {
        if (instanciaUnica == null) {
            instanciaUnica = new Adm(nome, email, senha);
            try {
				listUsuarios1.add(instanciaUnica);
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public void empresasCadastradas() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
			Empresa empresa = (Empresa) empresas;
			System.out.println("🏢 "+empresa.getRazaoSocial()+" /n");
		}
	}
	
	public void clientesCadastrados() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios cliente: listUsuarios.getTipo(Cliente.class)) {
			System.out.println("👤 "+cliente.getNome()+" /n");
		}
	}
	
	public void jogoPorEmpresa() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuarios.getTipo(Empresa.class)) {
			System.out.println("🏢 Empresa "+empresas.getNome()+". /n");
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
	
	public void infoTodosJogos() {
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
	
	//chat mandou fazer um coisinha
	public String resumoVendasPorEmpresa(List<RegistroDeCompras> registros) {
		
	    Map<Empresa, Double> faturamentoEmpresa = new HashMap<>();
	    Map<Empresa, Integer> quantidadeVendidaPorEmpresa = new HashMap<>();

	    for (RegistroDeCompras registro : registros) {
	        for (Map.Entry<Jogo, Double> entrada : registro.getJogos().entrySet()) {
	            Jogo jogo = entrada.getKey();
	            Double preco = entrada.getValue();
	            Empresa empresa = jogo.getEmpresa(); 

	            faturamentoEmpresa.put(
	                empresa,
	                faturamentoEmpresa.getOrDefault(empresa, 0.0) + preco
	            );

	            // Soma quantidade
	            quantidadeVendidaPorEmpresa.put(
	                empresa,
	                quantidadeVendidaPorEmpresa.getOrDefault(empresa, 0) + 1
	            );
	        }
	    }

	    StringBuilder resumo = new StringBuilder();
	    for (Empresa empresa : faturamentoEmpresa.keySet()) {
	        double total = faturamentoEmpresa.get(empresa);
	        int quantidade = quantidadeVendidaPorEmpresa.get(empresa);

	        resumo.append("Empresa: ").append(empresa.getRazaoSocial()).append("\n");
	        resumo.append("Jogos vendidos: ").append(quantidade).append("\n");
	        resumo.append(String.format("Faturamento: R$ %.2f\n", total));
	        resumo.append("------------------------------\n");
	    }

	    return resumo.toString();
	} 
}