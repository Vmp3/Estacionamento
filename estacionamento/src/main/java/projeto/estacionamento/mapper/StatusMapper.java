package projeto.estacionamento.mapper;

import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.entities.Status;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusMapper {

    public StatusDTO toDTO(Status status) {
        return new StatusDTO(
            status.getId(),
            status.getNomeStatus()
        );
    }

    public Status toEntity(StatusDTO statusDTO) {
        return new Status(
            statusDTO.getId(),
            statusDTO.getNomeStatus()
        );
    }

    public List<StatusDTO> toDTOs(List<Status> statusList) {
        return statusList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
