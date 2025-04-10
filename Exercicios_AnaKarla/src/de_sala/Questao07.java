package de_sala;

import java.util.Scanner;

public class Questao07 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Quantas pessoas? ");
	int n=sc.nextInt();
	
	System.out.println("Digite altura numero 1: ");
	float alt=sc.nextFloat();
	
	float maior_altura = alt;
	float menor_altura = alt;
	
	for(int i = 1; i < n; i++) {
		System.out.println("Digite altura numero "+(i+1)+"(ou -1 para sair): ");
		float altu=sc.nextFloat();
		
		if(altu > maior_altura) {
			maior_altura = altu;
		}
		if((altu != -1)  && (altu < menor_altura)) {
			menor_altura = altu;
		}
		if(altu == -1) break;
	}
	
	System.out.println("A menor altura eh: "+menor_altura);
	System.out.println("A maior altura eh: "+maior_altura);
}
}

