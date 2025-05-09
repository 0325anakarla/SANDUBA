package Console;
import java.time.LocalDate;

import Pessoa.UsuarioArrayList;
import projetoSanduba.CarteiraDoCliente;

public class ControleUsuario {
	
	
	public static void RegistrarCliente(
			String nome,
			String email,
			String senha,
			int cpf,
			LocalDate natalicio,
			CarteiraDoCliente carteiraDigital) throws IllegalAccessException {
		
			//fazer as excessoes
		//isBlank string vazia contendo apenas espacos
		//isEmpty a string tem 0 caracteres
		//\\d significa um digito numerico (0-9) {11} exatamente 11 repeticoes
			if(nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome vazio");
			if(email == null || email.isBlank()) throw new IllegalArgumentException("Email vazio");
			if(senha == null || senha.isBlank()) throw new IllegalArgumentException("Senha vazia");
			if(cpf >= 10000000000L && cpf <= 99999999999L) throw new IllegalArgumentException("cpf invalido");
				
	}
	
}
