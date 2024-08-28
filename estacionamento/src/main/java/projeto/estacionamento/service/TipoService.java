package projeto.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.entities.Tipo;
import projeto.estacionamento.mapper.TipoMapper;
import projeto.estacionamento.repository.TipoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private TipoMapper tipoMapper;

    public List<TipoDTO> getAllTipos() {
        return tipoRepository.findAll().stream()
                .map(tipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TipoDTO getTipoById(Long id) {
        Optional<Tipo> tipo = tipoRepository.findById(id);
        return tipo.map(tipoMapper::toDTO).orElse(null);
    }

    public TipoDTO createTipo(TipoDTO tipoDTO) {
        Tipo tipo = tipoMapper.toEntity(tipoDTO);
        Tipo novoTipo = tipoRepository.save(tipo);
        return tipoMapper.toDTO(novoTipo);
    }

    public TipoDTO updateTipo(Long id, TipoDTO tipoDTO) {
        Optional<Tipo> tipoExistente = tipoRepository.findById(id);
        if (tipoExistente.isPresent()) {
            Tipo tipo = tipoExistente.get();
            tipo.setNome(tipoDTO.getNome());
            Tipo tipoAtualizado = tipoRepository.save(tipo);
            return tipoMapper.toDTO(tipoAtualizado);
        }
        return null;
    }

    public void deleteTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}
