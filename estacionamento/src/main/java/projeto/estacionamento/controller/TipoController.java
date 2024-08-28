package projeto.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.service.TipoService;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<TipoDTO> getAllTipos() {
        return tipoService.getAllTipos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> getTipoById(@PathVariable Long id) {
        TipoDTO tipo = tipoService.getTipoById(id);
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipo);
    }

    @PostMapping
    public ResponseEntity<TipoDTO> createTipo(@RequestBody TipoDTO tipoDTO) {
        TipoDTO novoTipo = tipoService.createTipo(tipoDTO);
        return ResponseEntity.ok(novoTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> updateTipo(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
        TipoDTO tipoAtualizado = tipoService.updateTipo(id, tipoDTO);
        if (tipoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        tipoService.deleteTipo(id);
        return ResponseEntity.noContent().build();
    }
}
