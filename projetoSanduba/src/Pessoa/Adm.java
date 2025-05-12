package Pessoa;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import TratamentoDeErro.DadoInvalidoException;

//import java.util.ArrayList;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;

import jogo.Jogo;


public class Adm extends Usuarios{
	//Scanner dados = new Scanner(System.in);

	private Jogo jogo;
	
	//SimpleDateFormat dataDesconto= new SimpleDateFormat("dd/MM/yyyy");
	LocalDate hoje = LocalDate.now();
	
	
	
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
	
	
	public boolean AplicarDesconto(Jogo jogo, double desconto) {
		try {
		jogo.Desconto(desconto);
		System.out.println("Desconto aplicado com sucesso.");
		return true;
		
	}catch(DadoInvalidoException e) {
		System.out.println("Erro: "+ e.getMessage());
		return false;
		
	}
}
	
	
	
	
	public void VoltarPreço(Jogo jogo) throws DadoInvalidoException {
		jogo.VoltaPreco();
	}
	
	public void descontoPorAno(int ano, double desconto) {
		for(Jogo jogo: jogo) {
        if (jogo.verAnosPassados() >= ano) {
        	AplicarDesconto( jogo, desconto);
            
        } 
        }

	}

	@Override
	public String mostrarDetalhesUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}