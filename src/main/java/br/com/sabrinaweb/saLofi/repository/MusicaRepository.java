package br.com.sabrinaweb.saLofi.repository;

import br.com.sabrinaweb.saLofi.model.Artista;
import br.com.sabrinaweb.saLofi.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    @Query("SELECT m FROM Musica m JOIN m.artistas a WHERE a.nome ILIKE :nomeArtista")
    List<Musica> achaMusicaPeloArtista(@Param("nomeArtista") String nomeArtista);
}
