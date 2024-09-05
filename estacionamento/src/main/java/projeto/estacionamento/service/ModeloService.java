package projeto.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.estacionamento.DTO.ModeloDTO;
import projeto.estacionamento.entities.Modelo;
import projeto.estacionamento.repository.ModeloRepository;
import projeto.estacionamento.util.ModeloMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModeloMapper modeloMapper;

    public List<ModeloDTO> getAllModelos() {
        return modeloRepository.findAll().stream()
                .map(modeloMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ModeloDTO getModeloById(Long id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        return modelo.map(modeloMapper::toDTO).orElse(null);
    }

    public List<Modelo> findByFabricantePais(String pais) {
        return modeloRepository.findByFabricantePais(pais);
    }
    public List<Modelo> findModelosByFabricantePais(String pais) {
        return modeloRepository.findModelosByFabricantePais(pais);
    }

    public ModeloDTO createModelo(ModeloDTO modeloDTO) {
        Modelo modelo = modeloMapper.toEntity(modeloDTO);
        Modelo novoModelo = modeloRepository.save(modelo);
        return modeloMapper.toDTO(novoModelo);
    }

    public ModeloDTO updateModelo(Long id, ModeloDTO modeloDTO) {
        Optional<Modelo> modeloExistente = modeloRepository.findById(id);
        if (modeloExistente.isPresent()) {
            Modelo modelo = modeloExistente.get();
            modelo.setNome(modeloDTO.getNome());
            modelo.setFabricante(modeloMapper.toEntity(modeloDTO.getFabricante()));
            modelo.setTipo(modeloMapper.toEntity(modeloDTO.getTipo()));
            Modelo modeloAtualizado = modeloRepository.save(modelo);
            return modeloMapper.toDTO(modeloAtualizado);
        }
        return null;
    }

    public void deleteModelo(Long id) {
        modeloRepository.deleteById(id);
    }
}
