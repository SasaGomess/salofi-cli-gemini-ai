package br.com.sabrinaweb.saLofi.application;

import br.com.sabrinaweb.saLofi.services.ArtistaService;
import br.com.sabrinaweb.saLofi.services.MusicaService;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    private void exibeMenu() {
        var menu = """
                    1 - Cadastrar Artistas
                    2 - Cadastrar Músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
              
                    9 - Sair                                 
                    """;

        System.out.println(menu);
    }

    public void menuDeEscolha(App app){
        var opcao = 9;
        do {
            exibeMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    app.cadastrarArtista(sc);
                    break;
                case 2:
                    app.cadastrarMusica(sc);
                    break;
                case 3:
                    app.listarMusicas();
                    break;
                case 4:
                    app.buscarMusicasPorArtista(sc);
                    break;
                case 5:
                    app.pesquisarDadosSobreArtista(sc);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
            }

        }while (opcao != 9);
    }
}
