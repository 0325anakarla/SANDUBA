package Console;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Financeiro.CartaoDeCredito;
import Financeiro.CarteiraDoCliente;
import Financeiro.DadosBancarios;
import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import TratamentoDeErro.DadoInvalidoException;



import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import funcionalidades.ControleDeCadastros;
import funcionalidades.ControleDeJogos;
import jogo.CategoriasJogos;
import jogo.ClassificacaoIndicativa;
import jogo.Idiomas;
import jogo.Jogo;
import jogo.PlataformasDisponiveis;

public class TesteMenu {
	
	

	public static void main(String[] args) throws DadoInvalidoException {
		Scanner sc = new Scanner(System.in);
		
		//INSTANCIAS
		VisualizacaoMenu visualizacaoMenu = new VisualizacaoMenu();
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		
		//REPOSITORIOS
		RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList(sc);
		RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
		
		//OBJETOS CRIADOS
		
		
		//CLIENTES---------------------------------------------------------------------------
		Cliente cliente1 = new Cliente("Lana", "lana@gmail.com", "1234", "12345678901", LocalDate.of(2004, 9, 23));
		CarteiraDoCliente cdC1 = new CarteiraDoCliente();
		cliente1.setCarteiraDigital(cdC1);
		CartaoDeCredito cartao = new CartaoDeCredito("lana", "1234567891234567", LocalDate.of(2035, 8, 12), 547);
		cliente1.addCartaoDeCredito(cartao);
		
		Cliente cliente2 = new Cliente("Rebeca", "rebeca@gmail.com", "5678", "98765432190", LocalDate.of(2006, 4, 30));
		CarteiraDoCliente cdC2 = new CarteiraDoCliente();
		cliente2.setCarteiraDigital(cdC2);
		Cliente cliente3 = new Cliente("Ana Alice", "alice@gmail.com", "9012", "01234567891", LocalDate.of(2003, 8, 12));
		CarteiraDoCliente cdC3 = new CarteiraDoCliente();
		cliente3.setCarteiraDigital(cdC3);
		
//		clienteteste
		Cliente cliente9 = new Cliente("Jurema", "Jurema@gmail.com", "123", "98765432191", LocalDate.of(2013, 4, 30));
		CarteiraDoCliente cdC9 = new CarteiraDoCliente();
		cliente9.setCarteiraDigital(cdC9);
		
		
		//EMPRESAS----------------------------------------------------------------
		DadosBancarios bancoSega = new DadosBancarios("Sega Corporation", "Sega Bank", "Corrente", "5031", "873423");
		DadosBancarios bancoKonami = new DadosBancarios("Konami Digital Entertainment", "Mizuho Bank", "Corrente", "1001", "987651");
	    DadosBancarios bancoCapcom = new DadosBancarios("Capcom Co., Ltd.", "Sumitomo Mitsui Banking Corporation", "Corrente", "2002", "543212");
	    DadosBancarios bancoRockstar = new DadosBancarios("Rockstar Games, Inc.", "Bank of America", "Corrente", "3003", "678903");
	    DadosBancarios bancoActivision = new DadosBancarios("Activision Blizzard, Inc.", "Bank of America", "Corrente", "4455", "998877");
	    DadosBancarios bancoNintendo = new DadosBancarios("Nintendo Co., Ltd.", "Mitsubishi UFJ Bank", "Corrente", "7890", "112233");

	    
	    
	    Empresa empresa1 = new Empresa("Konami", "contact@konami.com", "senhaSegura123", "Konami Digital Entertainment Co., Ltd.", "12345678000199", "Tóquio, Japão", bancoKonami);
	    Empresa empresa2 = new Empresa("Capcom", "contact@capcom.com", "senhaFortissima456", "Capcom Co., Ltd.", "98765432000188", "Osaka, Japão", bancoCapcom);
	    Empresa empresa3 = new Empresa("Rockstar Games", "contact@rockstargames.com", "senhaTop789", "Rockstar Games, Inc.", "56789123000177", "Nova York, EUA", bancoRockstar);
	    Empresa empresa4 = new Empresa("Sega","contact@sega.com","senhaMassa321","SEGA CORPORATION","12333419900333", "Tóquio, Japão", bancoSega);
	    Empresa empresa5 = new Empresa("Activision Blizzard", "contato@activisionblizzard.com", "senhaForte456", "Activision Blizzard, Inc.", "11223344000155", "Santa Monica, Califórnia, EUA", bancoActivision);
	    Empresa empresa6 = new Empresa("Nintendo", "contato@nintendo.co.jp", "senhaNintendo123", "Nintendo Co., Ltd.", "99887766000144", "Kyoto, Japão", bancoNintendo);
	    
	    //ADM----------------------------------------------------------------------------------------------
		Adm adm = Adm.getInstancia("Maria Elizabete", "elizabete@gmail.com", "123", listUsuarios);
		

		
		
		//ADICIONANDO A LISTA DE USUARIOS
		listUsuarios.add(cliente1);
		listUsuarios.add(cliente9);
		listUsuarios.add(cliente3);
		listUsuarios.add(empresa1);
		listUsuarios.add(empresa2);
		listUsuarios.add(empresa3);
		//listUsuarios.add(adm);
		
		//JOGOS-----------------------------------------------
		
		//Super Mario Bros
		Jogo superMarioBros = new Jogo(
			    "Super Mario Bros.",
			    99.90,
			    "Clássico jogo de plataforma onde Mario deve salvar a princesa Peach do Bowser.",
			    new ArrayList<>(List.of(CategoriasJogos.TERCEIRAPESSOA, CategoriasJogos.AVENTURA,CategoriasJogos.FANTASIA)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES, Idiomas.FRANCES,Idiomas.ALEMAO,Idiomas.CHINES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.NINTENDO, PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.LINUX,PlataformasDisponiveis.ANDROID,PlataformasDisponiveis.MACOS)),
			    ClassificacaoIndicativa.LIVRE,
			    empresa6,
			    LocalDate.of(1985, 9, 13));
		listJogos.add(superMarioBros);
		empresa2.atualizarJogos(superMarioBros);

		Jogo pokemon = new Jogo(
		    "Pokémon Scarlet",
		    249.90,
		    "Explore a região de Paldea, capture Pokémon e torne-se o melhor treinador!",
		    new ArrayList<>(List.of(CategoriasJogos.RPG, CategoriasJogos.AVENTURA,CategoriasJogos.FANTASIA,CategoriasJogos.MUNDOABERTO)),
		    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES, Idiomas.ALEMAO,Idiomas.CHINES)),
		    new ArrayList<>(List.of(PlataformasDisponiveis.NINTENDO, PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.LINUX,PlataformasDisponiveis.ANDROID,PlataformasDisponiveis.MACOS)),
		    ClassificacaoIndicativa.LIVRE,
		    empresa6,
		    LocalDate.of(2022, 11, 18));
		listJogos.add(pokemon);
		empresa2.atualizarJogos(pokemon);
		
		//Animal Crossing
		Jogo animalCrossing = new Jogo(
		    "Animal Crossing: New Horizons",
		    199.90,
		    "Um simulador de vida onde você cria sua ilha dos sonhos, faz amigos e decora seu lar.",
		    new ArrayList<>(List.of(CategoriasJogos.MUNDOABERTO, CategoriasJogos.AVENTURA)),
		    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
		    new ArrayList<>(List.of(PlataformasDisponiveis.NINTENDO)),
		    ClassificacaoIndicativa.LIVRE,
		    empresa6,
		    LocalDate.of(2020, 3, 20));
		listJogos.add(animalCrossing);
		empresa2.atualizarJogos(animalCrossing);
		
		//Yoshii
		Jogo yoshisCraftedWorld = new Jogo(
		    "Yoshi's Crafted World",
		    179.90,
		    "Um colorido jogo de plataforma onde Yoshi atravessa mundos feitos de materiais artesanais.",
		    new ArrayList<>(List.of(CategoriasJogos.PUZZLE, CategoriasJogos.MUNDOABERTO)),
		    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES, Idiomas.ESPANHOL)),
		    new ArrayList<>(List.of(PlataformasDisponiveis.NINTENDO)),
		    ClassificacaoIndicativa.LIVRE,
		    empresa6,
		    LocalDate.of(2019, 3, 29));
		listJogos.add(yoshisCraftedWorld);
		empresa2.atualizarJogos(yoshisCraftedWorld);

		//DIABLO
		Jogo diablo = new Jogo(
			    "Diablo IV",
			    349.90,
			    "Um RPG de ação sombrio onde os jogadores enfrentam demônios em masmorras profundas e desafiadoras.",
			    new ArrayList<>(List.of(CategoriasJogos.RPG, CategoriasJogos.ACAO)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.PS4, PlataformasDisponiveis.XBOX)),
			    ClassificacaoIndicativa.ANOS18,
			    empresa5,
			    LocalDate.of(2023, 6, 5));
		listJogos.add(diablo);
		empresa2.atualizarJogos(diablo);
		//Call of Duty
		Jogo callOfDuty = new Jogo(
			    "Call of Duty: Modern Warfare",
			    299.90,
			    "Um intenso jogo de tiro em primeira pessoa com foco em realismo e combate moderno.",
			    new ArrayList<>(List.of(CategoriasJogos.TIRO, CategoriasJogos.ACAO)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.PS4, PlataformasDisponiveis.XBOX)),
			    ClassificacaoIndicativa.ANOS16,
			    empresa5,
			    LocalDate.of(2019, 10, 25));
		listJogos.add(callOfDuty);
		empresa2.atualizarJogos(callOfDuty);
		
		//OSU 
		Jogo osu = new Jogo(
			    "Osu",
			    19.00,
			    "Um jogo de ritmo musical para grande diversão!!",
			    new ArrayList<>(List.of(CategoriasJogos.RITMO, CategoriasJogos.TURNO)),
			    new ArrayList<>(List.of(Idiomas.INGLES,Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.LINUX, PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.MACOS)),
			    ClassificacaoIndicativa.ANOS10,
			    empresa1,
			    LocalDate.of(2007, 9, 16)
			);
		listJogos.add(osu);
		empresa2.atualizarJogos(osu);
		
		// Bayonetta
		Jogo bayonetta = new Jogo(
			    "Bayonetta",
			    129.90,
			    "Bayonetta é um eletrizante jogo de ação em terceira pessoa, onde você controla uma poderosa bruxa enfrentando anjos com estilo e combos espetaculares.",
			    new ArrayList<>(List.of(CategoriasJogos.ACAO)),
			    new ArrayList<>(List.of(Idiomas.INGLES,Idiomas.ALEMAO,Idiomas.PORTUGUES,Idiomas.CHINES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.PS4, PlataformasDisponiveis.XBOX, PlataformasDisponiveis.NINTENDO)),
			    ClassificacaoIndicativa.ANOS18,
			    empresa4,
			    LocalDate.of(2009, 10, 29));
		listJogos.add(bayonetta);
		empresa2.atualizarJogos(bayonetta);
		
		// A Way Out
		Jogo  aWayOut = new Jogo(
				"A Way Out",
				89.00,
				"A Way Out é uma experiência que deve ser vivida por dois jogadores.",
				new ArrayList<>(List.of(CategoriasJogos.PUZZLE)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS)),
			    ClassificacaoIndicativa.ANOS16,
			    empresa2,
			    LocalDate.of(2018, 3, 23)
				);
		listJogos.add(aWayOut);
		empresa2.atualizarJogos(aWayOut);
		
		// The Last of Us Part I
		Jogo theLastOfUsPartI = new Jogo(
			    "The Last of Us Part I",
			    199.90,
			    "Um jogo de ação e sobrevivência em um mundo pós-apocalíptico.",
			    new ArrayList<>(List.of(CategoriasJogos.ACAO, CategoriasJogos.AVENTURA)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.PS4, PlataformasDisponiveis.WINDOWS)),
			    ClassificacaoIndicativa.ANOS18,
			    empresa2,
			    LocalDate.of(2013, 6, 14)
			);

			listJogos.add(theLastOfUsPartI);
			empresa2.atualizarJogos(theLastOfUsPartI);


		// The Last of Us Part II
		Jogo theLastOfUs2 = new Jogo(
			    "The Last of Us Part II",
			    249.90,
			    "A sequência da jornada de Ellie em busca de vingança.",
			    new ArrayList<>(List.of(CategoriasJogos.ACAO, CategoriasJogos.AVENTURA)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.PS5)),
			    ClassificacaoIndicativa.ANOS18,
			    empresa2,
			    LocalDate.of(2020, 6, 19)
			);

			listJogos.add(theLastOfUs2);
			empresa2.atualizarJogos(theLastOfUs2);

		// Minecraft
		Jogo minecraft = new Jogo(
			    "Minecraft",
			    99.90,
			    "Jogo de construção em mundo aberto com blocos.",
			    new ArrayList<>(List.of(CategoriasJogos.MUNDOABERTO, CategoriasJogos.PUZZLE)),
			    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.XBOX, PlataformasDisponiveis.NINTENDO)),
			    ClassificacaoIndicativa.LIVRE,
			    empresa3,
			    LocalDate.of(2011, 11, 18)
			);

			listJogos.add(minecraft);
			empresa3.atualizarJogos(minecraft);

		// Undertale
		Jogo undertale = new Jogo(
			    "Undertale",
			    39.99,
			    "Um RPG único onde você não precisa matar ninguém.",
			    new ArrayList<>(List.of(CategoriasJogos.RPG, CategoriasJogos.PUZZLE)),
			    new ArrayList<>(List.of(Idiomas.INGLES)),
			    new ArrayList<>(List.of(PlataformasDisponiveis.LINUX, PlataformasDisponiveis.PS4, PlataformasDisponiveis.NINTENDO)),
			    ClassificacaoIndicativa.ANOS10,
			    empresa1,
			    LocalDate.of(2015, 9, 15)
			);

			listJogos.add(undertale);
			empresa1.atualizarJogos(undertale);

		// Baldur’s Gate 3
			Jogo baldursGate3 = new Jogo(
				    "Baldur's Gate 3",
				    299.90,
				    "RPG baseado em Dungeons & Dragons.",
				    new ArrayList<>(List.of(CategoriasJogos.RPG, CategoriasJogos.AVENTURA)),
				    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
				    new ArrayList<>(List.of(PlataformasDisponiveis.MACOS, PlataformasDisponiveis.PS5)),
				    ClassificacaoIndicativa.ANOS18,
				    empresa3,
				    LocalDate.of(2023, 8, 3)
				);

				listJogos.add(baldursGate3);
				empresa3.atualizarJogos(baldursGate3);

		// GTA V
			Jogo gtaV = new Jogo(
				    "Grand Theft Auto V",
				    79.99,
				    "Jogo de ação em mundo aberto com múltiplos protagonistas.",
				    new ArrayList<>(List.of(CategoriasJogos.ACAO, CategoriasJogos.MUNDOABERTO)),
				    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
				    new ArrayList<>(List.of(PlataformasDisponiveis.WINDOWS, PlataformasDisponiveis.PS4, PlataformasDisponiveis.XBOX)),
				    ClassificacaoIndicativa.ANOS18,
				    empresa3,
				    LocalDate.of(2013, 9, 17)
				);

				listJogos.add(gtaV);
				empresa3.atualizarJogos(gtaV);

		// Silent Hill 2
			Jogo jogoSilentHill = new Jogo(
				    "Silent Hill 2",
				    49.90,
				    "Clássico jogo de terror psicológico.",
				    new ArrayList<>(List.of(CategoriasJogos.HORROR, CategoriasJogos.AVENTURA)),
				    new ArrayList<>(List.of(Idiomas.INGLES)),
				    new ArrayList<>(List.of(PlataformasDisponiveis.PS5, PlataformasDisponiveis.WINDOWS)),
				    ClassificacaoIndicativa.ANOS18,
				    empresa2,
				    LocalDate.of(2001, 9, 24)
				);

				listJogos.add(jogoSilentHill);
				empresa2.atualizarJogos(jogoSilentHill);

		// Resident Evil 4
			Jogo novoJogo = new Jogo(
				    "Resident Evil 4",
				    59.99,
				    "Leon Kennedy luta contra ameaças biológicas em uma vila misteriosa.",
				    new ArrayList<>(List.of(CategoriasJogos.HORROR, CategoriasJogos.ACAO)),
				    new ArrayList<>(List.of(Idiomas.INGLES, Idiomas.PORTUGUES)),
				    new ArrayList<>(List.of(PlataformasDisponiveis.LINUX, PlataformasDisponiveis.PS4, PlataformasDisponiveis.XBOX, PlataformasDisponiveis.NINTENDO)),
				    ClassificacaoIndicativa.ANOS18,
				    empresa1,
				    LocalDate.of(2005, 1, 11)
				);

				listJogos.add(novoJogo);
				empresa1.atualizarJogos(novoJogo); 
				
				
		//CONTROLES
		ControleDeJogos controleJogos = new ControleDeJogos(sc, visualizacaoMenu, listJogos);
		ControleDeCadastros controleCadastros = new ControleDeCadastros(sc, listUsuarios);
		
		//TELAS
		TelaCliente telaCliente = new TelaCliente(sc, visualizacaoMenu);
		TelaEmpresa telaEmpresa = new TelaEmpresa(sc, visualizacaoMenu, listJogos, controleJogos);
		TelaAdm telaAdm = new TelaAdm(sc, visualizacaoMenu, adm, listUsuarios, listJogos, controleJogos);
		BibliotecaJogos bibJogos = new BibliotecaJogos(sc, carrinho, listJogos, telaCliente, controleJogos);
		TelaCarrinhoDeCompras mostrarCarrinho = new TelaCarrinhoDeCompras(sc, bibJogos, telaCliente);
		bibJogos.setMostrarCarrinho(mostrarCarrinho);
		TelaListaDeDesejos telaListaDeDesejos = new TelaListaDeDesejos(sc, carrinho, mostrarCarrinho, telaCliente);
		telaCliente.setTelaListaDeDesejos(telaListaDeDesejos);
		telaCliente.setBibliotecaJogos(bibJogos);
		
		//INICIALIZACAO DO MENU
		Menu menu = new Menu(sc, listUsuarios, controleCadastros, bibJogos, telaEmpresa, telaAdm);

		controleCadastros.setMenu(menu);
		telaEmpresa.setMenu(menu); 
		bibJogos.setMenu(menu);
		telaAdm.setMenu(menu);
		menu.start();
	}

}
