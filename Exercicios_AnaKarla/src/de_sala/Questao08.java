package de_sala;

import java.util.Scanner;

public class Questao08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int idade_maiorM = 0;
		int idade_menorM = 999;
		int idade_maiorH = 0;
		int idade_menorH = 999;
		
		for(int i = 1; i <= 2; i++) {
			System.out.println("Digite a idade da mulher "+i+": ");
			int idadeM = sc.nextInt();
			
			if(idadeM > idade_maiorM) idade_maiorM = idadeM;
			if(idadeM < idade_menorM) idade_menorM = idadeM;
		}
		
		for(int i = 1; i <= 2; i++) {
			System.out.println("Digite a idade do homem "+i+": ");
			int idadeH = sc.nextInt();
			
			if(idadeH > idade_maiorH) idade_maiorH = idadeH;
			if(idadeH < idade_menorH) idade_menorH = idadeH;
		}
		
		System.out.println("A soma de idades do homem mais velho com a mulher mais nova é: "+(idade_maiorH+idade_menorM));
		System.out.println("O produto de idades do homem mais novo com a mulher mais velha é: "+(idade_menorH*idade_maiorM));
	}
}
