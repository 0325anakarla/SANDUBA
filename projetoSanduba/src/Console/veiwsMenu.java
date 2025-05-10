package Console;

import projetoSanduba.CarteiraDaEmpresa;
import projetoSanduba.CarteiraDoCliente;

public class veiwsMenu {
	
	public void telaMenuMcCliente() {
		   System.out.println("\n--- MINHA CONTA(Cliente) ---");
	        System.out.println("1. Ver informações pessoais");
	        System.out.println("2. Acessar carteira digital");
	        System.out.println("3. Ver meus jogos");
	        System.out.println("4. Ver lista de desejos");
	        System.out.println("5. Ver histórico de pedidos");
	        System.out.println("6. Voltar para biblioteca");
	        System.out.print("Escolha uma opção: ");
	}
	
	public void telaMenuCdCliente(CarteiraDoCliente cdC) {
		System.out.println("\n--- CARTEIRA DIGITAL ---");
        System.out.println("Saldo: "+cdC.getSaldo());
        System.out.println("CashBack: "+cdC.getCashback());
        System.out.println("1. Depositar");
        System.out.println("2. Cartao cadastrados");
        System.out.println("3. Voltar para minha conta");
        System.out.print("Escolha uma opção: ");
	}
	
	public void telaMenuMcEmpresa() {
		 System.out.println("\n--- MINHA CONTA(Empresa) ---");
	        System.out.println("1. Ver informações pessoais");
	        System.out.println("2. Acessar carteira digital");
	        System.out.println("3. Ver meus jogos cadastrados");
	        System.out.println("4. Cadastrar jogos");
	        System.out.println("5. Resumo de vendas");
	        System.out.println("6. Sair");
	        System.out.print("Escolha uma opção: ");
	}
	
	public void telaMenuCdEmpresa(CarteiraDaEmpresa cdE) {
		System.out.println("\n--- CARTEIRA DIGITAL ---");
        System.out.println("Saldo: "+cdE.getSaldo());
        System.out.println("1. Sacar");
        System.out.println("2. Dados Bancarios");
        System.out.println("3. Voltar para minha conta");
        System.out.print("Escolha uma opção: ");
	}
	
}
