package projeto.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.estacionamento.DTO.ModeloDTO;
import projeto.estacionamento.entities.Modelo;
import projeto.estacionamento.service.ModeloService;

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

    @GetMapping("/por-pais")
    public ResponseEntity<List<Modelo>> getModelosByPais(@RequestParam String pais) {
        List<Modelo> modelos = modeloService.findByFabricantePais(pais);
        if (modelos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelos);
    }
    @GetMapping("/por-teste")
    public ResponseEntity<List<Modelo>> findModelosByFabricantePais(@RequestParam String pais) {
        List<Modelo> modelos = modeloService.findModelosByFabricantePais(pais);
        if (modelos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelos);
    }
}
