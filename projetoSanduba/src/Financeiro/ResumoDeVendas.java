package Financeiro;

import java.util.Map;

import jogo.Jogo;

public class ResumoDeVendas {
	
	//espera receber um mapa contendo objetos-chaves do tipo Jogo
	//onde cada jogo contido neste mapa tem que pertencer a uma mesma empresa
	//para assim gerar o resumo de vendas por empresa
	public static void gerarResumoTotal(Map<Jogo, Venda> vendas) {
		 double totalVendas = 0;
		 int totalJogoVendidos = 0;
		 
		 System.out.println("Resumo de vendas total: ");
		 for (Venda venda : vendas.values()) {
			 gerarResumoIndividual(venda);
			 totalVendas += venda.getPrecoTotal();
			 totalJogoVendidos += venda.getQuantidadeVendida();
		 }
		 
		 System.out.println("\n Total arrecadado R$ "+totalVendas);
		 System.out.println("\n Total de jogos vendidos: "+totalJogoVendidos);
	}
	
	public static void gerarResumoIndividual(Venda venda) {
		System.out.println("Resumo de vendas do jogo: ");
		System.out.println(venda.getTituloDoJogo()+" - Quantidade: "+venda.getQuantidadeVendida()+" R$ "+venda.getPrecoTotal());
	}
}
