package br.tc.tceac.administracao;

public class AvisosNotFoundException extends RuntimeException {

    AvisosNotFoundException(Long id) {
        super("Aviso não encontrado " + id);
    }
}
