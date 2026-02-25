package br.com.sabrinaweb.saLofi.model;

import java.util.List;

public enum TipoArtista {
    SOLO("Solo"),
    DUPLA("Dubla"),
    GRUPO("Grupo"),
    BANDA("Banda");

    private String valorDoTipo;

    TipoArtista(String tipoDoArtisa){
        this.valorDoTipo = tipoDoArtisa;
    }

    public static TipoArtista covertString(String tipoArtista) {
        for (TipoArtista tipo : TipoArtista.values()){
            if (tipo.valorDoTipo.equalsIgnoreCase(tipoArtista)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo do artista inválido");
    }
}
