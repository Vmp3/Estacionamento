package projeto.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusDTO> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStatusById(@PathVariable Long id) {
        StatusDTO status = statusService.getStatusById(id);
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<StatusDTO> createStatus(@RequestBody StatusDTO statusDTO) {
        StatusDTO novoStatus = statusService.createStatus(statusDTO);
        return ResponseEntity.ok(novoStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        StatusDTO statusAtualizado = statusService.updateStatus(id, statusDTO);
        return ResponseEntity.ok(statusAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
