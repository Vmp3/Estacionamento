package projeto.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.estacionamento.DTO.VeiculoDTO;
import projeto.estacionamento.entities.Veiculo;
import projeto.estacionamento.repository.VeiculoRepository;
import projeto.estacionamento.util.ValidarPlaca;
import projeto.estacionamento.util.VeiculoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoMapper veiculoMapper;

    public List<VeiculoDTO> getAllVeiculos() {
        return veiculoRepository.findAll().stream()
                .map(veiculoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO getVeiculoById(Long id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        return veiculo.map(veiculoMapper::toDTO).orElse(null);
    }

    public VeiculoDTO createVeiculo(VeiculoDTO veiculoDTO) {
 
        if (!ValidarPlaca.isValid(veiculoDTO.getPlaca())) {
            throw new IllegalArgumentException("Placa inválida. O formato deve ser LLLNNNN ou LLLNLNN.");
        }

        Veiculo veiculo = veiculoMapper.toEntity(veiculoDTO);
        Veiculo novoVeiculo = veiculoRepository.save(veiculo);
        return veiculoMapper.toDTO(novoVeiculo);
    }
    

    public VeiculoDTO updateVeiculo(Long id, VeiculoDTO veiculoDTO) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo veiculo = veiculoExistente.get();
            veiculo.setModelo(veiculoMapper.toEntity(veiculoDTO.getModelo()));
            veiculo.setPlaca(veiculoDTO.getPlaca());
            veiculo.setCor(veiculoDTO.getCor());
            Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);
            return veiculoMapper.toDTO(veiculoAtualizado);
        }
        return null;
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
