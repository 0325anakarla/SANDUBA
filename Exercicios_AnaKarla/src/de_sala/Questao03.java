package de_sala;

import java.util.Scanner;

public class Questao03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Insira o Número: ");
		int cdu=sc.nextInt();
		int u=cdu%10;
		int d=(cdu%100)/10;
		int c=cdu/100;
		int udc=c+(10*d)+(100*u);
		System.out.println("O resultado é: "+udc);
		
	}
}