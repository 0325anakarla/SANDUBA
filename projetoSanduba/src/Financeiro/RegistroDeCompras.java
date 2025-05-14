package Financeiro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jogo.Jogo;

public class RegistroDeCompras {
    private double gastoTotal;
    private LocalDate data;
    private Map<Jogo, Double> jogos;
    
    
    public RegistroDeCompras(double gastoTotal, LocalDate data, Map<Jogo, Double> jogos) {
        this.gastoTotal = gastoTotal;
        this.data = data;
        this.jogos = new HashMap<>();
        this.jogos = jogos;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Map<Jogo, Double> getJogos() {
        return jogos;
    }

    public void setJogos(Map<Jogo, Double> jogos) {
        this.jogos = jogos;
    }
    
    public void exibiJogos() {
    	for (Map.Entry<Jogo, Double> entrada : jogos.entrySet()) {
    		Jogo jogo = entrada.getKey();
    		double preco = entrada.getValue();
    		System.out.println(jogo.getResumo()+" R$ "+preco+"\n");
    	}
    }
    
    public String toString() {
		return  "-------------------------------------------------------------"+
				"\n  Gasto total: "+getGastoTotal()+
				"\n  Data da compra: "+getData()+
				"\n  Quantidade de jogos comprados: "+jogos.size()+
				"\n-------------------------------------------------------------";
	}
    
    
}
