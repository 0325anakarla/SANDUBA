package Console;

import Financeiro.CarteiraDaEmpresa;
import Financeiro.CarteiraDoCliente;
import Pessoa.Adm;
import jogo.Jogo;

public class VisualizacaoMenu {
	
	/*public void telaMenuMcCliente() {
		   System.out.println("\n--- MINHA CONTA(Cliente) ---");
	        System.out.println("1. Ver informações pessoais");
	        System.out.println("2. Acessar carteira digital");
	        System.out.println("3. Ver meus jogos");
	        System.out.println("4. Ver lista de desejos");
	        System.out.println("5. Ver histórico de pedidos");
	        System.out.println("6. Voltar para biblioteca");
	        System.out.print("Escolha uma opção: ");
	}*/
	
	public void telaMenuMcCliente() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║         👤 MINHA CONTA (CLIENTE)      ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println();
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] 🧑‍💻 Ver informações pessoais");
		System.out.println("  [2] 💳 Acessar carteira digital");
		System.out.println("  [3] 🎮 Ver meus jogos");
		System.out.println("  [4] 💖 Ver lista de desejos");
		System.out.println("  [5] 📜 Ver histórico de pedidos");
		System.out.println("  [6] 🔙 Voltar para biblioteca");
		System.out.print("\nDigite a opção desejada: ");
	}

	/*public void telaMenuCdCliente(CarteiraDoCliente cdC) {
		System.out.println("\n--- CARTEIRA DIGITAL ---");
        System.out.println("Saldo: "+cdC.getSaldo());
        System.out.println("CashBack: "+cdC.getCashback());
        System.out.println("1. Depositar");
        System.out.println("2. Cartao cadastrados");
        System.out.println("3. Voltar para minha conta");
        System.out.print("Escolha uma opção: ");
	}*/
	
	public void telaMenuCdCliente(CarteiraDoCliente cdC) {
		System.out.println("\n╔══════════════════════════════╗");
		System.out.println("║      💳 CARTEIRA DIGITAL       ║");
		System.out.println("╚══════════════════════════════╝");
		System.out.printf("Saldo disponível: R$ %.2f%n", cdC.getSaldo());
		System.out.printf("Cashback acumulado: R$ %.2f%n", cdC.getCashback());
		System.out.println();
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] ➕ Depositar");
		System.out.println("  [2] 💳 Cartões cadastrados");
		System.out.println("  [3] 🔙 Voltar para minha conta");
		System.out.print("\nDigite a opção desejada: ");
	}

	/*public void telaMenuMcEmpresa() {
		 System.out.println("\n--- MINHA CONTA(Empresa) ---");
	        System.out.println("1. Ver informações pessoais");
	        System.out.println("2. Acessar carteira digital");
	        System.out.println("3. Ver meus jogos cadastrados");
	        System.out.println("4. Cadastrar jogos");
	        System.out.println("5. Resumo de vendas");
	        System.out.println("6. Sair");
	        System.out.print("Escolha uma opção: ");
	}*/
	
	public void telaMenuMcEmpresa() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║       🏢 MINHA CONTA (EMPRESA)        ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println();
		System.out.println("  [1] 👤 Ver informações pessoais");
		System.out.println("  [2] 💼 Acessar carteira digital");
		System.out.println("  [3] 🎮 Ver meus jogos cadastrados");
		System.out.println("  [4] ➕ Cadastrar jogos");
		System.out.println("  [5] 📊 Resumo de vendas");
		System.out.println("  [6] ❌ Sair");
		System.out.print("\nDigite a opção desejada: ");
	}

	/*public void telaMenuCdEmpresa(CarteiraDaEmpresa cdE) {
		System.out.println("\n--- CARTEIRA DIGITAL ---");
        System.out.println("Saldo: "+cdE.getSaldo());
        System.out.println("1. Sacar");
        System.out.println("2. Dados Bancarios");
        System.out.println("3. Voltar para minha conta");
        System.out.print("Escolha uma opção: ");
	}*/
	
	public void telaMenuCdEmpresa(CarteiraDaEmpresa cdE) {
		System.out.println("\n╔══════════════════════════════╗");
		System.out.println("║      💼 CARTEIRA DIGITAL        ║");
		System.out.println("╚══════════════════════════════╝");
		System.out.printf("Saldo disponível: R$ %.2f%n", cdE.getSaldo());
		System.out.println();
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] 💸 Sacar");
		System.out.println("  [2] 🏦 Dados Bancários");
		System.out.println("  [3] 🔙 Voltar para minha conta");
		System.out.print("\nDigite a opção desejada: ");
	}

	
	public void telaJogosCadastrados() {{
			System.out.println("\n╔═══════════════════════════════╗");
			System.out.println("║       🎮 JOGOS CADASTRADOS       ║");
			System.out.println("╚═══════════════════════════════╝");
			System.out.println();
			System.out.println("O que você deseja fazer?");
			System.out.println("  [1] ✏️  Alterar dados do jogo");
			System.out.println("  [2] 🗑️  Remover jogo");
			System.out.println("  [3] 🔙 Voltar para minha conta");
			System.out.print("\nDigite sua opção: ");
	}
}
	
	public void telaMenuMcAdm() {
		System.out.println("\n╔════════════════════════════════════════╗");
	    System.out.println("║          🛠️ MENU ADMINISTRATIVO          ║");
	    System.out.println("╚════════════════════════════════════════╝");
	    System.out.println();
	    System.out.println("Selecione uma opção:");
	    System.out.println();
	    System.out.println("  [1] 🧑‍ Gerenciar Cliente");
	    System.out.println("  [2] 🏦 Gerenciar Empresas");
	    System.out.println("  [3] 🎮 Gerenciar Jogos");
	    System.out.println("  [4] 💰 Ver saldo do SANDUBA");
	    System.out.println("  [5] ❌ Sair");
	    System.out.print("\nDigite a opção desejada: ");

	}
	
	public void telaAlterarJogos(Jogo jogo) {
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.printf ("║  ✏️  ALTERAR DADOS DO JOGO: %-15s ║\n", jogo.getTitulo());
		System.out.println("╚════════════════════════════════════════╝");
		System.out.println();
		System.out.println("Qual das opções deseja alterar?");
		System.out.println("  [1] 📝 Título");
		System.out.println("  [2] 💰 Preço");
		System.out.println("  [3] 🧾 Descrição");
		System.out.println("  [4] 🗂️ Categorias");
		System.out.println("  [5] 🚸 Classificação Etária");
		System.out.println("  [6] 🗣️ Idiomas");
		System.out.println("  [7] 🕹️ Plataformas Disponíveis");
		System.out.println("  [8] 📅 Data de Lançamento");
		System.out.print("\nDigite a opção desejada: ");
	}
	
	public void telaAdmGerenciarCliente(Adm adm) {
		System.out.println("\n╔═════════════════════════════════════════╗");
		System.out.println("║         👤 GERÊNCIA DE CLIENTES         ║");
		System.out.println("╚═════════════════════════════════════════╝");
		System.out.println();
		System.out.println(adm.getNome()+" você deseja:");
		System.out.println("  [1] 👤 Ver lista de Clientes cadatrados.");
		System.out.println("  [2] 👤 Informações detalhadas. ");
		System.out.println("  [3] 👤 Aterar dados de um Clientes");
		System.out.println("  [4] 👤 Remover uma conta.");
		System.out.println("  [5] 👤 Buscar um Cliente.");
		System.out.println("  [6] 🔙 Voltar para o menu . ");
		
		System.out.println("Escolha uma opção:");
		
	}
	
	public void telaAdmGerenciarEmpresa(Adm adm) {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║         🏦 GERÊNCIA DE EMPRESAS        ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println();
		System.out.println(adm.getNome()+" oque você deseja:");
		System.out.println("  [1] 🏦 Ver lista de Empresa cadatrados.");
		System.out.println("  [2] 🏦 Informações detalhadas. ");
		System.out.println("  [3] 🏦 Aterar dados de uma Empresa");
		System.out.println("  [4] 🏦 Remover uma conta.");
		System.out.println("  [5] 🏦 Buscar uma Empresa.");
		System.out.println("  [6] 🔙 Voltar para o menu. ");
		
		System.out.println("Escolha uma opção:");
	}
	
	public void telaAdmGerenciarJogo(Adm adm) {
		System.out.println("\n╔════════════════════════════════════╗");
		System.out.println("║         🎮 GERÊNCIA DE JOGOS         ║");
		System.out.println("╚═════════════════════════════════════╝");
		System.out.println();
		System.out.println(adm.getNome()+" você deseja:");
		System.out.println("  [1] 🎮 Lista de Jogos Cadatrados.");
		System.out.println("  [2] 🎮 Cadastrar novo Jogo.");
		System.out.println("  [3] 🎮 Alterar dados de um jogo.");
		System.out.println("  [4] 🎮 Deletar jogo.");
		System.out.println("  [5] 🎮 Informações detalhada.");
		System.out.println("  [6] 🎮 Aplicar desconto.");
		System.out.println("  [7] 🎮 Buscar Jogos por categoria.");
		
		System.out.println("  [8] 📊 Resumo de vendas");
		
		System.out.println("  [9] 🔙 Voltar para o menu. ");
		
		System.out.println("Escolha uma opção:");
	}
	
	public void telaInfJogos() {
		System.out.println("\n╔══════════════════════════════════╗");
		System.out.println("║         🎮 DADOS DOS JOGOS         ║");
		System.out.println("╚═══════════════════════════════════╝");
		System.out.println();
	}
	
	public void telaSaldoSanduba() {
		System.out.println("\n╔════════════════════════════════════╗");
		System.out.println("║         💰 SALDO DO SANDUBA         ║");
		System.out.println("╚═══════════════════════════════════╝");
		System.out.println();
	}
	
	public void telaResumoVendEmpresa() {
		System.out.println("\n╔════════════════════════════════════╗");
		System.out.println("║         💰 RESUMO DE VENDAS         ║");
		System.out.println("╚═══════════════════════════════════╝");
		System.out.println();
	}

	
}
