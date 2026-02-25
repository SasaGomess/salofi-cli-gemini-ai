package br.com.sabrinaweb.saLofi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String album;

    public Musica(){
    }

    public Musica( String nome, String album) {
        this.nome = nome;
        this.album = album;
    }

    @ManyToMany()
    @JoinTable(
            name = "musicas_artistas",
            joinColumns = @JoinColumn(name = "id_musicas"),
            inverseJoinColumns = @JoinColumn(name = "id_artista")
    )
    private List<Artista> artistas = new ArrayList<>();

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Musica:" + nome + '\'' +
                ", album: '" + album + '\'' +
                ", artistas: " + artistas;
    }
}
