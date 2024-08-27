package projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.estacionamento.entities.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
