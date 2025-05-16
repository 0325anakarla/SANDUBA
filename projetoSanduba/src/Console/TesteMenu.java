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
		
		
		//CLIENTES
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
		
		
		//EMPRESAS
		DadosBancarios bancoKonami = new DadosBancarios("Konami Digital Entertainment", "Mizuho Bank", "Corrente", "1001", "987651");
	    DadosBancarios bancoCapcom = new DadosBancarios("Capcom Co., Ltd.", "Sumitomo Mitsui Banking Corporation", "Corrente", "2002", "543212");
	    DadosBancarios bancoRockstar = new DadosBancarios("Rockstar Games, Inc.", "Bank of America", "Corrente", "3003", "678903");

	    Empresa empresa1 = new Empresa("Konami", "contact@konami.com", "senhaSegura123", "Konami Digital Entertainment Co., Ltd.", "12345678000199", "Tóquio, Japão", bancoKonami);
	    Empresa empresa2 = new Empresa("Capcom", "contact@capcom.com", "senhaFortissima456", "Capcom Co., Ltd.", "98765432000188", "Osaka, Japão", bancoCapcom);
	    Empresa empresa3 = new Empresa("Rockstar Games", "contact@rockstargames.com", "senhaTop789", "Rockstar Games, Inc.", "56789123000177", "Nova York, EUA", bancoRockstar);
		
		//ADM
		Adm adm = Adm.getInstancia("Maria Elizabete", "elizabete@gmail.com", "123", listUsuarios);
		

		
		
		//ADICIONANDO A LISTA DE USUARIOS
		listUsuarios.add(cliente1);
		listUsuarios.add(cliente9);
		listUsuarios.add(cliente3);
		listUsuarios.add(empresa1);
		listUsuarios.add(empresa2);
		listUsuarios.add(empresa3);
		//listUsuarios.add(adm);
		
		//JOGOS
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
