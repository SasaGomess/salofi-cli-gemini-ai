package br.com.sabrinaweb.saLofi.repository;

import br.com.sabrinaweb.saLofi.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
