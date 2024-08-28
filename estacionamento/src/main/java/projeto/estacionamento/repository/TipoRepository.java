package projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.estacionamento.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
}

