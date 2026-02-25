package br.com.sabrinaweb.saLofi.services;

import br.com.sabrinaweb.saLofi.model.Artista;
import br.com.sabrinaweb.saLofi.model.Musica;
import br.com.sabrinaweb.saLofi.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    private MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    public void criaMusica(String nomeMusica, String album, List<Artista> artistas){
        Musica musica = new Musica(nomeMusica, album);

        musica.setArtistas(artistas);

        repository.save(musica);
    }

    public List<Musica> listarMusicas() {
        return repository.findAll();
    }

    public List<Musica> acharMusicasPeloArtista(String nomeArtista) {
        return repository.achaMusicaPeloArtista(nomeArtista);
    }
}
