package projeto.estacionamento.mapper;

import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.FabricanteDTO;
import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.entities.Fabricante;
import projeto.estacionamento.entities.Status;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricanteMapper {

    public FabricanteDTO toDTO(Fabricante fabricante) {
        if (fabricante == null) {
            return null;
        }
        return new FabricanteDTO(
            fabricante.getId(),
            fabricante.getNome(),
            fabricante.getPais(),
            toStatusDTO(fabricante.getStatus())
        );
    }

    public Fabricante toEntity(FabricanteDTO fabricanteDTO) {
        if (fabricanteDTO == null) {
            return null;
        }
        return new Fabricante(
            fabricanteDTO.getId(),
            fabricanteDTO.getNome(),
            fabricanteDTO.getPais(),
            fabricanteDTO.getStatus() != null ? toEntity(fabricanteDTO.getStatus()) : null
        );
    }

    public List<FabricanteDTO> toDTOs(List<Fabricante> fabricantes) {
        return fabricantes.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public StatusDTO toStatusDTO(Status status) {
        if (status == null) {
            return null;
        }
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
}
