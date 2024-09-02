package projeto.estacionamento.util;

import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.entities.Status;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusMapper {

    public StatusDTO toDTO(Status status) {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(status.getId());
        statusDTO.setNomeStatus(status.getNomeStatus());
        return statusDTO;
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
