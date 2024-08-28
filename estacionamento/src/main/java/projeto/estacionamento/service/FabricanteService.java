package projeto.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.estacionamento.DTO.FabricanteDTO;
import projeto.estacionamento.entities.Fabricante;
import projeto.estacionamento.entities.Status;
import projeto.estacionamento.mapper.FabricanteMapper;
import projeto.estacionamento.repository.FabricanteRepository;
import projeto.estacionamento.repository.StatusRepository;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private FabricanteMapper fabricanteMapper;

    public List<FabricanteDTO> getAllFabricantes() {
        List<Fabricante> fabricantes = fabricanteRepository.findAll();
        return fabricanteMapper.toDTOs(fabricantes);
    }

    public FabricanteDTO getFabricanteById(Long id) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        return fabricante.map(fabricanteMapper::toDTO).orElse(null);
    }

    public FabricanteDTO createFabricante(FabricanteDTO fabricanteDTO) {
        if (fabricanteDTO.getStatus() == null) {
            Status statusAtivo = statusRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Status 'Ativo' não encontrado"));
            fabricanteDTO.setStatus(fabricanteMapper.toStatusDTO(statusAtivo));
        } else {
            Status statusExistente = statusRepository.findById(fabricanteDTO.getStatus().getId())
                .orElseThrow(() -> new IllegalArgumentException("Status informado não encontrado"));
            fabricanteDTO.setStatus(fabricanteMapper.toStatusDTO(statusExistente));
        }
    
        Fabricante fabricante = fabricanteMapper.toEntity(fabricanteDTO);
        fabricante = fabricanteRepository.save(fabricante);
        return fabricanteMapper.toDTO(fabricante);
    }
    

    public FabricanteDTO updateFabricante(Long id, FabricanteDTO fabricanteDTO) {
        if (!fabricanteRepository.existsById(id)) {
            return null;
        }
    
   
        Status statusExistente = statusRepository.findById(fabricanteDTO.getStatus().getId())
            .orElseThrow(() -> new IllegalArgumentException("Status informado não encontrado"));
    
    
        Fabricante fabricanteExistente = fabricanteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Fabricante não encontrado"));
    
        fabricanteExistente.setNome(fabricanteDTO.getNome());
        fabricanteExistente.setPais(fabricanteDTO.getPais());
        fabricanteExistente.setStatus(statusExistente); 
    

        fabricanteExistente = fabricanteRepository.save(fabricanteExistente);
        return fabricanteMapper.toDTO(fabricanteExistente);
    }

    public void deleteFabricante(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
