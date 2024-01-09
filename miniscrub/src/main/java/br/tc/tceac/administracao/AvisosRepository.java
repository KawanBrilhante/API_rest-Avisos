package br.tc.tceac.administracao;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AvisosRepository {
    private Map<Integer, Aviso> listaAvisos;

    public AvisosRepository() {
        listaAvisos = new HashMap<>();
        listaAvisos.put(1, new Aviso("", true));

    }

    public String obterAvisoPorId(int idAviso) {
        Aviso aviso = listaAvisos.get(idAviso);
        if (aviso != null && aviso.isAtivo()) {
            return aviso.getConteudo();
        } else {
            return "Aviso não encontrado ou inativo";
        }
    }

    public void salvarAviso(int idAviso, String conteudo, boolean ativo) {
        listaAvisos.put(idAviso, new Aviso(conteudo, ativo));
    }

    public void desativarAviso(int idAviso) {
        Aviso aviso = listaAvisos.get(idAviso);
        if (aviso != null) {
            aviso.setAtivo(false);
        }
    }

    private static class Aviso {
        private String conteudo;
        private boolean ativo;

        public Aviso(String conteudo, boolean ativo) {
            this.conteudo = conteudo;
            this.ativo = ativo;
        }

        public String getConteudo() {
            return conteudo;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }
}


