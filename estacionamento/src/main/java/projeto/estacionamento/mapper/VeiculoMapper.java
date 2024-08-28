package projeto.estacionamento.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.FabricanteDTO;
import projeto.estacionamento.DTO.ModeloDTO;
import projeto.estacionamento.DTO.StatusDTO;
import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.DTO.VeiculoDTO;
import projeto.estacionamento.entities.Fabricante;
import projeto.estacionamento.entities.Modelo;
import projeto.estacionamento.entities.Tipo;
import projeto.estacionamento.entities.Veiculo;
import projeto.estacionamento.entities.Status;

@Component
public class VeiculoMapper {

    @Autowired
    private ModeloMapper modeloMapper;

    public VeiculoDTO toDTO(Veiculo veiculo) {
        if (veiculo == null) {
            return null;
        }
        return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getPlaca(),
            veiculo.getCor(),
            toModeloDTO(veiculo.getModelo())
        );
    }

    public Veiculo toEntity(VeiculoDTO veiculoDTO) {
        if (veiculoDTO == null) {
            return null;
        }
        return new Veiculo(
            veiculoDTO.getId(),
            veiculoDTO.getPlaca(),
            veiculoDTO.getCor(),
            modeloMapper.toEntity(veiculoDTO.getModelo())
        );
    }

    public ModeloDTO toModeloDTO(Modelo modelo) {
        if (modelo == null) {
            return null;
        }
        return new ModeloDTO(
            modelo.getId(),
            modelo.getNome(),
            toFabricanteDTO(modelo.getFabricante()),
            toTipoDTO(modelo.getTipo())
        );
    }

    public Modelo toEntity(ModeloDTO modeloDTO) {
        if (modeloDTO == null) {
            return null;
        }
        return new Modelo(
            modeloDTO.getId(),
            modeloDTO.getNome(),
            toEntity(modeloDTO.getFabricante()),
            toEntity(modeloDTO.getTipo())
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
            toStatusDTO(fabricante.getStatus()) // Mapeamento do status
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
