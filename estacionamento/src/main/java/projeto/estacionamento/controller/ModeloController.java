package projeto.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.estacionamento.DTO.ModeloDTO;
import projeto.estacionamento.service.ModeloService;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<ModeloDTO> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> getModeloById(@PathVariable Long id) {
        ModeloDTO modelo = modeloService.getModeloById(id);
        if (modelo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelo);
    }
    @PostMapping
    public ResponseEntity<ModeloDTO> createModelo(@RequestBody ModeloDTO modeloDTO) {
        ModeloDTO novoModelo = modeloService.createModelo(modeloDTO);
        return ResponseEntity.ok(novoModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO modeloAtualizado = modeloService.updateModelo(id, modeloDTO);
        if (modeloAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
        return ResponseEntity.noContent().build();
    }
}
