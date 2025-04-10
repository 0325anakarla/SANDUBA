package de_sala;

import java.util.Scanner;

public class Questao04 {

	public static void main(String[] args) {
		System.out.println("Insira o número: ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num<0||num>80) {
			System.out.println("Erro, digite um numero entre 0 e 80");
			num= sc.nextInt();
			
		}
	System.out.println("O sucessor de "+num + " é: "+(num +1)%81);
	}	

}
