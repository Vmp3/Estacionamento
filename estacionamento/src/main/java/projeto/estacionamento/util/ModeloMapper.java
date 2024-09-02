package projeto.estacionamento.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.FabricanteDTO;
import projeto.estacionamento.DTO.ModeloDTO;
import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.entities.Modelo;
import projeto.estacionamento.entities.Fabricante;
import projeto.estacionamento.entities.Tipo;
import projeto.estacionamento.entities.Status;

@Component
public class ModeloMapper {

    @Autowired
    private FabricanteMapper fabricanteMapper;

    @Autowired
    private TipoMapper tipoMapper;

    public ModeloDTO toDTO(Modelo modelo) {
        if (modelo == null) {
            return null;
        }
        return new ModeloDTO(
            modelo.getId(),
            modelo.getNome(),
            fabricanteMapper.toDTO(modelo.getFabricante()),
            tipoMapper.toDTO(modelo.getTipo())
        );
    }

    public Modelo toEntity(ModeloDTO modeloDTO) {
        if (modeloDTO == null) {
            return null;
        }
        return new Modelo(
            modeloDTO.getId(),
            modeloDTO.getNome(),
            fabricanteMapper.toEntity(modeloDTO.getFabricante()),
            tipoMapper.toEntity(modeloDTO.getTipo())
        );
    }

    public FabricanteDTO toFabricanteDTO(Fabricante fabricante) {
        if (fabricante == null) {
            return null;
        }
        return new FabricanteDTO(
            fabricante.getId(),
            fabricante.getNome(),
            fabricante.getPais(),
            fabricante.getStatus() != null ? toStatusDTO(fabricante.getStatus()) : null // Mapeamento do status
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

    public TipoDTO toTipoDTO(Tipo tipo) {
        if (tipo == null) {
            return null;
        }
        return new TipoDTO(
            tipo.getId(),
            tipo.getNome()
        );
    }

    public Tipo toEntity(TipoDTO tipoDTO) {
        if (tipoDTO == null) {
            return null;
        }
        return new Tipo(
            tipoDTO.getId(),
            tipoDTO.getNome()
        );
    }

    public StatusDTO toStatusDTO(Status status) {
        if (status == null) {
            return null;
        }
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
}
