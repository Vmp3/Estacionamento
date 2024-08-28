package projeto.estacionamento.mapper;

import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.entities.Tipo;

@Component
public class TipoMapper {

    public TipoDTO toDTO(Tipo tipo) {
        return new TipoDTO(tipo.getId(), tipo.getNome());
    }

    public Tipo toEntity(TipoDTO tipoDTO) {
        return new Tipo(tipoDTO.getId(), tipoDTO.getNome());
    }
}
