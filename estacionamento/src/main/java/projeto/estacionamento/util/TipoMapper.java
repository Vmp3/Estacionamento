package projeto.estacionamento.util;

import org.springframework.stereotype.Component;

import projeto.estacionamento.DTO.TipoDTO;
import projeto.estacionamento.entities.Tipo;

@Component
public class TipoMapper {

    public TipoDTO toDTO(Tipo tipo) {
        return new TipoDTO(tipo.getId(), tipo.getNome());
    }

    public Tipo toEntity(TipoDTO tipoDTO) {
        if (tipoDTO == null) {
            return null; 
        }
        Tipo tipo = new Tipo();
        tipo.setId(tipoDTO.getId());
        tipo.setNome(tipoDTO.getNome());
        return tipo;
    }
    
}
