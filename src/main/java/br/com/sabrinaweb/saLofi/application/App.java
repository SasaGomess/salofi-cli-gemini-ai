package br.com.sabrinaweb.saLofi.application;

import br.com.sabrinaweb.saLofi.model.Artista;
import br.com.sabrinaweb.saLofi.model.Musica;
import br.com.sabrinaweb.saLofi.model.TipoArtista;
import br.com.sabrinaweb.saLofi.services.ArtistaService;
import br.com.sabrinaweb.saLofi.services.GeminiChatService;
import br.com.sabrinaweb.saLofi.services.MusicaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private ArtistaService artistaService;
    private MusicaService musicaService;
    private GeminiChatService chatService;

    public App(ArtistaService artistaService, MusicaService musicaService, GeminiChatService chatService) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
        this.chatService = chatService;
    }

    public void cadastrarArtista(Scanner sc){
        char resp;
        do{
            System.out.println("Informe o nome do artista");
            var nome = sc.nextLine();
            System.out.println("Informe o tipo desse artista: (solo/dupla/grupo/banda)");
            var tipo = sc.nextLine();
            artistaService.criaArtista(nome, tipo);

            System.out.println("Deseja cadastrar mais um artista? (s/n)");
            resp = sc.nextLine().charAt(1);
        }while (resp != 'n');
    }

    public void cadastrarMusica(Scanner sc) {
        System.out.println("Digite a quantidade de artista dessa música ");
        var qtdArtistas = sc.nextInt();
        sc.nextLine();

        List<Artista> artistas = new ArrayList<>();

        for (int i = 1; i < qtdArtistas; i++) {
            System.out.println("Digite o nome do" + i + "° Artista: ");
            var nomeArtista = sc.nextLine();

            try{
                Artista artista = artistaService.achaArtista(nomeArtista);
                artistas.add(artista);
            }catch (IllegalArgumentException e){
                System.out.println("Erro, artista não encontrado = " + e.getMessage());;
            }
        }

        System.out.println("Qual é o nome da música?");
        var nome = sc.nextLine();

        System.out.println("Qual é o nome do albúm?");
        var album = sc.nextLine();

        musicaService.criaMusica(nome, album, artistas);
    }

    public void listarMusicas() {
        musicaService.listarMusicas().forEach(System.out::println);
    }

    public void buscarMusicasPorArtista(Scanner sc) {
        System.out.println("Digite o nome do artista para buscar");
        var nomeArtista = sc.nextLine();

        List<Musica> musicas = musicaService.acharMusicasPeloArtista(nomeArtista);

        musicas.forEach(System.out::println);
    }

    public void pesquisarDadosSobreArtista(Scanner sc) {
        System.out.println("Digite o nome do artista que deseja pesquisar: ");
        var nomeParaPesquisa = sc.nextLine();
        var mensagem = "Me dê um breve resumo sobre quem é o/a artista: " + nomeParaPesquisa;
        chatService.chat(mensagem);
    }

}
