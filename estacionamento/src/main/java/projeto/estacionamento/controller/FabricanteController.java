package projeto.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.estacionamento.DTO.FabricanteDTO;
import projeto.estacionamento.entities.Fabricante;
import projeto.estacionamento.service.FabricanteService;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public List<FabricanteDTO> getAllFabricantes() {
        return fabricanteService.getAllFabricantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> getFabricanteById(@PathVariable Long id) {
        FabricanteDTO fabricante = fabricanteService.getFabricanteById(id);
        if (fabricante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> createFabricante(@RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO novoFabricante = fabricanteService.createFabricante(fabricanteDTO);
        return ResponseEntity.ok(novoFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> updateFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO fabricanteAtualizado = fabricanteService.updateFabricante(id, fabricanteDTO);
        if (fabricanteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fabricanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Long id) {
        fabricanteService.deleteFabricante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pais")
    public ResponseEntity<List<Fabricante>> buscarFabricantesPorPais(@RequestParam String pais) {
        List<Fabricante> fabricantes = fabricanteService.buscarFabricantesPorPais(pais);
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/sub")
    public ResponseEntity<List<Fabricante>> getFabricantesByPais(@RequestParam String pais) {
        List<Fabricante> fabricantes = fabricanteService.findByPaisContaining(pais);
        if (fabricantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(fabricantes);
        }
    }
}
