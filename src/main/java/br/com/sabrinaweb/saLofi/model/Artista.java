package br.com.sabrinaweb.saLofi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;

    public Artista() {
    }

    public Artista(String nome, String tipoArtista) {
        this.nome = nome;
        this.tipoArtista = TipoArtista.valueOf(tipoArtista.toUpperCase());
    }

    @ManyToMany(mappedBy = "artistas")
    private List<Musica> musicas = new ArrayList<>();

    public List<Musica> getMusicas() {
        return musicas;
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

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    @Override
    public String toString() {
        return "Artista: " +  nome + '\'' +
                ", tipo do Artista:" + tipoArtista;
    }
}
