package funcionalidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Console.VisualizacaoMenu;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class ControleDeJogos{
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();	
	
	VisualizacaoMenu menu = new VisualizacaoMenu();
	
	//final
	Scanner sc = new Scanner(System.in);
	
	// cadastrar Jogo
	public void CadastrarJogos(Empresa empresa) throws DadoInvalidoException {
		
		boolean continuarCadastro = true;
		
		while(continuarCadastro) {
			boolean dadosValidos = false;
			
			Jogo jogo = new Jogo(null, 0, null, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 0, null, null, null);
			
			do {
				try {
					System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
					System.out.println("║     🎮 CADASTRO DE JOGO - PREENCHA TODAS AS INFORMAÇÕES       ║");
					System.out.println("╚════════════════════════════════════════════════════════════════╝");

					System.out.println("📌 Adicione as informações obrigatórias:");
					
					System.out.print("📝 Título: ");
					jogo.setTitulo(sc.nextLine());

					System.out.print("💲 Preço: ");
					jogo.setPreco(sc.nextDouble());
					sc.nextLine();

					System.out.print("🗒️ Descrição: ");
					jogo.setDescricao(sc.nextLine());
					
					//a parte de categoria eu nao entendi como funciona vai ficar sem por enquanto
					
					System.out.print("🔞 Classificação etária: ");
					jogo.setClassEtaria(sc.nextInt());
					sc.nextLine();

					System.out.print("🗣️ Idiomas disponíveis: ");
					//jogo.setIdiomas(sc.nextLine());

					System.out.print("🕹️ Plataformas disponíveis: ");
					//jogo.setPlataDisp(sc.nextLine());

					dadosValidos = true;
					
				} catch(DadoInvalidoException e) {
					System.out.println("⚠️ Erro: " + e.getMessage());
				}
			}while(!dadosValidos);
			
			System.out.println("\n📥 Realmente deseja adicionar esse jogo?");
			System.out.println("1️⃣  Sim");
			System.out.println("2️⃣  Não");
			System.out.print("👉 Escolha a opção: ");
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
				case 1:
					try{
						listJogos.add(jogo);
						jogo.setEmpresa(empresa);
						empresa.atualizarJogos(jogo);
						System.out.println("✅ O jogo \"" + jogo.getTitulo() + "\" foi adicionado com sucesso!");
					
					} catch (DadoDuplicadoException e) {
						System.out.println("❌ Erro: " + e.getMessage());
			            System.out.println("🔁 Você deseja refazer o cadastro de jogo?");
			            System.out.println("1️⃣  Sim");
			            System.out.println("2️⃣  Não");
			            System.out.print("👉 Escolha a opção: ");
						int refazer = sc.nextInt();
						sc.nextLine();
						
						if(refazer == 2) { 
							continuarCadastro = false;
							System.out.println("🚫 Cadastro cancelado.");
						}
					}
				break;
				case 2: 
					System.out.println("🚫 Cadastro de jogo cancelado!");
					continuarCadastro = false;
					break;
				default: 
					   System.out.println("⚠️ Opção inválida!");
			}	
	
		}
	}
	
	//deletar jogo
	public void deletarJogo(Empresa empresa) {
		
		boolean continuarRemocao = true;

		System.out.println("\n╔══════════════════════════════╗");
		System.out.println("║       🗑️ REMOVER JOGO          ║");
		System.out.println("╚══════════════════════════════╝");

		
		while(continuarRemocao) {
			System.out.println("Qual desses jogos voce quer excluir.");
			System.out.print("Digite o nome do jogo:");
			String titulo = sc.nextLine();
			
			//CORRIGIR ISSO
			//para não permitir que uma empresa delete um jogo que não foi cadastrada por ela
			for (Jogo jogo : empresa.getJogosEmpresa()) {
				if (!jogo.getTitulo().equalsIgnoreCase(titulo)) {
					System.out.println("Este jogo não foi cadastrado por essa empresa!");
					continuarRemocao = false;
					break;
				}
			}
			
			//apenas temporário(alana)
			if (continuarRemocao == false) {
				break;
			}
			
			try {
				Jogo resultado = listJogos.procurarNome(titulo);
				System.out.println("O jogo que deseja excluir é "+resultado.getTitulo()+" tem certeza?");
				System.out.println("1️⃣  Sim");
		        System.out.println("2️⃣  Não");
		        System.out.print("👉 Escolha a opção: ");
				int opcao = Integer.parseInt(sc.nextLine());
				sc.nextLine();
				
				switch(opcao) {
					case 1:
						listJogos.deletar(resultado);
						empresa.deletarJogo(resultado);
						System.out.println("O jogo "+resultado.getTitulo()+" foi deletado com sucesso.");
						continuarRemocao = false;
						break;
					case 2:
						System.out.println("Remoção cancelada.");
						break;
					default: 
						System.out.println("Opção invalida.\nInsira um valido:");
						break;
				}
			}catch(DadoNaoEncontradoException e){
				System.out.println("Erro:" +e.getMessage());
				System.out.println("Deseja refazer a remoção");
				System.out.println("1️⃣  Sim");
		        System.out.println("2️⃣  Não");
		        System.out.print("👉 Escolha a opção: ");
				int refazer = Integer.parseInt(sc.nextLine());
				
				if(refazer == 2) {
					continuarRemocao = false; 
				}
			}
		}
	}
	
	//estrutura falta apenas colocar pra receber os dados
	public void alterarDadosDosJogos(Jogo jogo) {
		int opcao =0;
		
		boolean continuarAlterar = true;
		
		while(continuarAlterar) {
			
			menu.telaAlterarJogos(jogo);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			try {
				switch(opcao) {
					case 1:
						System.out.println("Digite o novo titulo do jogo que escolheu:");
						jogo.setTitulo(sc.nextLine());
					case 2:
						System.out.println("Digite o novo preço do jogo que escolheu:");
						jogo.setPreco(sc.nextDouble());
					case 3:
						System.out.println("Digite a nova descrição do jogo que escolheu:");
						jogo.setDescricao(sc.nextLine());
					case 4:
						System.out.println("Digite as novas categorias do jogo que escolheu:");
					case 5:
						System.out.println("Digite a nova classificação etária do jogo que escolheu:");
					case 6:
						System.out.println("Digite os novos idiomas do jogo que escolheu:");
					case 7:
						System.out.println("Digite as novas plataformas disponíveis do jogo que escolheu:");
					case 8:
						System.out.println("Digite a nova data de lançamento do jogo que escolheu:");
					case 9: 
						System.out.println("Voltar para minha conta.");
						continuarAlterar = false;
					default:
						System.out.println("Opção inválida. Digite novamente.");
				}
			}catch(DadoInvalidoException e) {
				System.out.println("Erro: "+ e.getMessage());
			}
			
			System.out.println("Deseja alterar outro dado:");
			System.out.println("1️⃣  Sim");
	        System.out.println("2️⃣  Não");
	        System.out.print("👉 Escolha a opção: ");
			int refazer = Integer.parseInt(sc.nextLine());
			
			if(refazer == 2) {
				continuarAlterar = false;
			}
		}
		}
	
	//Listar todos os jogos da empresa por titulo
	public void ListJogosEmpresa(Empresa empresa) {
		try{
			List<Jogo> jogos = listJogos.procurarEmpresa(empresa);
			System.out.println("Jogos da empresa:");
			for (int i = 0; i < jogos.size(); i++) {
			    System.out.println((i+1) + ". " + jogos.get(i).getTitulo());
			}

		}catch(DadoNaoEncontradoException e) {
			System.out.println("Erro:"+e.getMessage());
			System.out.println("Nenhum jogo cadastrado pra essa empresa.");
		}
	} 
}


	




