package br.com.sabrinaweb.saLofi.services;

import br.com.sabrinaweb.saLofi.model.Artista;
import br.com.sabrinaweb.saLofi.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistaService {

    private ArtistaRepository repository;

    public void criaArtista(String nome, String tipo) {
        Artista artista = new Artista(nome, tipo);
        repository.save(artista);
    }

    public Artista achaArtista(String nomeArtista) {
        return repository.findByNomeContainingIgnoreCase(nomeArtista).orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));
    }
}
