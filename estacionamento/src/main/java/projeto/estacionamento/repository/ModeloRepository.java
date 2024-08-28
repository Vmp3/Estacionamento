package projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.estacionamento.entities.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
