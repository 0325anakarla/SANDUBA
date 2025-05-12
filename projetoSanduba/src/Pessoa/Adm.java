package Pessoa;

import java.time.LocalDate;

import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeJogos;
import jogo.Jogo;

//import java.util.ArrayList;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;



public class Adm extends Usuarios{
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
	RepositorioUsuarioArrayList listUsuario = new RepositorioUsuarioArrayList();
	ControleDeJogos cj;
	
	LocalDate hoje = LocalDate.now();
	int anoHoje = LocalDate.now().getYear();
	
	
	//para ter certeza que so existe um adm
	private static Adm instanciaUnica;
	
    
    private Adm(String nome, String email, String senha) {
        super(nome, email, senha); 
    }

   
    public static Adm getInstancia(String nome, String email, String senha) {
        if (instanciaUnica == null) {
            instanciaUnica = new Adm(nome, email, senha);
        }
        return instanciaUnica;
    }

	
	
	public void AplicarDesconto(Jogo jogo, double desconto) {
		try {
		jogo.Desconto(desconto);
		System.out.println("Desconto aplicado com sucesso.");
				
	}catch(DadoInvalidoException e) {
		System.out.println("Erro: "+ e.getMessage());
		jogo.setDescontoApli(false);
		
	}
}
	
	public void VoltarPreço(Jogo jogo) throws DadoInvalidoException {
		jogo.VoltaPreco();
		jogo.setDescontoApli(false);
		
	}
	
	public void descontoPorAno(int ano, double desconto) throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		int diferencaAnos = anoHoje - ano;
		for(Usuarios empresa: listUsuario.getTipo(Empresa.class)){
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
		for(Usuarios empresas: listUsuario.getTipo(Empresa.class)) {
			Empresa empresa = (Empresa) empresas;
			System.out.println("🏢 "+empresa.getRazaoSocial()+" /n");
		}
	}
	
	public void clientesCadastrados() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios cliente: listUsuario.getTipo(Cliente.class)) {
			System.out.println("👤 "+cliente.getNome()+" /n");
		}
	}
	
	public void jogoPorEmpresa() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuario.getTipo(Empresa.class)) {
			System.out.println("🏢 Empresa "+empresas.getNome()+". /n");
			cj.ListJogosEmpresa((Empresa)empresas);
			System.out.println();
			
		}
	}
	
	public void informacoesTodosClientes() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios clientes: listUsuario.getTipo(Cliente.class)) {
//			tranformar o ciente do tipo usario em do tipo cliente
			Cliente cliente = (Cliente) clientes; 
			System.out.println(cliente.mostrarDetalhesUsuario());
		}
	}
	
	public void informacoesTodasEmpresas() throws DadoInvalidoException, DadoDuplicadoException {
		for(Usuarios empresas: listUsuario.getTipo(Empresa.class)) {
//			tranformar o empresa do tipo usario em do tipo Empresa
			Empresa empresa = (Empresa) empresas;
			System.out.println(empresa.mostrarDetalhesUsuario());
		}
	}
	
	
	


	@Override
	public String mostrarDetalhesUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}