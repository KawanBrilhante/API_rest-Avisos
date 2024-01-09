package br.tc.tceac.administracao.controller;
import br.tc.tceac.administracao.Avisos;
import br.tc.tceac.administracao.AvisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AvisosService {

    @Autowired
    private AvisosRepository avisosRepository;

    public List<Avisos> listarTodosAvisos() {
        return avisosRepository.findAll();
    }

    public Avisos buscarAvisosPorId(Long id) {
        Optional<Avisos> aviso = avisosRepository.findById(id);
        return aviso.orElse(null);
    }

    public Avisos criarAvisos(Avisos avisos) {
        avisos.setCriadoEm(LocalDateTime.now());
        avisos.setAtualizadoEm(LocalDateTime.now());
        return avisosRepository.save(avisos);
    }

    public Avisos atualizarAvisos(Long id, Avisos novoAviso) {
        Optional<Avisos> avisoOptional = avisosRepository.findById(id);
        if (avisoOptional.isPresent()) {
            Avisos avisoExistente = avisoOptional.get();
            avisoExistente.setTitulo(novoAviso.getTitulo());
            avisoExistente.setConteudo(novoAviso.getConteudo());
            avisoExistente.setAtualizadoEm(LocalDateTime.now());
            return avisosRepository.save(avisoExistente);
        }
        return null;
    }

    public void deletarAvisos(Long id) {
        avisosRepository.deleteById(id);
    }
}




