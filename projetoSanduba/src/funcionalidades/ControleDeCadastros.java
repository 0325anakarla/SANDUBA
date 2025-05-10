package funcionalidades;

import java.util.Scanner;

import Pessoa.Cliente;
import Repositorio.RepositorioUsuarioArrayList;

public class ControleDeCadastros {
	RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList();
	//Scanner
	Scanner sc = new Scanner(System.in);
	
	public void CadastrarClientes() {
		System.out.println("Cadastro de cliente\nPreencha todos os campos");
		
		boolean continuarCadastro =true;
		
		while(continuarCadastro) {
			
			boolean dadosValidos = false;
			
			Cliente cliente = new Cliente(null, null, null, null, null);
		
			do {
				try {
					System.out.println("adicione as infos");
					
					System.out.print("Nome: ");
					cliente.setNome(sc.nextLine());
					
				}
				catch{
					
				}
			}while(!dadosValidos);
		}
		
		
	}
	
	
	public void CadastrarEmpresa() {
		
	}
	
	
}
