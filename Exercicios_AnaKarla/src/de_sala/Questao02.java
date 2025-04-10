package de_sala;

import java.util.Scanner;

public class Questao02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o tempo gasto? ");
		float tempoGasto=sc.nextFloat();
		System.out.println("Qual a velocidade média? ");
		float velocidadeMedia=sc.nextFloat();
		float distanciaPercorrida= tempoGasto*velocidadeMedia; 
		float gasolinaGasta= distanciaPercorrida/12;
		System.out.println("Distancia Percorrida foi: "+distanciaPercorrida);
		System.out.println("Gasolina Gasta foi: "+gasolinaGasta);
	}
}
