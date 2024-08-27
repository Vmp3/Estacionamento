package projeto.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.entities.Status;
import projeto.estacionamento.mapper.StatusMapper;
import projeto.estacionamento.repository.StatusRepository;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StatusMapper statusMapper;

    public List<StatusDTO> getAllStatus() {
        List<Status> statusList = statusRepository.findAll();
        return statusMapper.toDTOs(statusList);
    }

    public StatusDTO getStatusById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.map(statusMapper::toDTO).orElse(null);
    }

    public StatusDTO createStatus(StatusDTO statusDTO) {
        Status status = statusMapper.toEntity(statusDTO);
        status = statusRepository.save(status);
        return statusMapper.toDTO(status);
    }

    public StatusDTO updateStatus(Long id, StatusDTO statusDTO) {
        if (!statusRepository.existsById(id)) {
            return null;
        }
        statusDTO.setId(id);
        Status status = statusMapper.toEntity(statusDTO);
        status = statusRepository.save(status);
        return statusMapper.toDTO(status);
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
