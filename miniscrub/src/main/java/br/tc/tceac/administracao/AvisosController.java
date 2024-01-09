package br.tc.tceac.administracao;

import br.tc.tceac.administracao.controller.AvisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avisos")
public class AvisosController {

    @Autowired
    private AvisosService avisosService;

    @GetMapping
    public ResponseEntity<Object> listarTodosAvisos() {
        List<Avisos> avisos = avisosService.listarTodosAvisos();
        return ResponseEntity.ok(avisos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avisos> buscarAvisosPorId(@PathVariable Long id) {
        Avisos aviso = avisosService.buscarAvisosPorId(id);
        return aviso != null ? ResponseEntity.ok(aviso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Avisos> criarAvisos(@RequestBody Avisos avisos) {
        Avisos novoAviso = avisosService.criarAvisos(avisos);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAviso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avisos> atualizarAvisos(@PathVariable Long id, @RequestBody Avisos avisos) {
        Avisos avisoAtualizado = avisosService.atualizarAvisos(id, avisos);
        return avisoAtualizado != null ? ResponseEntity.ok(avisoAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAvisos(@PathVariable Long id) {
        avisosService.deletarAvisos(id);
        return ResponseEntity.noContent().build();
    }
}
