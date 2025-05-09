package Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class testeparacadastro {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//CadastroUsuario novoCadastro = new CadastroUsuario();
		
		//novoCadastro.cadastrarUsuarios();
		
		//novoCadastro.telalogin();
		
		
		// teste da data----------------------------------------
		LocalDate natalicio = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // tem que ser com MM maiusculo pois mm representa minutos MM meses
		
		while(natalicio == null) {
	        
	        try {
	        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
	        String entrada = scanner.nextLine();
	
	        natalicio = LocalDate.parse(entrada, formato);
			
	      
	        System.out.println("Você nasceu em: " + natalicio);
	        }
		        catch(Exception e){
		        	System.out.println("Formato da data ta invalida");	
		        }
		}
		scanner.close();
	//----------------------------------------------------------------------------------------------
}
}


