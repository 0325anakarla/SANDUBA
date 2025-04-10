package de_sala;

import java.util.Scanner;

public class Questao06 {
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Qual o depósito a ser calculado?");
		float deposito=sc.nextFloat();
		
		float rendimento=(deposito*(5f/100));
		float valor_total=deposito+rendimento;
		 
		System.out.println("Seu rendimento foi de: "+rendimento+"; E o valor total foi: "+valor_total);
	}
}
